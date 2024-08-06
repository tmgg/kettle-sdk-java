package io.github.tmgg.kettle.sdk.test;

import cn.moon.lang.json.JsonTool;
import io.github.tmgg.kettle.sdk.AbstructTest;
import io.github.tmgg.kettle.sdk.HttpUtil;
import io.github.tmgg.kettle.sdk.KettleSdk;
import io.github.tmgg.kettle.sdk.Result;
import io.github.tmgg.kettle.sdk.response.SlaveServerJobStatus;
import io.github.tmgg.kettle.sdk.response.SlaveServerStatus;

import java.io.IOException;

public class JobStatusTest extends AbstructTest {

    public static void main(String[] args) throws IOException {
        KettleSdk sdk = new KettleSdk(url,repo, username, password);

        SlaveServerJobStatus status = sdk.jobStatus("84f9013d-d13a-439c-b54d-07ecd5e7eca9","job2");
        System.out.println(JsonTool.toPrettyJsonQuietly(status));
    }
}
