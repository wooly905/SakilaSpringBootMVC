FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=1234567890
ENV MYSQL_DATABASSE_SAKILA=Sakila

COPY my.cnf /etc/mysql/conf.d/

RUN mkdir -p /var/lib/mysql-kering

EXPOSE 3306
