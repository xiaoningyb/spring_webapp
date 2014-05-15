springmvc+freemaker+mybatis webapp project
=============

1. generatorConfig.xmlfordatabase

2. mvn mybatis-generator:generate

3. mvn compile

4. mvn eclipse:eclipse

5. mvn war:war

6.mvn jetty:run （9080）

postgresql DB
init:
/opt/local/lib/postgresql91/bin/initdb ./data

start :
/opt/local/lib/postgresql91/bin/pg_ctl -D ./data/ -l ./log/log.log start

create db:
/opt/local/lib/postgresql91/bin/createdb ning_webapp_db

connect:
/opt/local/lib/postgresql91/bin/psql -d ning_webapp_db 
