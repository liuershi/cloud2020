# springcloud学习笔记

## 1.技术选型

springcloud对应springboot的技术选型：

获取技术选型信息：https://start.spring.io/actuator/info

将信息转成对应json字符串：

```json
{
  "git": {
    "commit": {
      "time": "2020-04-05T14:52:09Z",
      "id": "23f3aa7"
    },
    "branch": "23f3aa7995fa1b4d1b27a63412d4f3898c99c9c3"
  },
  "build": {
    "version": "0.0.1-SNAPSHOT",
    "artifact": "start-site",
    "name": "start.spring.io website",
    "versions": {
      "initializr": "0.9.0.BUILD-SNAPSHOT",
      "spring-boot": "2.2.6.RELEASE"
    },
    "group": "io.spring.start",
    "time": "2020-04-05T14:53:29.650Z"
  },
  "bom-ranges": {
    "azure": {
      "2.0.10": "Spring Boot >=2.0.0.RELEASE and <2.1.0.RELEASE",
      "2.1.7": "Spring Boot >=2.1.0.RELEASE and <2.2.0.M1",
      "2.2.0": "Spring Boot >=2.2.0.M1"
    },
    "codecentric-spring-boot-admin": {
      "2.0.6": "Spring Boot >=2.0.0.M1 and <2.1.0.M1",
      "2.1.6": "Spring Boot >=2.1.0.M1 and <2.2.0.M1",
      "2.2.1": "Spring Boot >=2.2.0.M1"
    },
    "solace-spring-boot": {
      "1.0.0": "Spring Boot >=2.2.0.RELEASE and <2.3.0.M1"
    },
    "solace-spring-cloud": {
      "1.0.0": "Spring Boot >=2.2.0.RELEASE and <2.3.0.M1"
    },
    "spring-cloud": {
      "Finchley.M2": "Spring Boot >=2.0.0.M3 and <2.0.0.M5",
      "Finchley.M3": "Spring Boot >=2.0.0.M5 and <=2.0.0.M5",
      "Finchley.M4": "Spring Boot >=2.0.0.M6 and <=2.0.0.M6",
      "Finchley.M5": "Spring Boot >=2.0.0.M7 and <=2.0.0.M7",
      "Finchley.M6": "Spring Boot >=2.0.0.RC1 and <=2.0.0.RC1",
      "Finchley.M7": "Spring Boot >=2.0.0.RC2 and <=2.0.0.RC2",
      "Finchley.M9": "Spring Boot >=2.0.0.RELEASE and <=2.0.0.RELEASE",
      "Finchley.RC1": "Spring Boot >=2.0.1.RELEASE and <2.0.2.RELEASE",
      "Finchley.RC2": "Spring Boot >=2.0.2.RELEASE and <2.0.3.RELEASE",
      "Finchley.SR4": "Spring Boot >=2.0.3.RELEASE and <2.0.999.BUILD-SNAPSHOT",
      "Finchley.BUILD-SNAPSHOT": "Spring Boot >=2.0.999.BUILD-SNAPSHOT and <2.1.0.M3",
      "Greenwich.M1": "Spring Boot >=2.1.0.M3 and <2.1.0.RELEASE",
      "Greenwich.SR5": "Spring Boot >=2.1.0.RELEASE and <2.1.14.BUILD-SNAPSHOT",
      "Greenwich.BUILD-SNAPSHOT": "Spring Boot >=2.1.14.BUILD-SNAPSHOT and <2.2.0.M4",
      "Hoxton.SR3": "Spring Boot >=2.2.0.M4 and <2.3.0.BUILD-SNAPSHOT",
      "Hoxton.BUILD-SNAPSHOT": "Spring Boot >=2.3.0.BUILD-SNAPSHOT"
    },
    "spring-cloud-alibaba": {
      "2.2.0.RELEASE": "Spring Boot >=2.2.0.RELEASE and <2.3.0.M1"
    },
    "spring-cloud-services": {
      "2.0.3.RELEASE": "Spring Boot >=2.0.0.RELEASE and <2.1.0.RELEASE",
      "2.1.7.RELEASE": "Spring Boot >=2.1.0.RELEASE and <2.2.0.RELEASE",
      "2.2.3.RELEASE": "Spring Boot >=2.2.0.RELEASE and <2.3.0.M1"
    },
    "spring-statemachine": {
      "2.0.0.M4": "Spring Boot >=2.0.0.RC1 and <=2.0.0.RC1",
      "2.0.0.M5": "Spring Boot >=2.0.0.RC2 and <=2.0.0.RC2",
      "2.0.1.RELEASE": "Spring Boot >=2.0.0.RELEASE"
    },
    "vaadin": {
      "10.0.17": "Spring Boot >=2.0.0.M1 and <2.1.0.M1",
      "14.1.23": "Spring Boot >=2.1.0.M1"
    }
  },
  "dependency-ranges": {
    "okta": {
      "1.2.1": "Spring Boot >=2.1.2.RELEASE and <2.2.0.M1",
      "1.4.0": "Spring Boot >=2.2.0.M1"
    },
    "mybatis": {
      "2.0.1": "Spring Boot >=2.0.0.RELEASE and <2.1.0.RELEASE",
      "2.1.2": "Spring Boot >=2.1.0.RELEASE"
    },
    "geode": {
      "1.2.6.RELEASE": "Spring Boot >=2.2.0.M5 and <2.3.0.M1",
      "1.3.0.M3": "Spring Boot >=2.3.0.M1 and <2.3.0.BUILD-SNAPSHOT",
      "1.3.0.BUILD-SNAPSHOT": "Spring Boot >=2.3.0.BUILD-SNAPSHOT"
    },
    "camel": {
      "2.22.4": "Spring Boot >=2.0.0.M1 and <2.1.0.M1",
      "2.24.3": "Spring Boot >=2.1.0.M1 and <2.2.0.M1",
      "3.1.0": "Spring Boot >=2.2.0.M1"
    }
  }
}
```

