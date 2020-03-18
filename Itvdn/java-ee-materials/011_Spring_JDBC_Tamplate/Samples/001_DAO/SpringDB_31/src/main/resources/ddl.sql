CREATE database if not exists songs;

use songs;

CREATE TABLE IF not exists mp3(
  id int primary key not null auto_increment,
  name varchar(40),
  author varchar(40)
);