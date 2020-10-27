学习笔记
## 本周总结
### JVM 相关
#### GC 日志的解读和分析*
1. 查看日志命令

`Java 8` 的版本
```
java -Xmx1g -Xms1g ‐XX:+PrintGCDetails ‐XX:+PrintGCTimeStamps  demo.jvm0204.GCLogAnalysis
```
`-Xmx1g -Xms1g` 指定堆内存的大小

指定垃圾收集器
```
‐XX:+UseSerialGC # 使用串行GC
‐XX:+UseParallelGC # 使用并行GC
‐XX:+UseParallelGC ‐XX:+UseParallelOldGC # 使用并行GC，老年区也使用并行GC
‐XX:+UseConcMarkSweepGC # 使用 CMS GC
‐XX:+UseConcMarkSweepGC ‐XX:+UseParNewGC # 新生代使用并行GC，老年区使用CMS GC
‐XX:+UseG1GC # 使用G1 GC
```


>这个参数的格式为: ‐XX:+ ，这是一个布尔值开关。

`‐XX:+PrintGCDetails` : 发生GC时会输出相关的GC日志

`‐Xloggc:gc.%p.log ; ‐Xloggc:gc‐%t.log`：指定GC日志文件;
> Java 11 打印日志信息 ：‐Xlog:gc*=info:file=gc.log:time:filecount=0

从JDK8开始，支持使用 %p ， %t 等占位符来指定GC输出文件；
指定 `‐Xloggc`: 参数，自动加上了 `‐XX:+PrintGCTimeStamps` 配置

2.


##### JVM 线程堆栈数据分析
##### 内存分析与相关工具*
##### JVM 问题分析调优经验*
##### GC 疑难情况问题分析
##### JVM 常见面试问题汇总*

#### Scoket IO 相关
1. Java Socket 编程*:如何基于 Socket 实现 Server
2. 深入讨论 IO*:Server 处理时到底发生了什么
3. IO 模型与相关概念*:怎么理解 NIO
4. Netty 框架简介:什么是 Netty
5. Netty 使用示例*:如何使用 Netty 实现 NIO


