# Generator Maven Plugin
代码自动生成Maven插件，根据数据库表生成对应的实体类、数据持续层、业务层、控制层源代码。

## 配置文件示例
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE config>

<config>
    <settings>
        <setting name="enableSerializable" value="true"/>
    </settings>
    <dataSource
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://47.104.148.155:3306/codeartist"
            username="root"
            password="root"
    />
    <javaModelGenerator
            targetPackage="com.codeartist.mybatis.disc.model"
            targetProject="./src/main/java"
    />
    <mapperGenerator
            targetPackage="com.codeartist.mybatis.disc.mapper"
            targetProject="./src/main/java"
    />
    <javaDaoGenerator
            targetPackage="com.codeartist.mybatis.disc.dao"
            targetProject="./src/main/java"
    />
    <table className="Admin" tableName="admin"/>
    <table className="" tableName="role"/>
</config>
```

## 使用配置示例
```xml
<plugin>
    <groupId>cn.codeartist</groupId>
    <artifactId>codegenerator-maven-plugin</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <configuration>
        <configFile>${basedir}/src/main/resources/generatorConfig.xml</configFile>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>cn.codeartist</groupId>
            <artifactId>code-generator</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</plugin>
```