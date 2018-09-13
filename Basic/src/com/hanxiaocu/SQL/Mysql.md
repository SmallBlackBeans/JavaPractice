# MySQL
#### 安装
```sql
brew install mysql
```

#### 配置密码
```sql
mysql_secure_installation
xxxx
```

#### 登录
```sql
mysql -uroot -h127.0.0.1 -pMysql@xxx
```

#### 退出数据库
```sql
mysql_upgrade -u root -p;
```

#### 命令用于设置使用的字符集 临时的

```
set names utf8; 
等价于
SET character_set_client = utf8;     
SET character_set_results = utf8;    
SET character_set_connection = utf8; 
```

#### 添加用户 并分配选择 插入 更新的权限
```sql
use mysql;
INSERT INTO user 
          (host, user, password, 
           select_priv, insert_priv, update_priv) 
           VALUES ('localhost', 'guest', 
           PASSWORD('guest123'), 'Y', 'Y', 'Y');
```

#### 重新载入授权表
```sql
flush privileges;
```

#### 给某个用户分配某个数据库下的权限，不存在用户，会自动添加
```sql
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
        ON database.*
        TO ‘hanxiaocu'@'localhost'
        IDENTIFIED BY ‘123456’;
```


#### 删除数据库
```sql
drop database xxx;
```

#### 查看列
```sql
show culumns from table;
```

#### 查看表信息
```sql
desc table;
```

#### 复合主键 一个表中多个字段表示记录的唯一性
#### 联合主键 多表之间的关联表中，多个主键的组合

#### 创建表
```sql
create table if not exists `test`(
    -> `id` int unsigned auto_increment,
    -> `name` varchar(100) not null,
    -> primary key (`id`)
    -> )engine=InnoDB default charset=utf8;
```

#### 删除表
```sql
drop table xxx;
```

只是删除表中数据，不删除表本身
```sql
truncate table tablename;
```

#### 插入多条 数据
如果数据是字符型，必须使用单引号或者双引号，如："value"。
```sql
Insert into tablename (name,age,date) 
values 
(“hanxiaocu”,22,NOW()),
(“Xiaoli ”,22,NOW()),
(“Xiaohong ”,22,NOW());
```
==
-------

#### 约束
##### 主键约束
```sql
CREATE TABLE Persons
(
    Id_P int NOT NULL PRIMARY KEY,   //PRIMARY KEY约束 = Union + not null
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
)
```

##### UNIQUE 唯一 约束
每个表可以有多个 UNIQUE 约束，但是每个表只能有一个 PRIMARY KEY 约束
```sql
CREATE TABLE Persons
(
P_Id int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255),
CONSTRAINT uc_PersonID UNIQUE (P_Id,LastName)
)
ALTER TABLE Persons ADD UNIQUE (P_Id)
ALTER TABLE Persons ADD CONSTRAINT uc_PersonID UNIQUE (P_Id,LastName) 多列Union约束
ALTER TABLE Persons DROP INDEX uc_PersonID 删除Union约束 约束名 uc_PersionID
alter table tb add constraint pk_id primary key (tb_id); 添加主键约束
alter table tb add constraint un_name unique (tb_name);  添加唯一约束
```
###### 外键
```mysql
CREATE TABLE 表名
    (
        column1 datatype null/not null,
        column2 datatype null/not null,
        ...
        CONSTRAINT 外键约束名 FOREIGN KEY  (column1,column2,... column_n) 
        REFERENCES 外键依赖的表 (column1,column2,...column_n)
        ON DELETE CASCADE--级联删除
    );
```

###### 添加外键约束 外键在哪个表谁就是子表，主键所在表是主表
```mysql
ALTER TABLE 表名
    ADD CONSTRAINT 外键约束名
    FOREIGN KEY (column1, column2,...column_n) 
    REFERENCES 外键所依赖的表 (column1,column2,...column_n)
    ON DELETE CASCADE;--级联删除
 ```
