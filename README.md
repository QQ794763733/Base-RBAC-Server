# 基于RBAC模型的管理系统服务端

​	这是一款基于RBAC模型的管理系统的服务端，后台界面的地址：[RBAC管理系统后台界面](https://github.com/QQ794763733/Base-RBAC-BackEnd)

## 项目技术

1. **Springboot**
2. **Springboot-Web**
3. **Springboot-Test**
4. **Springboot-Validation**
5. **Springboot-DevTools**
6. **MySQL-Connector-Java**
7. **Mybatis**
8. **MybatisGenerator**
9. **HikariCP**
10. **Apache-Shiro**
11. **Jbcrypt**
12. **Swagger2**
13. **Swagger2-UI**
14. **Log4J2**
15. **Jackson**

## 前端界面预览

![预览图](https://wx3.sinaimg.cn/large/0065B4vHgy1g7mu41vk27j31en0ri464.jpg)

## 接口文档预览

![Swagger文档预览](https://wx1.sinaimg.cn/large/0065B4vHly1g7q3lz7jk4j31en0ri79v.jpg)

![Swagger文档预览](https://wx1.sinaimg.cn/large/0065B4vHly1g7q3lmb0tsj31en0riq8a.jpg)

## 代码注释预览

![认证代码](https://wx4.sinaimg.cn/large/0065B4vHly1g7q3wxgpdyj31gh0togyz.jpg)

## 使用方法

> 提醒：确保已经安装Maven

1. 克隆仓库

```bash
git clone https://github.com/QQ794763733/Base-RBAC-Server.git
```

2. 运行代码

```java
/src/main/java/com/anonymous/developer/www/Application.java
```

> **这个项目还在开发中，作者平时需要上课，偶尔闲暇时间才有机会继续写。**

## 数据库表结构

数据库采用的是MySQL

在项目`/src/main/resources/init.sql`文件下有详细的表结构文件。

```sql
//账户表
CREATE TABLE IF NOT EXISTS account(
account_id INT AUTO_INCREMENT COMMENT '账户表主键',
account_name VARCHAR(20) NOT NULL COMMENT '账户名称',
account_password CHAR(60) NOT NULL COMMENT '账户密码',
account_description VARCHAR(100) NULL DEFAULT NULL COMMENT '账户描述',
account_sex TINYINT NOT NULL DEFAULT 0 COMMENT '账户性别:0为男,1为女',
create_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '创建时间',
operator VARCHAR(20) NOT NULL COMMENT '操作者',
operator_ip VARCHAR(39) NOT NULL COMMENT '操作者IP地址',
operate_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '操作时间',
last_login_datetime TIMESTAMP NULL COMMENT '账户上一次登录时间',
CONSTRAINT u_account_name UNIQUE(account_name),
PRIMARY KEY(account_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT '账户表';

//角色表
CREATE TABLE IF NOT EXISTS role(
role_id INT AUTO_INCREMENT COMMENT '角色表主键',
role_name VARCHAR(20) NOT NULL COMMENT '角色名称',
role_description VARCHAR(100) NULL DEFAULT NULL COMMENT '角色描述',
create_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '创建时间',
operator VARCHAR(20) NOT NULL COMMENT '操作者',
operator_ip VARCHAR(39) NOT NULL COMMENT '操作者IP地址',
operate_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '操作时间',
CONSTRAINT u_role_name UNIQUE(role_name),
PRIMARY KEY(role_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT '角色表';

//账户和角色关系表
CREATE TABLE IF NOT EXISTS relation_account_role(
account_id INT COMMENT '账户表主键',
role_id INT COMMENT '角色表主键',
create_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '创建时间',
operator VARCHAR(20) NOT NULL COMMENT '操作者',
operator_ip VARCHAR(39) NOT NULL COMMENT '操作者IP地址',
operate_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '操作时间',
CONSTRAINT account_role_fk_account_id FOREIGN KEY(account_id) REFERENCES account(account_id),
CONSTRAINT account_role_fk_role_id FOREIGN KEY(role_id) REFERENCES role(role_id),
PRIMARY KEY(role_id,account_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT '账户和角色关系表';

//权限表
CREATE TABLE IF NOT EXISTS permission(
permission_id INT AUTO_INCREMENT COMMENT '权限表主键',
permission_name VARCHAR(30) NOT NULL COMMENT '权限名称',
permission_description VARCHAR(100) NULL DEFAULT NULL COMMENT '权限描述',
permission_parent_id INT NOT NULL DEFAULT 0 COMMENT '权限父级',
create_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '创建时间',
operator VARCHAR(20) NOT NULL COMMENT '操作者',
operator_ip VARCHAR(39) NOT NULL COMMENT '操作者IP地址',
operate_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '操作时间',
CONSTRAINT u_permission_name UNIQUE(permission_name),
PRIMARY KEY(permission_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT '权限表';

//角色和权限关系表
CREATE TABLE IF NOT EXISTS relation_role_permission(
role_id INT COMMENT '角色表主键',
permission_id INT COMMENT '权限表主键',
create_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '创建时间',
operator VARCHAR(20) NOT NULL COMMENT '操作者',
operator_ip VARCHAR(39) NOT NULL COMMENT '操作者IP地址',
operate_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '操作时间',
CONSTRAINT role_permission_fk_role_id FOREIGN KEY(role_id) REFERENCES role(role_id),
CONSTRAINT role_permission_fk_permission_id FOREIGN KEY(permission_id) REFERENCES permission(permission_id),
PRIMARY KEY(role_id,permission_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT '角色和权限关系表';

//菜单表
CREATE TABLE IF NOT EXISTS menu(
menu_id INT AUTO_INCREMENT COMMENT '菜单表主键',
menu_name VARCHAR(10) NOT NULL COMMENT '菜单名称',
menu_icon VARCHAR(255) NOT NULL DEFAULT 'el-icon-menu' COMMENT '菜单图标',
menu_type TINYINT NOT NULL COMMENT '菜单类型:0为下拉菜单,1为菜单组,2为菜单项',
menu_url VARCHAR(255)  DEFAULT NULL COMMENT '菜单URL',
menu_parent_id INT NOT NULL DEFAULT 0 COMMENT '父级菜单ID',
create_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '创建时间',
operator VARCHAR(20) NOT NULL COMMENT '操作者',
operator_ip VARCHAR(39) NOT NULL COMMENT '操作者IP地址',
operate_datetime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '操作时间',
CONSTRAINT u_menu_name UNIQUE(menu_name),
PRIMARY KEY(menu_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT '菜单表';
```

## 关于作者

**如果喜欢这个项目可以加作者的微信一起探讨。**

<img src="https://wx2.sinaimg.cn/large/0065B4vHgy1g7mvg2rc15j30e80e8dg6.jpg" width="20%"/>

**如果这个项目有帮助到您，您愿意打赏的话，请扫描下面的二维码进行打赏。**

<img src="https://wx3.sinaimg.cn/large/0065B4vHgy1g7mv8zdyvwj3078078jr5.jpg" width="20%"/>