## 2.Cloud升级

至今为止(2020.4)，cloud许多原来的使用的系统组件有的停止更新，有的官方不推荐使用，在这个大势下，springcloud的服务组件也进行了一轮大的升级，具体包括以下方面：

- **服务注册中心**：原来使用Eureka，已停止更新，保守的话可以使用老牌的服务注册中心Zookeeper，也可以使用consul，它是用go语言编写，当然最推荐alibaba的**Nacos**(重点)。
- **服务调用**：以前使用Ribbon，现在推荐LoadBalancer。
- **服务调用2**：以前使用Feign，现在推荐使用OpenFeign。
- **服务降级熔断**：国内使用Hystrix也不在少数，国外现在推荐使用resilience4j，国内的话现在推荐sentienl。
- **服务网关**：之前使用zuul，现在也停止更新，官方现在强推gateway。
- **服务配置**：之前使用config，现在推荐使用**Nacos**。
- **服务总线**：之前使用Bus，现在推荐使用**Nacos**。

## 3.项目创建

### 1.cloud2020

#### 1.创建maven工程

我们创建maven工程的时候指定模板，指定模板为`maven-archetype-site`。

*<u>需要注意，不要选择自带的maven版本，选择自己本地maven3.5+。</u>*

#### 2.配置环境

- 设置编码：settings-->editor-->file encodings，全部设置为UTF-8。
- 注解生效激活：settings-->build,execution,deployment-->compiler-->annotation processors，启用注解处理。
- java编译版本：settings-->build,execution,deployment-->compiler-->java compiler，默认编译版本为1.5，设置为1.8。
- file type过滤：settings-->editor-->file types，在忽略文件类型中加上`*.idea;*.iml;`

