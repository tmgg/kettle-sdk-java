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





# api
## 已完成

- status: Get the status of the server
- executeTrans: Execute (prepare and start) a specific transformation and pass output to the servlet

- registerJob: Add a job to the server
- startJob: Start a job
- executeJob: Execute (prepare and start) a specific job
- jobStatus: Get the status of a job
- jobImage: Generate a PNG image of a job

## 已完成插件（kettle carte plugin）接口  

## todo

- transStatus: The the status of a transformation
- prepareExec: Prepare the execution of a transformation
- startExec: Start the execution of a transformation
- startTrans: Prepare and start the execution of a transformation
- pauseTrans: Pause or continue a transformation
- stopTrans: Stop a transformation
- cleanupTrans: Cleanup a transformation: close remote sockets, ...
- removeTrans: Remove a transformation
- allocateSocket: Service for the allocation of server sockets
- listSocket: Lists server socket allocation information
- sniffStep: Sniff test a transformation step
- transImage: Generate a PNG image of a transformation



- stopJob: Stop a job

- removeJob: Remove a job from the server

- registerTrans: Add a transformation to the server
- registerPackage: Upload a resources export file

# manage repository ?
install the carte plugin from https://github.com/tmgg/kettle-carte-plugin/releases

download and unzip to kettle dir


# dev note

## response entity reference

pentaho-kettle/engine/src/main/java/org/pentaho/di/www/
