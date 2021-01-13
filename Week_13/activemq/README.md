### 1、（必做）搭建ActiveMQ服务，基于JMS，写代码分别实现对于queue和topic的消息 生产和消费，代码提交到github。

### 大体步骤
服务端
- 1). 创建 ConnectionFactory
- 2). 创建 Connection
- 3). 启动连接 connection.start()
- 4). 创建会话
- 5). 创建目标(Topic/Queue)
- 6). 创建生产者
- 7). 创建消息
- 8). 关闭连接

客户端
- 1) 创建 ConnectionFactory
- 2) 创建 Connection
- 3) 启动连接
- 4) 创建会话
- 5) 创建目标
- 6) 创建消费者
- 7) 创建消费监听者


