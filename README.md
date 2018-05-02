# i18n
国际化工具（适用于一切项目）

## 简介
利用配置文件进行项目国际化多语言的工具包

资源文件为典型的java properties文件，通过key=value形式定义国际化需要的消息，其中key为各语言消息统一使用的消息编码，用户通过language和key可以获得唯一对应的消息value。

## 依赖环境
（1）java8

（2）maven

## 导入工程
（1）clone工程源码，在源码目录下控制台运行mvn install -Dmaven.test.skip=true进行jar包的构建。

（2）构建完成后在 /target 目录下可以找到 i18n.jar, i18n-sources.jar, 分别为工程打包之后的可执行文件及源码文件。

（3）将jar文件导入到需要添加的项目工程路径中，修改类路径即可。

## maven下导入类路径依赖
（1）将jar文件导入到需要添加的项目工程路径中。

（2）构建配置文件pom依赖中引入以下代码：

```
<dependencies>
    <dependency>
		<groupId>com.github.johnsonmoon</groupId>
		<artifactId>i18n</artifactId>
		<version>1.0</version>
		<scope>system</scope>
		<systemPath>${basedir}/src/main/lib/i18n-1.0.jar</systemPath>
	</dependency>
</dependencies>
```

（3）工程目录控制台运行 mvn compile。

## 如何使用
### 1.初始化工具
#### （1）直接通过程序入口进行初始化

```
public static void main(String[] args) throws I18nException {
	//默认语言
	String defaultLanguage = "zh_CN";
	//多语言消息配置文件存放路径
	String languageResourceFilePath = System.getProperty("user.dir") + File.separator
			+ "src/test/resources/conf/i18n";
	//初始化多语言工具
	I18nInit.getInstance(defaultLanguage, languageResourceFilePath).init();
}
```

#### （2）通过Spring配置bean进行初始化
app-context.xml:

```
<bean id="i18nInit" class="I18nInit" init-method="init">
	<constructor-arg name="defaultLanguage" type="java.lang.String"
		value="${i18n.default.language}" />
	<constructor-arg name="languageResourceFilePath" type="java.lang.String"
		value="${i18n.file.path}" />
</bean>
```

### 2.添加配置文件
（1）在项目中添加多语言消息配置文件，命名格式为 *-en_US.properties，其中en_US代表配置文件消息的国家语言。

（2）配置文件中添加key=value形式的语言编码=值 键值对，例如如下

```
test.hello=hello!
test.hello.people=hello, %s!
```

### 3.通过key获取相应语言的消息
通过I18nUtils类的静态方法getMessage即可获取配置的消息，如下：

```
System.out.println(I18nUtils.getMessage("en_US", "test.hello"));
System.out.println(I18nUtils.getMessage("en_US", "test.hello.people", "Johnson"));
```

执行结果如下：

```
hello!
hello, Johnson!
```
