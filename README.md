# wfc-archetype
基于springboot的脚手架项目

## 简介
目标是为了通过此archetype快速构建包含多个子工程的springboot项目, 统一风格, 生成每个子工程样例和测试用例

## 子工程介绍
### dal
> 数据连接层

- 集成: mybatis, mybatis-plus, druid
- 创建项目生产: 子工程demo, 测试用例demo

### web
> web工程, 主要提供rest接口

- 集成: springMVC, freemarker, Swagger2