#### 3.配置父pom

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>cn.infocore.springcloud</groupId>
  <artifactId>cloud2020</artifactId>
  <version>1.0-SNAPSHOT</version>
  <!-- packaging pom 总工程-->
  <packaging>pom</packaging>

  <!-- 统一管理jar包的版本 -->
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <junit.version>4.12</junit.version>
    <lombok.version>1.18.10</lombok.version>
    <log4j.version>1.2.17</log4j.version>
    <mysql.version>8.0.18</mysql.version>
    <druid.version>1.1.16</druid.version>
    <mybatis.spring.boot.version>2.1.1</mybatis.spring.boot.version>
  </properties>

  <!-- 子模块继承之后，提供作用：锁定版本+module不用写groupId和version -->
  <dependencyManagement>
    <dependencies>
      <!-- spring-boot 2.2.2 -->
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>2.2.2.RELEASE</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
      <!-- spring cloud Hoxton.SR1 -->
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>Hoxton.SR1</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
      <!--mybatis-->
      <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>${mybatis.spring.boot.version}</version>
      </dependency>
      <!--junit-->
      <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>${junit.version}</version>
      </dependency>
      <!--log4j-->
      <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>${log4j.version}</version>
      </dependency>
      <!-- lombok -->
      <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>${lombok.version}</version>
        <optional>true</optional>
      </dependency>
    </dependencies>
  </dependencyManagement>

  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
        <fork>true</fork>
        <addResources>true</addResources>
      </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```

这里总结一下`dependencyManagement`与`dependencies`的区别：

1. 在maven中dependencyManagement的作用相当于对所有依赖的jar包进行版本管理的管理器。

2. 在pom.xml中，jar包版本的判断主要通过两个途径：

   - 如果dependencies里的dependency自己没有声明version元素，那么maven就会到dependencyManagement里面去找有没有对该artifactId和groupId进行过版本声明，如果有，就继承它，如果没有就会报错，告诉你必须为dependency声明一个version。
   - 如果dependencies中的dependency声明了version，那么无论dependencyManagement中有无对该jar的version声明，都以dependency里的version为准。

3. 还需要注意的是：

   - **dependencies**即使在子项目中不写该依赖项，那么子项目仍然会从父项目中继承该依赖项（全部继承）
   - **dependencyManagement**里只是声明依赖，并不实现引入，因此子项目需要显示的声明需要用的依赖。如果不在子项目中声明依赖，是不会从父项目中继承下来的；只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承该项，并且version和scope都读取自父pom;另外如果子项目中指定了版本号，那么会使用子项目中指定的jar版本。

4. 如下

   ```xml
   //只是对版本进行管理，不会实际引入jar 
   <dependencyManagement> 
         <dependencies> 
               <dependency> 
                   <groupId>org.springframework</groupId> 
                   <artifactId>spring-core</artifactId> 
                   <version>3.2.7</version> 
               </dependency> 
       </dependencies> 
   </dependencyManagement> 
      
   //会实际下载jar包 
   <dependencies> 
          <dependency> 
                   <groupId>org.springframework</groupId> 
                   <artifactId>spring-core</artifactId> 
          </dependency> 
   </dependencies>
   ```

#### 4.创建子模块(cloud-provider-payment8001)

创建微服务的提供者支付模块(cloud-provider-payment8001)，并在子模块中导入依赖。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>cn.infocore.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-provider-payment8001</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- 健康监控 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <!-- 这里注意加上版本，因为dependencyManagement未定义druid的版本 -->
            <version>1.1.21</version>
        </dependency>
        <!-- mysql驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!-- jdbc -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <!-- 热部署 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <!-- lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
    </dependencies>
</project>
```

同时，配置yml文件：

```yml
server:
  port: 8001
  servlet:
    context-path: /cloud-provider-service

spring:
  application:
    name: cloud-payment-service
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://192.168.13.161:3306/springcloudDb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    username: root
    password: 123456


mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: cn.infocore.springcloud.entites #设置mybatis映射的实体类路径
```

#### 5.编写业务代码

按照顺序，一步步来，首先在数据库中建表：

```sql
-- auto-generated definition
create table Payment
(
    id     bigint auto_increment
        primary key,
    serial varchar(20) not null
);
```

然后，编写对应的实体类：

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
```

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T result;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
```

再编写Dao层，包含查询和创建两个方法：

```java
@Mapper
public interface PaymentDao {

    public int createPayment(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
```

