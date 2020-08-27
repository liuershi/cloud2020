# Nacos整合Mysql8

## 1.环境

**version**

- nacos：1.1.4
- mysql：8.0.18

## 2.问题描述

使用nacos时，默认使用内置的derby，切换内置数据库为mysql时，不支持mysql8+版本，启动nacos抛出异常如下（部分）：

[![d40SBR.png](https://s1.ax1x.com/2020/08/27/d40SBR.png)](https://imgchr.com/i/d40SBR)



## 3.问题原因

nacos1.1.4源码中pom.xml依赖的mysql驱动版本为5.1.34，而实际mysql数据库版本8.0+，所以启动nacos时导致连接数据库失败。

## 4.解决办法

下载nacos源码 https://github.com/alibaba/nacos 选择需要的版本，我这里选择的是1.1.4



1. 修改最外层pom.xml 中 mysql驱动版本，我这边使用的是8.0.18

   ```xml
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.18</version>
   </dependency>
   ```

2. 修改naming这个项目 com.alibaba.nacos.naming.healthcheck 包下的 MysqlHealthCheckProcessor 类的第24行导包为：

   ```java
   import com.mysql.cj.jdbc.MysqlDataSource;
   ```

3. 由于mysql8及其以上版本需要带时区，所以还需要修改 console这项目 resources/META-INF下 nacos-default.properties这个文件中的db.url

   ```properties
   db.url.0=jdbc:mysql://11.162.196.161:3306/diamond_devtest?serverTimezone=GMT%2B8&characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
   db.url.1=jdbc:mysql://11.163.152.91:3306/diamond_devtest?serverTimezone=GMT%2B8&characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
   ```



## 5.打包

cmd命令窗口进入项目根目录执行：

```cmd
mvn -Prelease-nacos clean install -U
```

执行完成之后打包好的文件在项目根目录下：

```cmd
根目录\distribution\target
```





创建数据库nacos并运行nacos/conf/nacos-mysql.sql 文件，创建表格

配置自己的mysql地址 在nacos/conf/application.properties中添加

```properties
spring.datasource.platform=mysql

db.num=1
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos?serverTimezone=GMT%2B8&characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
db.user=root
db.password=123456
```

**注意：在db.url.0中添加时区 serverTimezone=GMT%2B8**



## 6.访问

启动nacos之后，在浏览器访问即可：

```http
http://localhost:8848/nacos
```

