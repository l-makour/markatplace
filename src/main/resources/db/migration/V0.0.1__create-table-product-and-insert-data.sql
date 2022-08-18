create table if not exists product (
    id integer primary key,
    name varchar(32),
    price float
    );

insert into product (id, name, price)
values (1, 'Pc portable', 2000),
       (2, 'clavier', 20),
       (3, 'Ecran', 30),
       (4, 'Ecran', 30)
