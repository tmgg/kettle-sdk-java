package io.github.tmgg.kettle.sdk.test;

import cn.moon.lang.json.JsonTool;
import io.github.tmgg.kettle.sdk.AbstructTest;
import io.github.tmgg.kettle.sdk.KettleSdk;
import io.github.tmgg.kettle.sdk.LogLevel;
import io.github.tmgg.kettle.sdk.Result;

public class ExecuteJobTest extends AbstructTest {

    public static void main(String[] args) {
        KettleSdk sdk = new KettleSdk(url, username, password);

        Result result = sdk.executeJob(repo, "job1", LogLevel.DEBUG,null);
        System.out.println(JsonTool.toPrettyJsonQuietly(result));
    }
}
