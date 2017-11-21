# advertis
This project comes from the advertising of Hongbo
### 简介
    advertis是一个广告管理系统，主要分为前台页面展示和后台数据维护，整个系统采用springboot+mybatis+MySQL开发完成，
    其中包含了使用springboot开发web项目完整流程，页面使用bootstrap+thymeleaf。
### 技术要点
    1、AOP请求日志处理；
    2、mybatis分页拦截；
    3、自定义Exception处理；
    4、Scheduler定时任务实现；
    5、Java-Echarts类库使用；
### 开发环境
    jdk1.8 + MySQL + IDEA/Eclipse
### 使用说明
    安装git环境，在本地创建git仓库，使用clone命令 “clone 项目地址”，成功clone项目到本地，并导入项目到IDEA或者Eclipse，
    配置jdk为1.8并配置maven环境，修改resource/application-dev.properties文件的数据库信息，并执行resource/sql/advertis.sql
    文件完成数据初始化即可。
    ps: 因为springboot内置了tomcat，因此可以使用AdvertisApplication类来启动项目。
### 访问地址
    
    前台地址：http://127.0.0.1:8080/
    后台地址：http://127.0.0.1:8080/manager
    用户名：admin   密码：admin
    
    
    




