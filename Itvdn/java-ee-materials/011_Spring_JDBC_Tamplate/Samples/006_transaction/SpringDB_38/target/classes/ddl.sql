CREATE  database if not exists songs;

use songs;

DROP table if exists mp3;

DROP table if exists author;

CREATE TABLE IF not exists author(
  id int not null auto_increment,
  name varchar(40),
  primary key(id)
);


CREATE TABLE IF not exists mp3(
  id int not null auto_increment,
  name varchar(40),
  author_id int not null,
  primary key(id),
  foreign key(author_id) references author(id)
);

CREATE VIEW mp3_view
AS SELECT a.name as author_name, a.id as author_id, m.name as mp3_name, m.id as mp3_id
   FROM mp3 m inner join author a on m.author_id = m.id;