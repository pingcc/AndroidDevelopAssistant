# AndroidDevelopAssistant
android 开发助手，集成可实现快速开发

集成步骤：
1.在根目录的build.gradle中添加仓库下载地址

  repositories {
        google()
	mavenCentral()
//        jcenter()
        maven { url "https://jitpack.io" }
    }
    
    
2.在项目中依赖jar包
   
   dependencies {
	        implementation 'com.github.pingcc:AndroidDevelopAssistant:1.0.2'
	        }
	
  即可集成达到快速开发android项目