当没有指定CASCADE 删除主表会报错，
1、添加指定级联约束
2、禁用外键约束
 ```sql
 ALTER TABLE 表名 disable constraint 约束名;
```
子表插入的前提是主表一定要有对应的数据
```sql
ALTER TABLE Orders DROP FOREIGN KEY fk_PerOrders 删除外键约束
```

###### Check约束
```mysql
CREATE TABLE Persons
(
P_Id int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255),
CONSTRAINT chk_Person CHECK (P_Id>0 AND City='Sandnes')
)
```
###### default 约束
DEFAULT 约束用于向列中插入默认值
```mysql
CREATE TABLE Persons
(
    P_Id int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255) DEFAULT ‘Sandnes’,
    Birthday date Default GETDATE()
)
ALTER TABLE Persons ALTER City DROP DEFAULT 删除默认约束
```

#### 查询
```mysql
Select column1,column2 from tablename;

SELECT name, CONCAT(url, ', ', alexa, ', ', country) AS site_info
FROM Websites;
```

##### 条件查询 BINARY 区分大小写
```sql
SELECT * from tablename
WHERE BINARY runoob_author='RUNOOB.COM’;

SELECT * FROM Websites
WHERE (alexa BETWEEN 1 AND 20)
AND NOT country IN ('USA', 'IND’);
```

##### 更新
通过设置 sql_safe_updates 当该参数开启的情况下，你必须在update 语
句后携带 where 条件，否则就会报错。
```
set sql_safe_updates=1; 表示开启该参数
```
```sql
Update tablename set field1=newvalue, field2= newvalue2 where condition;
```
批量修改某一个字段
```sql
UPDATE tablename SET field = REPLACE(field, ‘oldvalue', ’newvalue') where condition;
```
等价于
```sql
Update tablename set field= newvalue where field = oldvalue;
```

##### 删除记录
```sql
Delete from tablename where condition;
```

##### 模糊查询
%任意长度字符
```sql
select * from tablename where field LIKE ‘%xxx%’ AND condition
```
_占一位字符，查询三个字符的field
```sql
select * from tablename where field LIKE ‘_x_’ AND condition
```

##### Union 联合查询
用来合并多个select语句 
内部的每个 SELECT 语句必须拥有相同数量的列，列也必须拥有相似的数据类型 ，每个 SELECT 语句中的列的顺序必须相同
```sql
Select field1 from table1 where condition1
union all | distinct(去重，默认去重)
Select field2 from table2 where condition2
Order by commonfield;
```

##### 排序
```sql
select field from tablename order by filed DESC; 默认升序ASC
```
汉字排序
如果字符集采用的是 gbk(汉字编码字符集)
```sql
SELECT * FROM tablename
ORDER BY CONVERT(field using gbk);
```
order by 多列时，是按顺序排序的，第二列的排序集合是第一列的排序集合中的每一组

##### 分组
按某一列统计分组，并显示每组的数量
```sql
select field，COUNT(*) from tablename Group by field;
```
with rollup 分组然后汇总
```sql
select field1, SUM(filed2) as sum from tablename group by filed1 with rollup;
+--------+--------------+
| filed1   | sum |
+--------+--------------+
| 小丽 |            2 |
| 小明 |            7 |
| 小王 |            7 |
| NULL |           16 |
+--------+———————+
```
coalesce(a,b,c)  来设置一个可以取代 NUll 的名称 只有a b c 都为null时才 为null
```sql
select coalesce(filed1,'总数’)，SUM(filed2) as sum from tablename group by field1 WITH ROLLUP;
+--------------------------+--------------+
| coalesce(filed1, '总数') | sum |
+--------------------------+--------------+
| 小丽                   |            2 |
| 小明                   |            7 |
| 小王                   |            7 |
| 总数                   |           16 |
+--------------------------+———————+
```

##### 多表查询 左右连接
Inner join === join 两个表交集的数据
letf join 包含左表所有数据，一般就是为了给左表补充一些右表中交集额外的信息(字段)，可能为NULL
```sql
select a.field1, t1.field2,  b.field1 from tablename1 a left join tablename2 b 
        ON  a.field = b.field;
```
inner join <= min(left join, right join)
full join >= max(left join, right join)
当 inner join < min(left join, right join) 时， full join > max(left join, right join)

