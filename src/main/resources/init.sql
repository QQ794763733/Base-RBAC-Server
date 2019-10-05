
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

INSERT INTO account(account_name,account_password,account_description,account_sex,operator,operator_ip)
VALUES('xiaoyu','$2a$10$kunyRzZrXo7w2jrWyJmsCuJN3L9P9eR2QDKS3LZkl097Q4.MoBb9q','系统账户',0,'system','127.0.0.1');

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

INSERT INTO role(role_name,role_description,operator,operator_ip)
VALUES('Administrator','拥有系统所有权限','system','127.0.0.1');


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

INSERT INTO relation_account_role(role_id,account_id,operator,operator_ip)
VALUES(1,1,'system','127.0.0.1');

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