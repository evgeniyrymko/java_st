delete from room;
delete from bulb;
delete from country;

insert into bulb(id, is_turned_on) values (1, true);
insert into country(id, name) values (1, 'Belarus');
insert into room(id, name, bulb_id, country_id) values (1, 'Room 01', 1, 1);