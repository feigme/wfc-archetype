# wfc-archetype
基于springboot的脚手架项目

## 简介
目标是为了通过此archetype快速构建包含多个子工程的springboot项目, 统一风格, 生成每个子工程样例和测试用例

## 子工程介绍
### dal
> 数据连接层

- 集成: mybatis, mybatis-plus, druid
- 生成: 子工程demo, 测试用例demo

### web
> web工程, 主要提供rest接口

- 集成: springMVC, freemarker, Swagger2
- springMVC使用fastjson做json的序列化
- 生成: springMVC单测demo

## 使用方法
1. 首先将archetype install到本地

```sh
git clone https://github.com/feigme/wfc-archetype.git

cd wfc-archetype

mvn install

```

2. 使用idea, 将archetype添加进去
![](https://raw.githubusercontent.com/feigme/wfc-archetype/master/doc/201861CF.png)

3. 然后选择archetype来创建项目
![](https://raw.githubusercontent.com/feigme/wfc-archetype/master/doc/201861CG.png)
