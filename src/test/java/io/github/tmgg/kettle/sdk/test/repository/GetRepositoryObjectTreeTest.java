package io.github.tmgg.kettle.sdk.test.repository;

import io.github.tmgg.kettle.sdk.AbstructTest;
import io.github.tmgg.kettle.sdk.KettleSdk;
import io.github.tmgg.kettle.sdk.plugin.RepTreeItem;

import java.io.IOException;
import java.util.List;

public class GetRepositoryObjectTreeTest extends AbstructTest {

    public static void main(String[] args) throws IOException {
        KettleSdk sdk = new KettleSdk(url,repo, username, password);

        List<RepTreeItem> repObjects = sdk.getRepositoryObjectTree();

        for (RepTreeItem repObject : repObjects) {
            System.out.println(repObject);
        }
    }
}
