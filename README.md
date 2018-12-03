# cas-client-cluster-support

**参考文章：**[CAS 使用经验总结，纯干货](https://ningyu1.github.io/site/post/54-cas-server/)

这里使用 JDBC 的方式来存储 Session Mapping

数据库表：
```
create table session_mapping
(
  id int auto_increment primary key,
  mapping_id varchar(50) null,
  session_id varchar(50) null
);
```
