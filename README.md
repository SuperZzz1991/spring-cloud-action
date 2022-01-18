# spring-cloud-action

## Spring cloud GateWay：网关

> nacos：路由动态配置(gateway-nacos-config)

## Nacos：

> 配置管理：nacos-config-client
> 服务注册：open-feign-nacos-service/nacos-ribbon-service

## Spring Security OAuth和JWT：认证管理

## Spring Cloud OpenFeign：声明式远程调用

> * Ribbon：nacos-ribbon-service 基础原远程调用
> * LoadBalancer：nacos-ribbon-service 基础原远程调用
> * openFeign：open-feign-nacos-service 声明式远程调用

## Spring Cloud Sentinel：容错限流

```cmd
java '-Dserver.port=8070' '-Dcsp.sentinel.log.dir=C:\logs\sentinel-dashboard' '-jar' sentinel-dashboard.jar
```