写Dao对应的xml：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="cn.infocore.springcloud.dao.PaymentDao">
    <insert id="createPayment" parameterType="Payment" useGeneratedKeys="true">
        insert into Payment (serial) values (#{serial})
    </insert>

    <select id="getPaymentById" parameterType="Long" resultMap="getPaymentByIdResultMap">
        select * from Payment where id=#{id}
    </select>
    <resultMap id="getPaymentByIdResultMap" type="Payment">
        <result column="id" property="id"/>
        <result column="serial" property="serial"/>
    </resultMap>
</mapper>
```

再写service层和它的实现层：

```java
public interface PaymentService {

    public int createPayment(Payment payment);

    public Payment getPaymentById(Long id);
}
```

```java
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
```

最后编写controller层：

```java
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        CommonResult result;
        if (payment == null) {
            result = new CommonResult<>(444, "未找到id为" + id + "的对象");
            log.info("未找到id为" + id + "的对象");
        } else {
            result = new CommonResult<Payment>(200, "查询成功", payment);
            log.info("查询成功");
        }
        return result;
    }

    @PostMapping(value = "/payment/create")
    public CommonResult createPayment(Payment payment) {
        int createResult = paymentService.createPayment(payment);
        CommonResult result;
        if (createResult > 0) {
            result = new CommonResult<Integer>(200, "创建成功", createResult);
            log.info("创建对象成功");
        } else {
            result = new CommonResult<>(444, "创建失败", null);
            log.info("创建对象失败");
        }
        return result;
    }
}
```

测试即可，可以发现测试无误。

#### 6.开启热部署

1. 首先引入依赖：

   ```xml
   <!-- 热部署 -->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-devtools</artifactId>
       <scope>runtime</scope>
       <optional>true</optional>
   </dependency>
   ```

   

2. 引入maven插件，在父工程中添加：

   ```xml
   <build>
       <plugins>
           <plugin>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-maven-plugin</artifactId>
               <configuration>
                   <fork>true</fork>
                   <addResources>true</addResources>
               </configuration>
           </plugin>
       </plugins>
   </build>
   ```

   

3. 开启自动化构建：

   settings-->build,execution,deployment-->compiler。

   ![](D:\Program Files (x86)\WXWork\zhangwei\doc\photo\springcloud-study\1.png)

4. 使上面设置生效：

   使用快捷键`ctrl+shift+alt+/`，选择registry，勾选下列选项。

   ![](D:\Program Files (x86)\WXWork\zhangwei\doc\photo\springcloud-study\2.png)

5. 重启idea测试。



### 2.cloud-consumer-order80

#### 1.创建工程

正常创建即可。

#### 2.配置环境

配置pom依赖：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>cn.infocore.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-consumer-order80</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- 健康监控 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!-- 热部署 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <!-- lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>
</project>
```

配置yml文件：

```yml
server:
  port: 80
  servlet:
    context-path: /cloud-consumer-service
```

#### 3.编写业务代码

也为该模块为消费者，他不需要service，dao层，因此我们只需要配置相应的controller层即可。

1. 主启动类

   ```java
   @SpringBootApplication
   public class OrderMain80 {
       public static void main(String[] args) {
           SpringApplication.run(OrderMain80.class, args);
       }
   }
   ```

   

2. 配置实体类：

   ```java
   @Data
   @AllArgsConstructor
   @NoArgsConstructor
   public class Payment implements Serializable {
       private Long id;
       private String serial;
   }
   ```

   ```java
   @Data
   @AllArgsConstructor
   @NoArgsConstructor
   public class CommonResult<T> {
       private Integer code;
       private String message;
       private T result;
   
       public CommonResult(Integer code, String message) {
           this(code, message, null);
       }
   }
   ```

   

3. 配置类

   它的作用是将RestTemplate交给容器管理，在使用时直接使用注解注入即可。

   ```java
   @Configuration
   public class ApplicationContextConfiguration {
   
       @Bean
       public RestTemplate getRestTemplate(){
           return new RestTemplate();
       }
   }
   ```

4. 控制层

   ```java
   @RestController
   @Slf4j
   public class OrderController {
   
       public static final String PAYMENT_PROVIDER_URL = "http://localhost:8001/cloud-provider-service";
   
       @Resource
       private RestTemplate restTemplate;
   
       @GetMapping(value = "/payment/get/{id}")
       public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
           // 注意，返回的CommonResult必须要有无参构造，否则getForObject()方法会抛出异常
           return restTemplate.getForObject(PAYMENT_PROVIDER_URL + "/payment/get/" + id, CommonResult.class);
       }
   
       @GetMapping(value = "/payment/create")
       public CommonResult createPayment(Payment payment) {
           return restTemplate.postForObject(PAYMENT_PROVIDER_URL + "/payment/create", payment, CommonResult.class);
       }
   }
   ```

   这里格外需要注意一点，在createPayment方法里面，我们通过get方法接收来自前端的属性serial，此时再去调用postForObject时即去请求`cloud-provider-payment8001`中的controller的createPayment方法，此时传过去的serial属性需要用`@RequestBody`修饰包装映射到对应的bean中，如果不加则该属性无法映射过去。

   ```java
   @PostMapping(value = "/payment/create")
   public CommonResult createPayment(@RequestBody Payment payment) {
       int createResult = paymentService.createPayment(payment);
       CommonResult result;
       if (createResult > 0) {
           result = new CommonResult<Integer>(200, "创建成功", createResult);
           log.info("创建对象成功");
       } else {
           result = new CommonResult<>(444, "创建失败", null);
           log.info("创建对象失败");
       }
       return result;
   }
   ```



