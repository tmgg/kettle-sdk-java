package io.github.tmgg.kettle.sdk.test;

import io.github.mxvc.jackson.JsonTool;
import io.github.tmgg.kettle.sdk.AbstructTest;
import io.github.tmgg.kettle.sdk.KettleSdk;
import io.github.tmgg.kettle.sdk.LogLevel;
import io.github.tmgg.kettle.sdk.Result;

public class JobImageTest extends AbstructTest {

    public static void main(String[] args) {
        KettleSdk sdk = new KettleSdk(url,repo,  username, password);

        Result result = sdk.jobImage("0024cf52-de47-466e-9cc8-0d2a2cd0af06", "J_ODS_一卡通_交易信息");
    }
}
