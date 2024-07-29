package cn.tmgg.kettle.sdk.test;

import cn.moon.lang.json.JsonTool;
import cn.tmgg.kettle.sdk.AbstructTest;
import cn.tmgg.kettle.sdk.KettleSdk;
import cn.tmgg.kettle.sdk.vo.SlaveServerStatus;

public class StatusTest extends AbstructTest {

    public static void main(String[] args) {
        KettleSdk sdk = new KettleSdk(url,username, password);

        SlaveServerStatus status = sdk.status();
        System.out.println(JsonTool.toPrettyJsonQuietly(status));
    }
}
