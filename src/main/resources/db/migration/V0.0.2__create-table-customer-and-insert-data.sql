create table if not exists customer (
    id integer primary key,
    username varchar(64),
    lastname varchar(64),
    firstname varchar(64),
    amount float
    );

insert into customer (id, username, lastname,firstname,amount)
values (1, 'lmakour', 'makour','lahcene',12000),
       (2, 'sbenbelkacem','benbelkacem','samir', 1000),
       (3, 'hsdahmane', 'hs','dahmane',1500),
       (4, 'mchekini','chekini','mehdi', 3000)