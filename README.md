### Flume sample project

编写完代码后，打包，将 jar 包放到 Flume 安装路径下的 `lib` 目录

配置时如下：
```properties
agent1.sources.r1.interceptors = i1
agent1.sources.r1.interceptors.i1.type = com.flume.example.ExampleFlumeInterceptor$Builder
```

Maven 依赖
```xml
<dependency>
    <groupId>org.apache.flume</groupId>
    <artifactId>flume-ng-core</artifactId>
    <version>1.9.0</version>
</dependency>
```
