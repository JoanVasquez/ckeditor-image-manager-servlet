# CKEditor-Image-Manager-Servlet
In this code I will show you how to upload images with **Servlet** and retrieve them using **CKEditor**. I am also using **Apache Common** to manage the files. Whether this project helped you, donate for a coffee. Thanks.

[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=AFSV8TQBVW6LC)

## Instruction
Remember to run **maven** to install the **dependencies**.

## Structure
* src
    * ckeditor
        * image
            * ImageManager.java
* WebContent
    * assets
        * ckeditor
        * main.js
    * ckbrowser.html
    * index.html

## Dependecies of this project
```xml
<dependencies>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-annotations-api</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-catalina-ant</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-catalina-ha</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-storeconfig</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-tribes</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-catalina</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.eclipse.jdt</groupId>
			<artifactId>ecj</artifactId>
			<version>3.12.3</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-el-api</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-jasper-el</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-jasper</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-jaspic-api</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-jsp-api</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-servlet-api</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-api</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-coyote</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-dbcp</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-i18n-es</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-i18n-fr</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-i18n-ja</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-jdbc</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-jni</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-util-scan</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-util</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-websocket</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-websocket-api</artifactId>
			<version>9.0.4</version>
		</dependency>
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.3.1</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-core</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-annotations</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.9.2</version>
		</dependency>
	</dependencies>
```

## Demonstration
![CKEditor](https://raw.githubusercontent.com/JoanVasquez/ckeditor-image-manager-servlet/master/1.PNG)
![CKEditor](https://raw.githubusercontent.com/JoanVasquez/ckeditor-image-manager-servlet/master/2.PNG)
![CKEditor](https://raw.githubusercontent.com/JoanVasquez/ckeditor-image-manager-servlet/master/3.PNG)