#### Mysql NULL 处理
不能使用= !=运算符
NULL = NULL  返回是false
```sql
select field from tablename where filed IS (NOT) NULL;
```

IFNULL 
```sql
select product_name, IFNULL(price,0) from product_tb;
```
等价
COALESCE 合并，可以合并多个值，如果都为null,才为null
```sql
select product_name, COALESCE(price,0) from product_tb;
```

#### 正则
select name from tablename where name regexp ‘^韩’;
select name from user where name regexp ‘^[aeiou]|ok$'

#### 事务
事务主要用于处理操作量大，复杂度高的数据
MySQL 中只有使用了 Innodb 数据库引擎的数据库或表才支持事务
事务处理可以用来维护数据库的完整性，保证成批的 SQL 语句要么全部执行，要么全部不执行。
事务用来管理 insert,update,delete 语句
* A 原子性 要么ok  要么滚回去
* C 一致性  开始之前和结束之后都不会破坏数据库的完整性
* I 隔离性 并发事务
* D 持久性 事务结束后，事务的修改是永久的，不会因为系统故障丢失，即一次事务的结果是不会回滚的。
 SET AUTOCOMMIT=0/1 禁用/开启当前会话自动提交
 
BEGIN或START TRANSACTION；显式地开启一个事务
COMMIT；提交事务

ROLLBACK; 回滚会结束用户的事务，并撤销正在进行的所有未提交的修改

SAVEPOINT identifier；SAVEPOINT允许在事务中创建一个保存点，一个事务中可以有多个SAVEPOINT

RELEASE SAVEPOINT identifier；删除一个事务的保存点，当没有指定的保存点时，执行该语句会抛出一个异常；

ROLLBACK TO identifier；把事务回滚到标记点

SET TRANSACTION；用来设置事务的隔离级别。InnoDB存储引擎提供事务的隔离级别有
* READ UNCOMMITTED、READ COMMITTED、REPEATABLE READ 和 SERIALIZABLE


#### Alter 命令
修改数据表名或者修改数据表字段
删除字段
```sql
alter table tablename drop field;
```
添加字段
```sql
alter table tablename add fileld fileldType;
```
插入字段到指定位置
```sql
alter table tablename add field fieldType frist;
alter table tablename add field fieldType after filedOther;
```
修改字段类型和名称
```sql
alter table tablename modify fieldnewName fieldNewType;
alter table tablename change fieldnewName fieldnewName fieldNewType;
```
Null 和默认值
```sql
alter table tablename modify fieldnewName fieldNewType not null default 100 auto_increment;
```
修改字段默认值
```sql
alter table tablename alter field set default 1000;
alter table tablename alter field drop default;
```
修改表状态
```sql
alter table tablename engine=MYISAM; 修改存储引擎
```
```sql
show table status like ’tablename’\G
```
\g 的作用是分号和在sql语句中写’;’是等效的 
\G 的作用是将查到的结构旋转90度变成纵向

修改表名
```sql
alter table tablename rename to|as tableNewName;
```
删除外键约束
```sql
alter table tablename drop foreign key keyname;
```

#### 索引
在不读取整个表的情况下，索引使数据库应用程序可以更快地查找数据
索引也是一张表，该表保存了主键与索引字段，并指向实体表的记录.
索引大大提高了查询速度，同时却会降低更新表的速度.
如对表进行INSERT、UPDATE和DELETE。因为更新表时，MySQL不仅要保存数据，还要保存一下索引文件。
建立索引会占用磁盘空间的索引文件 .
普通索引
```sql
create index indexname on tablename(filed(length));
```
修改表结构
```sql
alter table tablename add index indexname(columnname);
```
```sql
create table tablename(
id int not null,
name varchar(16) not null,
index [indexname] (name(length))
);
```

