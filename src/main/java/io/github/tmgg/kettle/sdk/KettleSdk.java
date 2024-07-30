package io.github.tmgg.kettle.sdk;

import cn.moon.lang.json.XmlTool;
import io.github.tmgg.kettle.sdk.response.SlaveServerStatus;
import io.github.tmgg.kettle.sdk.response.WebResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.kevinsawicki.http.HttpRequest;

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
     *
     * @param trans
     * @param level
     * @param otherParameters All the other parameters will be sent to the transformation for using as variables. When necessary you can add custom parameters to the request. They will be used to set the transformation variables values..
     * @return
     *
     * https://javadoc.pentaho.com/kettle930/kettle-engine-9.3.0.0-424-javadoc/org/pentaho/di/www/RunTransServlet.html
     */
    public Result executeTrans(String trans, LogLevel level,Map<String, Object> otherParameters) {
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

    private Result common_get(String url, Map<String, Object> otherParameters) {
        HttpRequest http = HttpRequest.get(url, otherParameters, true).basic(username, password);
        if (http.code() == 200) {
            return Result.ok();
        }

        String body = http.body();
        if (body != null && !body.isEmpty()) {
            try {
                WebResult webResult = XmlTool.xmlToBean(body, WebResult.class);
                return Result.err().msg(webResult.getMessage());
            } catch (JsonProcessingException e) {
                return Result.err().msg(e.getMessage());
            }
        }

        return Result.err().msg("request kettle err：" + http.code() + "," + http.message());
    }
}
