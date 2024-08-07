package io.github.tmgg.kettle.sdk.test;

import cn.moon.lang.json.JsonTool;
import io.github.tmgg.kettle.sdk.AbstructTest;
import io.github.tmgg.kettle.sdk.KettleSdk;
import io.github.tmgg.kettle.sdk.Result;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class RegisterTransTest extends AbstructTest {

    public static void main(String[] args) throws IOException {
        KettleSdk sdk = new KettleSdk(url,repo,  username, password);
        String xml = FileUtils.readFileToString(new File("D:\\repository\\运营\\ODS_一卡通川投_交易订单.ktr"));


        HashMap<String, String> params = new HashMap<>();
        params.put("filename","okkkkk");
        Result result = sdk.registerTrans(xml, params);
        System.out.println(JsonTool.toPrettyJsonQuietly(result));

    }
}
