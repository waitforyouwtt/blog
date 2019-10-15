1. 重写 org.hibernate.cfg PropertyContainer 类，解决mybatis自动创建表字段乱序问题
2. 开启热部署[步骤如下]：
   1.pom.xml 文件引入文件 
   2.File->setting->搜索compiler->将Build project automatically打勾（注意后面only works not running/debugging
   3.CTRL+ALT+SHIFT+/ 组合键打开 Maintenance窗口选择Registry... ,找到compiler.automake.allow.when.app.running选项，打勾开启运行时编译功能
