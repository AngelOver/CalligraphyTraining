# CalligraphyTraining
书法培训平台-墨融轩-公众号


系统初始化
1 导入maven项目，选定perant项目，导入。
2 导入数据库 admin 项目下sql目录，先后导入ct_guns.sql 和 ct_guns_update.sql

启动方式
1 编译器启动：
admin项目,目录下 guns-admin\src\main\java\com\stylefeng\guns\GunsApplication.java文件中有main方法
2打war包：
选中perant项目 run as ->maven bluing,命令填
clean package -Dmaven.test.skip=true

