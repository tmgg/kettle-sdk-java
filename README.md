# Intro
Kettle(pdi) Carte java sdk

# Usage
![版本](https://img.shields.io/maven-central/v/io.github.tmgg/kettle-sdk-java)
```xml
<dependency>
    <groupId>io.github.tmgg</groupId>
    <artifactId>kettle-sdk-java</artifactId>
    <version>version</version>
</dependency>
```

Demo
```java
KettleSdk sdk = new KettleSdk(url, repo, username, password);
SlaveServerStatus status = sdk.status();
```




# manage repository ?
install the carte plugin from https://github.com/tmgg/kettle-carte-plugin/releases

download and unzip to kettle dir


# dev note

## response entity reference

pentaho-kettle/engine/src/main/java/org/pentaho/di/www/
