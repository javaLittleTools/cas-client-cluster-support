# cas-client-cluster-support

**参考文章：**[CAS 使用经验总结，纯干货](https://ningyu1.github.io/site/post/54-cas-server/)

这里使用 memcached 做服务器间的 Session 同步，创建 Session 监听器将 Session 存到 HashMap 中，JDBC 的方式来存储 Session Mapping

数据库表：
```mysql
create table session_mapping
(
  id int auto_increment primary key,
  mapping_id varchar(50) null,
  session_id varchar(50) null
);
```