##### 删除索引
```sql
drop index indexname on tablename;
alter table tablename drop index index_name;
```

##### 唯一索引（值或者值的组合必须唯一，允许有控制）
```sql
create unique index indexname on tablename(fieldname(length));
alter table tablename add unique index [indexname] (fieldname(length));
```

##### 添加或者删除索引
```sql
alter table tablename add primary key (column_list); 主键索引，值唯一切不能为NULL
alter table tablename add unique indexname (column_list);索引值唯一 可以有多个NULL
alter table tablename add index indexname(column_list); 普通索引，可以多次出现
alter table tablename add fulltext indexname(column_list); 全文索引
```

##### 修改和删除主键
```sql
alter table tablename modify filed fieldType not null;
alter table tablename add primary key (field);
alter table tablename drop primary key;
```
```sql
show index from tablename;\G
```

#### 临时表 只针对当前连接
```sql
create temporary table tablename(
);
```

#### 视图
可视化的表，视图总是显示最新的数据
创建视图
```sql
CREATE VIEW view_name AS
SELECT column_name(s)
FROM table_name
WHERE condition
```
更新视图
```sql
CREATE OR REPLACE VIEW view_name AS
SELECT column_name(s)
FROM table_name
WHERE condition
```
删除视图
```sql
DROP VIEW view_name
```

#### 复制表
完全的复制MySQL的数据表，包括表的结构，索引，默认值
* 方法一：     
    ```sql
       show create table tablename;\G 显示创建表时的创建语句
    ```
    然后重新创建一个克隆表 然后从原始表查询数据插入
    ```sql
    insert into cloneT select * from sourceT; // mysql 不支`持 select into 语句
    ```

* 方法二:
    ```sql
    create table cloneT LIKE sourceT;
    insert into cloneT select * from sourceT;
    ```
    
拷贝一个表中的一些字段

```sql
CREATE TABLE 新表
AS
SELECT * FROM 旧表 

create table cloneT as
(
    select id, name as newname, password as pwd from sourceT
    //这里可以用where 做过滤
    如select * from sourceT where left(username,1)=’s’ //left(str,length) 从左截取字符串
)

create table cloneT
(
    id integer not null auto_increment primary key
)
as
(
    select * from sourceT
)
```

#### 元数据
一些数据信息，查询影响条数 数据库状态 版本号等

#### 序列使用
想实现其他字段也实现自动增加 auto_increment;
LAST_INSERT_ID( ) 函数来获取最后的插入表中的自增列的值
删除数据记录后，对序列重新排列，最好开一个事务，防止重排的时候又有数据插入
```sql
alter table tablename drop id;
alter table tablename add id int not null auto_increment first,add primary key(id);
```

##### 设置序列的开始值
```sql
alter table table_name  auto_increment = 100;
```

#### 重复数据处理
insert ignore into 忽略插入重复数据，前提设置数据的唯一性，即主键或者复合主键，或者设置Unique 索引。
replace into 则先删除掉，再插入新记录
```sql
insert ignore into tablename(last_name, first_name) values(xx,xx);
```

统计重复数据
```sql
select count(*) as repeatCount, last_name, first_name
            from tablename
            group by last_name, first_name
            having repeatCount > 1;
```
where是从逐条磁盘读入,然后判断，如果满足再放入内存，应用对象是每一条数据
having现将所有数据读入内存，在内存中判断，先分组再判断，应用对象是组
having子句中可以使用字段别名，而where不能使用
having能够使用统计函数，但是where不能使用

#### 过滤重复数据
```sql
select distinct field from tablename;
select field1,field2 from tablename group by (field1,field2);
```
   

#### 删除重复数据
* 方法一:
    ```sql
    create table tem select last_name, first_name,sex
            from person_tbl group by
            (last_name,first_name,sex);
            drop table person_tbl;
            alter table tem rename to person_tbl;
    ```
    
* 方法二:
    ```sql
       alter ignore table tablename add primary key
           (last_name, first_name);
    ```

#### 导出数据
```sql
select * from tablename into outfile ‘/tem/db.txt’;
```
指定输出格式 csv
指出列值的分隔符和行尾标记
```sql
select * from tablename into outfile ‘/tem/db.txt’
        fileds terminated by ‘,’ optionally enclosed by ‘“'
        lines terminated by ‘\r\n’;
