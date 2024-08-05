package io.github.tmgg.kettle.sdk;

import cn.moon.lang.json.XmlTool;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.kevinsawicki.http.HttpRequest;
import io.github.tmgg.kettle.sdk.response.SlaveServerStatus;
import io.github.tmgg.kettle.sdk.response.WebResult;

import java.util.Collections;
import java.util.Map;

/**
 * reference
 * https://javadoc.pentaho.com/kettle930/kettle-engine-9.3.0.0-424-javadoc/org/pentaho/di/www/package-summary.html
 */
public class KettleSdk {

    private String baseUrl;
    private String username;
    private String password;

    private String rep;


    public KettleSdk(String url, String repo, String username, String password) {
        this.baseUrl = url;
        this.rep = repo;
        this.username = username;
        this.password = password;
    }


    /**
     * Get the status of the server
     */
    public SlaveServerStatus status() {
        String url = baseUrl + "/kettle/status?xml=Y";
        String body = HttpRequest.get(url).basic(username, password).body();
        System.out.println(body);

        try {
            SlaveServerStatus serverStatus = XmlTool.xmlToBean(body, SlaveServerStatus.class);
            return serverStatus;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @param trans
     * @param level
     * @param otherParameters All the other parameters will be sent to the transformation for using as variables. When necessary you can add custom parameters to the request. They will be used to set the transformation variables values..
     * @return https://javadoc.pentaho.com/kettle930/kettle-engine-9.3.0.0-424-javadoc/org/pentaho/di/www/RunTransServlet.html
     */
    public Result executeTrans(String trans, LogLevel level, Map<String, Object> otherParameters) {
        String url = baseUrl + "/kettle/executeTrans/?rep=" + rep + "&trans=" + trans + "&level=" + level.getCode();
        return common_get(url, otherParameters);
    }


    /***
     *
     * @param job
     * @param level
     * @param otherParameters All the other parameters will be sent to the job for using as variables. When necessary you can add custom parameters to the request. They will be used to set the job variables values.
     * @return
     *
     * https://javadoc.pentaho.com/kettle930/kettle-engine-9.3.0.0-424-javadoc/org/pentaho/di/www/ExecuteJobServlet.html
     */
    public Result executeJob(String job, LogLevel level, Map<String, Object> otherParameters) {
        String url = baseUrl + "/kettle/executeJob/?rep=" + rep + "&job=" + job + "&level=" + level.getCode();
        return common_get(url, otherParameters);
    }

    public Result startJob(String id) {
        String url = baseUrl + "/kettle/startJob/?id=" + id + "&xml=Y";
        return common_get(url, null);
    }


    /**
     * add job to carte server, (not the repo)
     *
     * @param jobXml the job file content, such as  xxx.job
     * @param params the job's params
     * @return result
     */
    public Result registerJob(String jobXml, Map<String, String> params) {
        String url = baseUrl + "/kettle/registerJob/?xml=Y";
        if (params == null) {
            params = Collections.emptyMap();
        }

        jobXml = jobXml.replaceFirst("\\<\\?xml.*>", "");


        StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

        xml.append("<job_configuration>");
        {
            xml.append("<job_execution_configuration>");
            {
                xml.append("<exec_local>N</exec_local>");
                xml.append("<pass_export>N</pass_export>");

                xml.append("<parameters>");
                for (Map.Entry<String, String> e : params.entrySet()) {
                    xml.append("<parameter><name>").append(e.getKey())
                            .append("</name><value>").append(e.getValue())
                            .append("</value></parameter>");
                }
                xml.append("</parameters>");


                xml.append("<replay_date/>");
                xml.append("<safe_mode>N</safe_mode>");
                xml.append("<log_level>Basic</log_level>");
                xml.append("<clear_log>Y</clear_log>");
                xml.append("<start_copy_name/>");
                xml.append("<start_copy_nr>0</start_copy_nr>");
                xml.append("<gather_metrics>Y</gather_metrics>");
                xml.append("<expand_remote_job>N</expand_remote_job>");


            }

            xml.append("</job_execution_configuration>");

            xml.append(jobXml);
        }
        xml.append("</job_configuration>");


        return common_post_body(url, xml.toString());
    }


    private Result common_get(String url, Map<String, Object> otherParameters) {
        HttpRequest http = HttpRequest.get(url, otherParameters, true).basic(username, password);
        return common_parse_result(http);
    }


    private Result common_post_body(String url, String bodyContent) {
        HttpRequest http = HttpRequest.post(url).basic(username, password).contentType("text/xml", "UTF8").send(bodyContent);
        return common_parse_result(http);
    }

    private static Result common_parse_result(HttpRequest http) {
        String body = http.body();
        System.out.println("response:" + body);
        boolean hasBody = body != null && !body.isEmpty();

        if (http.code() == 200 && (!hasBody)) {
            return Result.ok();
        }


        if (hasBody) {
            try {
                WebResult webResult = XmlTool.xmlToBean(body, WebResult.class);
                if ("ERROR".equals(webResult.getResult())) {
                    return Result.err().msg(webResult.getMessage());
                }
                return Result.ok().msg(webResult.getMessage());
            } catch (JsonProcessingException e) {
                return Result.err().msg(e.getMessage());
            }
        }

        return Result.err().msg("request kettle err：" + http.code() + "," + http.message());
    }
}
