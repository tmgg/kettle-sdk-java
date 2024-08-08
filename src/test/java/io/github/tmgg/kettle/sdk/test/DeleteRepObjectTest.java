package io.github.tmgg.kettle.sdk.test;

import io.github.tmgg.kettle.sdk.AbstructTest;
import io.github.tmgg.kettle.sdk.KettleSdk;

import java.io.IOException;

public class DeleteRepObjectTest extends AbstructTest {

    public static void main(String[] args) throws IOException {
        KettleSdk sdk = new KettleSdk(url, repo, username, password);

        sdk.deleteRepObject("/运营/");
    }
}
