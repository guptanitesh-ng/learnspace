create table app.book (
	isbn varchar(13) primary key,
	nook_name varchar(100) not null,
	price double,
	stock_unit integer,
	check (stock_unit >= 0)
);

create table app.account (
	user_name varchar(100) primary key,
	balance double,
	check (balance >= 0.0)
);

insert into APP.BOOK values('we89e29eu', 'Spring Reference', 10.0, 2);

insert into APP.BOOK values('u3fy4834', 'Spring in Action', 50, 2);

insert into APP.ACCOUNT values ('user1', 40);

insert into APP.ACCOUNT values ('user2', 50);
