package io.github.tmgg.kettle.sdk.test;

import cn.moon.lang.json.JsonTool;
import io.github.tmgg.kettle.sdk.AbstructTest;
import io.github.tmgg.kettle.sdk.KettleSdk;
import io.github.tmgg.kettle.sdk.LogLevel;
import io.github.tmgg.kettle.sdk.Result;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class RegisterJobTest extends AbstructTest {

    public static void main(String[] args) throws IOException {
        KettleSdk sdk = new KettleSdk(url,repo,  username, password);
        String xml = FileUtils.readFileToString(new File("D:\\job33.kjb"));


        HashMap<String, String> params = new HashMap<>();
        params.put("filename","okkkkk");
        Result result = sdk.registerJob(xml, params);
        System.out.println(JsonTool.toPrettyJsonQuietly(result));

    }
}
