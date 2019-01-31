# smart-cloud
微服务基础框架，基于 SpringCloud 及 SpringBoot 开发。 使用 Oauth2 统一授权、认证, Oauth示例客户端使用 Vue 开发，具有用户管理、 资源管理、 角色管理等模块，后端包括授权中心、 基础数据中心（资源服务器）等应用，可作为微服务快速开发脚手架。  可通过 docker 快速构建部署。
  
username: test  password: 123456
phone: 13100000000 verifyCode: 1000  


## Model  
### 项目结构  
```
├─smart-cloud
│  │  
│  ├─api-gateway--------------网关负载中心
│  │ 
│  ├─auth-center-----------------OAuth2服务授权中心
│  │  ├─auth-center-api----------------授权中心公共模块
│  │  ├─auth-center-provider----------------授权中心服务端
│  │  ├─auth-spring-boot-autoconfigure----------------授权中心autoconfigure
│  │  └─auth-spring-boot-starter----------------授权中心starter模块
│  │ 
│  ├─common----------------通用脚手架
│  │ 
│  ├─config-git-----------------配置中心
│  │ 
│  ├─db-mybatis-pagehelper---------------Mybatis通用Mapper、分页模块
│  │  ├─db-spring-boot-autoconfigure----------------autoconfigure
│  │  ├─db-spring-boot-samples----------------db模块使用示例
│  │  └─db-spring-boot-starter----------------db starter
│  │ 
│  ├─docker-compose---------------docker-compose编排
│  │   
│  ├─main-data--------------基础数据模块
│  │  ├─main-data-api----------------基础数据公共模块
│  │  ├─main-data-client----------------基础数据模块客户端
│  │  └─main-data-provider----------------基础数据模块服务端
│  │
│  ├─visul---------------监控
│  │  ├─monitor----------------admin监控
│  │  └─zipkin-db----------------zipkin链路追踪
│  ├─mc-service---------------消息服务
│  │  
│  └─web-app--------------vue前端应用
│
```

## Quick Start  
### 依赖环境    
JDK8、 Maven、 Mysql、 Redis、Consul、 Rabbitmq、Nodejs、 Docker(可选)、 docker-compose(可选)  
### 运行步骤  
1. Mysql导入数据： 运行main-data/schema.sql 文件；    
2. 更改配置文件，此项目默认本地配置，更改 config-git/src/main/resource/config 下的配置文件，主要需修改数据库链接、 Redis链接、 Rabbitmq链接等；     
3. 启动 Consul (下载地址： https://www.consul.io/downloads.html)， window下载解压完为exe可执行文件, 进入其文件夹下 cmd -> consul agent -dev 启动，此时可访问 http://localhost:8500 查看Consul Ui页面；    
4. 启动redis、 Rabbitmq；  
5. 依此启动 config-git/ConfigServerApplication.main(配置中心)、auth-center/auth-center-provider/AuthCenterProviderApplication.main(服务授权中心)、 api-gateway/ApiGatewayApplication.main()(网关负载中心)、 main-data/main-data-provider/MainDataApplication.main()(基础数据模块)，注意启动顺序，配置中心必须最先启动，网关和基础数据模块依赖授权模块的 jwt/key-uri point；启动后可在Consul图形界面上即可看到已注册的服务;  
6. 前端Vue项目需node环境（https://nodejs.org/en/download/), cd web-app、安装依赖 npm install、 启动项目 npm dev run , 需更改后端接口地址， /static/config.js/window.serverconf/development  
 

### 通过 docker-compose 快速启动  
1. 需要 docker-compose 环境，windows 可安装 DockerToolbox。  
需先通过 Maven 插件 docker-maven-plugin 打包镜像，  
```
<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>com.spotify</groupId>
                <artifactId>docker-maven-plugin</artifactId>
                <version>${docker.plugin.version}</version>
                <configuration>
                    <imageName>${project.artifactId}</imageName>
                    <dockerDirectory>src/main/docker</dockerDirectory>
                    <resources>
                        <resource>
                            <targetPath>/</targetPath>
                            <directory>${project.build.directory}</directory>
                            <include>${project.build.finalName}.jar</include>
                        </resource>
                    </resources>
                </configuration>
            </plugin>
        </plugins>
</build>
```
  
2. 分别构建 auth-center-provider、 main-data-provider、 api-gateway：  
```
mvn clean
mvn package docker:build
```
构建 node-app:  
```
cd /smart-cloud/web-app
docker build -t node-app .
```
  
3. 更改配置 docker-compose.yml：  
```
     node-app:
     image: node-app
     ports:
      - '8080:8080'
     depends_on:
      - 'auth-center'
      - 'api-gateway'
      # 基础路径，授权时的redirectUrl，为 宿主机IP:本容器映射端口
      - BASE_URL=http://192.168.99.100:8080
      # 后台接口，对于网关
      - SERVER_URL=http://192.168.99.100:18000
      # 授权中心
      - AUTH_URL=http://192.168.99.100:18001/auth
```
  
4. 运行  
```
cd /smart-cloud/docker-compose
docker-compose up [-d]
```

### 通过共享镜像启动  

## Preview  

## 更新日志
* 2018-12 spring security登陆验证扩展 手机验证码，二维码扫码登陆、 引入i18n国际化、 集成git配置中心、admin监控、 链路追踪、Springcloud 升级为Edgware，Consul升级为最新1.2  
* 2018-11 完成基础数据模块开发、 docker容器编排  
* 2018-11 授权中心整和Jwt、 SpringSecurity，使用 OAuth2 授权  
* 2018-10 init， 完成公共模块设计、 SpringBoot starter开发  