```

```sql
SELECT a,b,a+b INTO OUTFILE '/tmp/db.text'
        FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
        LINES TERMINATED BY '\n'
        FROM test_table;
```

导出表作为原始数据
```sql
mysqldump -u root -p --no-create-info \
            --tab=/tmp db tablename
```

导出sql格式数据
```sql
mysqldump -u root -p db tablename > dump.sql 某一张表

mysqldump -u root -p RUNOOB > database_dump.sql 整个数据库

mysqldump -u root -p --all-databases > database_dump.sql 备份所有数据库

mysqldump -u root -p db_name | mysql -h other-host db_name 导出到远程mysql服务器

mysqldump -h other-host -P port -u root -p db_name > dump.sql 导出远程数据库到本地
```
导入数据到数据库
```sql
mysql
mysql -u root -p db_name < dump.sql
```
source 先登录到数据库
```sql
source /tem/db.sql
load data
load data local infile ‘db.txt’ into table tablename
        fileds terminated by ‘:’
        lines terminated by ‘\r\n';
```
使用mysqlimport
```sql
mysqlimport -u root -p —local 
    —columns=field1,field2,field3 指定列顺序
    --fields-terminated-by=“:"
    --lines-terminated-by="\r\n"
     db_name db.txt
```

#### 函数
##### AVG()
```sql
SELECT site_id, count FROM access_log
WHERE count > (SELECT AVG(count) FROM access_log);
```
##### COUNT()不会计算NULL 的行
```sql
SELECT COUNT(*) FROM table_name;
计算某一列不重复项的行数
SELECT COUNT(DISTINCT column_name) FROM table_name;
```

##### FIRST() LAST() 只有Access支持
```sql
SELECT column_name FROM table_name
ORDER BY column_name ASC
LIMIT 1;
SELECT column_name FROM table_name
ORDER BY column_name DESC
LIMIT 1;
```

##### MAX() MIN() SUM()
```sql
SELECT MAX(alexa) AS max_alexa FROM Websites;
```

##### GROUP BY用于结合聚合函数，根据一个或多个列对结果集进行分组
```sql
SELECT site_id, SUM(access_log.count) AS nums
FROM access_log GROUP BY site_id;
多表连接
SELECT Websites.name,COUNT(access_log.aid) AS nums FROM access_log
LEFT JOIN Websites
ON access_log.site_id=Websites.id
GROUP BY Websites.name;
```
##### Having 
在 SQL 中增加 HAVING 子句原因是，WHERE 关键字无法与聚合函数一起使用。
```sql
SELECT Websites.name, SUM(access_log.count) AS nums FROM Websites
INNER JOIN access_log
ON Websites.id=access_log.site_id
WHERE Websites.alexa < 200 
GROUP BY Websites.name
HAVING SUM(access_log.count) > 200;
```
##### UCASE() LCASE() 大小写转换
```sql
SELECT UCASE(name) AS site_title, url FROM Websites;
```
##### MID() 文本中提取字符
```sql
SELECT MID(name,1,4) AS ShortTitle FROM Websites; 提取前四个字符
```
##### LEN() 返回文本长度
```sql
SELECT name, LENGTH(url) as LengthOfURL FROM Websites;
```
##### ROUND()四舍五入
```sql
select ROUND(-1.23); ——> -1 
select ROUND(1.298, 1); ——> 1.3 保留一位小数
```
##### NOW()返回当前系统日期和时间
```sql
SELECT name, url, Now() AS date FROM Websites;
```
##### FORMAT() 对字符串显示格式化
```sql
SELECT name, url, DATE_FORMAT(Now(),'%Y-%m-%d') AS date FROM Websites;
```