#### 4.@RequestBody与@RequestParam

**一：@RequestBody和@RequestParam区别**

@RequestParam
用来处理Content-Type: 为 application/x-www-form-urlencoded编码的内容。（Http协议中，如果不指定Content-Type，则默认传递的参数就是application/x-www-form-urlencoded类型）

RequestParam可以接受简单类型的属性，也可以接受对象类型。
实质是将Request.getParameter() 中的Key-Value参数Map利用Spring的转化机制ConversionService配置，转化成参数接收对象或字段。

tip
在Content-Type: application/x-www-form-urlencoded的请求中，
get 方式中queryString的值，和post方式中 body data的值都会被Servlet接受到并转化到Request.getParameter()参数集中，所以@RequestParam可以获取的到。

@RequestBody
处理HttpEntity传递过来的数据，一般用来处理非Content-Type: application/x-www-form-urlencoded编码格式的数据。

GET请求中，因为没有HttpEntity，所以@RequestBody并不适用。
POST请求中，通过HttpEntity传递的参数，必须要在请求头中声明数据的类型Content-Type，SpringMVC通过使用HandlerAdapter 配置的HttpMessageConverters来解析HttpEntity中的数据，然后绑定到相应的bean上。
总结
在GET请求中，不能使用@RequestBody。
在POST请求，可以使用@RequestBody和@RequestParam，但是如果使用@RequestBody，对于参数转化的配置必须统一。
举个例子，在SpringMVC配置了HttpMessageConverters处理栈中，指定json转化的格式，如Date转成‘yyyy-MM-dd’,则参数接收对象包含的字段如果是Date类型，就只能让客户端传递年月日的格式，不能传时分秒。因为不同的接口，它的参数可能对时间参数有不同的格式要求，所以这样做会让客户端调用同事对参数的格式有点困惑，所以说扩展性不高。

如果使用@RequestParam来接受参数，可以在接受参数的model中设置@DateFormat指定所需要接受时间参数的格式。

另外，使用@RequestBody接受的参数是不会被Servlet转化统一放在request对象的Param参数集中，@RequestParam是可以的。

综上所述，一般情况下，推荐使用@RequestParam注解来接受Http请求参数。

**二：GET请求可以使用@RequestBody来接收参数吗？**

答案是可以的。

为什么会这样呢？感觉要怀疑人生了，GET与@RequestParam，POST与@RequestBody才是我们映像中的绝配。

其实在一般的情况下，GET请求是不可以用@RequestBody来接收参数的。一般情况指的是请求由浏览器或者类似于POSTMAN这样的测试工具发出，我们都知道，Http请求包含请求头和请求体，如果发出的请求中请求体为空，那么使用@RequestBody注解来获取参数肯定是徒劳的，所以在这种情况下，GET与@ReqestBody配合使用是有问题的。

那么在什么情况下可以配合使用呢？需要两个条件，一是请求方式为GET，二是请求参数写入请求体中。即接口需要被上层的服务调用而非页面直接访问。由于目前微服务的运用越来越多，所以一般像这样的情况在实际的开发中会变得常见。

像这样的接口如何测试呢？可以使用curl命令，事例如下：curl -XGET -H "Content-Type:application/json" "http://host:port/requestmapping" -d '{"paramId":[1,2,3]}'

### 3.重构工程

在工程中，在`cloud-provider-payment8001`和`cloud-consumer-order80`模块中都包含了相同的实体类对象（`Payment`和`CommonResult`），在模块越来越多项目越来越庞大的工程中，这样的代码显然是冗余的，此时我们需要将公共代码提取出来放在公共模块中，将公共模块使用maven插件打包成本地依赖，此时在其他子需要该依赖的子模块中引入此公共依赖即可，在修改时也只需要修改公共模块代码再次打包成依赖即可，很方便。

#### 1.创建公共子模块

我们创建公共子模块`cloud-api-commons`，同样的还是老步骤。

#### 2.配置pom

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>cn.infocore.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-api-commons</artifactId>

    <dependencies>
        <!-- 热部署 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <!-- lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>5.2.3</version>
        </dependency>
    </dependencies>
</project>
```

#### 3.公共代码

创建`cn.infocore.springcloud.entites`文件夹，下面放公共的实体类。

Payment.java：

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
```

