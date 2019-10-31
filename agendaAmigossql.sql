use agendaAmigos;
delimiter //
create procedure insertFriend(
in namep varchar(255),
in phonep varchar(10), in addressp text, in birthdayp date, in imagep blob)
begin
insert into friend( name, phone, address, birthday, image)
values (namep ,phonep, addressp, birthdayp, imagep);
end //
delimiter ;

call insertFriend('Luis','2292222374','address','1993-09-06','');
select*from friend;

delimiter //
create procedure insertMeeting(
in placec text,
in date_ofc timestamp)
begin
insert into meeting(place,date_of) values(placec,date_ofc);
end //
delimiter ;
call insertMeeting('Escuela','2019-06-15 09:30:00');
select*from meeting;

delimiter //
create procedure select_all_friend()
begin 
SELECT * FROM friend order by name desc;
end //
delimiter ;
call select_all_friend;

delimiter //
create procedure select_a_friend(in id int)
begin 
SELECT * FROM friend where idfriend=id;
end //
delimiter ;
call select_a_friend;