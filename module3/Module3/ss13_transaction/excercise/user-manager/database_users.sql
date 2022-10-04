USE demo_jdbc;
DELIMITER $$

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END$$

DELIMITER ;

  

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE get_list_user(
)
BEGIN 
SELECT * FROM demo_jdbc.users;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_user(
IN user_id int,
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
UPDATE users SET name=user_name, email = user_email,country = user_country WHERE id=user_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE delete_user(
IN user_id int
)
BEGIN
DELETE FROM users WHERE id=user_id;
END$$
DELIMITER ;

call delete_user(12);

create table Permision(
id int(11) primary key,
name varchar(50)
);
create table User_Permision(
permision_id int(11),
user_id int(11)
);
insert into Permision(id, name) values(1, 'add');
insert into Permision(id, name) values(2, 'edit');
insert into Permision(id, name) values(3, 'delete');
insert into Permision(id, name) values(4, 'view');