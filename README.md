# 开始
目前SpringBoot比较热门，之前一直没有时间去研究，正好这些天不太忙，就想花些时间来研究研究。

# 项目
构建一个Sping Boot的Maven项目，强烈推荐Spring Initializr,它从本质上来说就是一个Web应用程序，它能为你生成Spring Boot项目结构。


- 地址：```http://start.spring.io/```
- Jdk版本最好选择1.7以上 推荐1.8

![springboot](https://raw.githubusercontent.com/lulongji/lulongji.github.io/master/imgs/springboot/springboot1.png)



- 如你所见，项目里面基本没有代码，除了几个空目录外，还包含如下几样东西。
```
    pom.xml：Maven构建说明文件。
    DemoApplication.java：一个带有main()方法的类，用于启动应用程序（关键）。
    DemoApplicationTests.java：一个空的Junit测试类，它加载了一个使用Spring Boot字典配置功能的Spring应用程序上下文。
    application.properties：一个空的properties文件，你可以根据需要添加配置属性。

```

# 构建项目
创建TestController类，添加如下代码。


    @RestController
    @EnableAutoConfiguration
    public class TestController {

        @RequestMapping("/")
        public String test() {
            return "Hello world";
        }
    }

# 启动程序
在DemoApplication.java 文件点击右键运行main方法，之后运行http://localhost:8080/就会看到 ```Hello world```了。

- 注意一点：DemoApplication这个启动类必须放在最外层，要不会抱一个错误```Whitelabel Error Page```,详细解释也可以看官网```http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#using-boot-structuring-your-code```



# 项目分层

### 说明
mvc的设计模式依旧是日常开发中上使用最多的一种设计模式，所以今天我们还是用这种模式设计。

- domain层：模型层，实体类。
- service层：业务层。
- dao层：持久层。
- Controller层：视图层。


### 框架接口代码整合
基础增删改查代码请到github查看。
```https://github.com/lulongji/springboot-demo.git```
### 框架配置

    #默认使用配置
    spring:
    profiles:
        active: dev


    #公共配置与profiles选择无关
    mybatis:
    typeAliasesPackage: com.example.demo.domain
    mapperLocations: classpath*:com/example/demo/dao/**/*Mapper.xml

    ---

    #开发配置
    在resources目录下新建application.yml配置文件，添加如下配置：

        server:
        port: 8080

        spring:
        profiles: dev

        datasource:
            url: jdbc:oracle:thin:@192.168.6.205:1521:orcl
            username: test
            password: test
            driver-class-name: oracle.jdbc.driver.OracleDriver
            druid.initialSize: 5
            druid.maxActive: 100
            druid.minIdle: 10
            druid.maxWait: 60000
            #使用druid数据源
            type: com.alibaba.druid.pool.DruidDataSource


        #分页的配置
        pagehelper:
            helperDialect: oracle
            reasonable: true
            supportMethodsArguments: true
            params: count=countSql
            offset-as-page-num: true
            row-bounds-with-count: true


### pom文件

        <!-- druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
        </dependency>


        <!-- oracle-jdbc -->
        <dependency>
            <groupId>com.oracle</groupId>
            <artifactId>ojdbc14</artifactId>
            <version>${oracle.drive.version}</version>
        </dependency>

        <!-- 集成druid，使用连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.0</version>
        </dependency>

        <!-- MyBatis -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.1</version>
        </dependency>

        <!--mapper-->
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper-spring-boot-starter</artifactId>
            <version>1.2.4</version>
        </dependency>

        <!--pagehelper-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.3</version>
        </dependency>




# 日志文件

### 说明
SpringBoot 的日志文件放在resources目录下，在resources目录下新建logback.xml.

### logback.xml配置及说明
    <?xml version="1.0" encoding="UTF-8"?>
    <!--
        Copyright 2010-2011 The myBatis Team
        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at
            http://www.apache.org/licenses/LICENSE-2.0
        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
    -->
    <configuration>
        <!--定义日志文件的存储地址 勿在 LogBack 的配置中使用相对路径-->
        <property name="LOG_HOME" value="/Users/lu/Desktop"/>


        <!-- 彩色日志 -->
        <!-- 彩色日志依赖的渲染类 -->
        <conversionRule conversionWord="clr" converterClass="org.springframework.boot.logging.logback.ColorConverter"/>
        <conversionRule conversionWord="wex"
                        converterClass="org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter"/>
        <conversionRule conversionWord="wEx"
                        converterClass="org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter"/>
        <!-- 彩色日志格式 -->
        <property name="CONSOLE_LOG_PATTERN"
                value="${CONSOLE_LOG_PATTERN:-%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>
        <!-- Console 输出设置 -->
        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
            <encoder>
                <pattern>${CONSOLE_LOG_PATTERN}</pattern>
                <charset>utf8</charset>
            </encoder>
        </appender>
        
        <!-- 按照每天生成日志文件 -->
        <appender name="DAYINFO" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <!--日志文件输出的文件名-->
                <FileNamePattern>${LOG_HOME}/TestSpringBoot_info.log.%d{yyyy-MM-dd}.log</FileNamePattern>
                <!--日志文件保留天数-->
                <MaxHistory>30</MaxHistory>
            </rollingPolicy>
            <filter class="ch.qos.logback.classic.filter.LevelFilter">
                <level>info</level>
                <onMatch>ACCEPT</onMatch>
                <onMismatch>DENY</onMismatch>
            </filter>
            <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
                <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符-->
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
            </encoder>
            <!--日志文件最大的大小-->
            <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
                <MaxFileSize>10MB</MaxFileSize>
            </triggeringPolicy>
        </appender>

        <appender name="DAYERROR" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <!--日志文件输出的文件名-->
                <FileNamePattern>${LOG_HOME}/TestSpringBoot_error.log.%d{yyyy-MM-dd}.log</FileNamePattern>
                <!--日志文件保留天数-->
                <MaxHistory>30</MaxHistory>
            </rollingPolicy>
            <filter class="ch.qos.logback.classic.filter.LevelFilter">
                <level>error</level>
                <onMatch>ACCEPT</onMatch>
                <onMismatch>DENY</onMismatch>
            </filter>
            <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
                <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符-->
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
            </encoder>
            <!--日志文件最大的大小-->
            <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
                <MaxFileSize>10MB</MaxFileSize>
            </triggeringPolicy>
        </appender>

        <!-- 日志输出级别 -->

        <root level="INFO">
            <appender-ref ref="STDOUT"/>
            <appender-ref ref="DAYERROR"/>
            <appender-ref ref="DAYINFO"/>
        </root>
    </configuration>

### pom文件

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </dependency>



# 说明
在部署项目打包的时候，往往要调过测试```mvn package -Dmaven.test.skip=true```，但是在程序每次打包的时候输入这么多会很麻烦，所以修改一下配置，使其调过test

### 加入如下代码

    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
            <finalName>***</finalName>
            <mainClass>***</mainClass>
        </configuration>
        <executions>
            <execution>
            <goals>
                <goal>repackage</goal>
            </goals>
            </execution>
        </executions>
    </plugin>


在```<project>标签下的<properties>```标签中加入```<skipTests>true</skipTests>```


