# DELETE FROM mysql.user WHERE USER='test';
# CREATE USER  'test'@'%' IDENTIFIED BY 'test123';
# GRANT ALL PRIVILEGES ON *.* TO 'test'@'%' IDENTIFIED BY 'test123';
# GRANT ALL PRIVILEGES ON *.* TO 'test'@'localhost' IDENTIFIED BY 'test123';
# FLUSH PRIVILEGES;

DROP DATABASE IF EXISTS hibernate;
CREATE DATABASE hibernate;
USE hibernate;