CommonResult.java：

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T result;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
```

#### 4.打包成本地依赖

![](D:\Program Files (x86)\WXWork\zhangwei\doc\photo\springcloud-study\4.png)

#### 5.依赖引入

打包成功后，在需要的模块中加入刚刚生成的依赖即可。

```xml
<!-- 引入自定义公共模块，可以使用Payment实体类-->
<dependency>
    <groupId>cn.infocore.springcloud</groupId>
    <artifactId>cloud-api-commons</artifactId>
    <version>${project.version}</version>
</dependency>
```



## 4.springcloud组件

### 1.Eureka

#### 1.简介

Eureka是Netflix开发的服务发现框架，本身是一个基于REST的服务，主要用于定位运行在AWS域中的中间层服务，以达到负载均衡和中间层服务故障转移的目的。SpringCloud将它集成在其子项目spring-cloud-netflix中，以实现SpringCloud的服务发现功能。

Eureka包含两个组件：Eureka Server和Eureka Client。

Eureka Server提供服务注册服务，各个节点启动后，会在Eureka Server中进行注册，这样EurekaServer中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观的看到。

Eureka Client是一个java客户端，用于简化与Eureka Server的交互，客户端同时也就是一个内置的、使用轮询(round-robin)负载算法的负载均衡器。

在应用启动后，将会向Eureka Server发送心跳,默认周期为30秒，如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，Eureka Server将会从服务注册表中把这个服务节点移除(默认90秒)。

Eureka Server之间通过复制的方式完成数据的同步，Eureka还提供了客户端缓存机制，即使所有的Eureka Server都挂掉，客户端依然可以利用缓存中的信息消费其他服务的API。综上，Eureka通过心跳检查、客户端缓存等机制，确保了系统的高可用性、灵活性和可伸缩性。

#### 2.配置单机eureka

##### 1.创建工程模块

首先创建maven子模块(`cloud-eureka-server7001`)。

##### 2.引入pom依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>cn.infocore.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-eureka-server7001</artifactId>

    <dependencies>
        <!-- eureka服务注册中心 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
        <!-- 热部署 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <!-- lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- 健康监控 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!-- 引入自定义公共模块，可以使用Payment实体类-->
        <dependency>
            <groupId>cn.infocore.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>
</project>
```

##### 3.定义yml配置文件

```yml
server:
  port: 7001

eureka:
  instance:
    hostname: localhost #eureka服务端的实例名称
  client:
    # false表示不向注册中心注册自己
    register-with-eureka: false
    # false表示自己就是注册中心，职责就是维护服务实例，不需要检索服务
    fetch-registry: false
    service-url:
      # 设置与eureka server交互的地址查询服务和注册服务都需要这个地址
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

##### 4.主启动类

```java
@SpringBootApplication
@EnableEurekaServer // 开启eureka server服务
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
```

##### 5.测试

启动服务，在浏览器访问http://localhost:7001/即可看见spring Eureka。

![](D:\Program Files (x86)\WXWork\zhangwei\doc\photo\springcloud-study\3.png)

#### 3.服务提供者注册eureka

为了实现eureka作为注册中心的架构模式，我们需要将我们的服务提供者（cloud-provider-payment8001）注册进入eureka server，这样，服务消费者才能够从注册中心获取到可用服务并调用。

在`cloud-provider-payment8001`子模块中，我们需要重构工程。

因为provider模块是服务提供者，所以主要注册进入eureka server，此时需要通过eureka client注册到server，先添加eureka client依赖：

```xml
 <!-- eureka client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

添加完成后续要再yml配置文件中配置client，否则client无法将服务注册到server：

```yml
# eureka client 配置
eureka:
  client:
    # 表示自己是否注册到eureka server，默认为true
    register-with-eureka: true
    # 是否从eureka server抓取到已有的注册信息，默认为true。单节点环境无所谓，集群环境必须配置true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:7001/eureka
```

最后，我们需要标明该模块时eureka client，在主启动类上加`@EnableEurekaClient`：

```java
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
```

最后测试，先启动eureka server，在启动eureka client，在浏览器的访问http://localhost:7001/，可以看到我们注册到eureka server的服务：

![](D:\Program Files (x86)\WXWork\zhangwei\doc\photo\springcloud-study\5.png)

#### 4.服务消费者注册eureka

配置同服务提供者一样。

#### 5.eureka集群配置
