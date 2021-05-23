create table Products
(
    Pnum          INTEGER
        constraint Products_pk
            primary key,
    Created_date  date default CURRENT_TIMESTAMP not null,
    Modified_date date default CURRENT_TIMESTAMP not null
);

create table H_coffee
(
    Pnum  int
        references Products
            on update cascade on delete cascade,
    name  text not null,
    price int default 0 not null
);

create unique index H_coffee_name_uindex
    on H_coffee (name);

create table I_coffee
(
    Pnum  int  not null
        references Products
            on update cascade on delete cascade,
    name  text not null,
    price int default 0 not null
);

create unique index I_coffee_name_uindex
    on I_coffee (name);

create table MD
(
    Pnum  int
        references Products
            on update cascade on delete cascade,
    name  text not null,
    price int default 0 not null
);

create unique index MD_name_uindex
    on page.product.MD (name);

create table dessert
(
    Pnum  int
        references Products
            on update cascade on delete cascade,
    name  text not null,
    price int default 0 not null
);

create unique index dessert_name_uindex
    on dessert (name);

create table user_account
(
    Unum         int
        constraint user_account_pk
            primary key,
    name         int,
    user_id      int not null,
    created_date date default CURRENT_TIMESTAMP
);

create unique index user_account_id_uindex
    on user_account (user_id);

create table user_point
(
    Unum        int
        references user_account
            on update cascade on delete cascade,
    user_point  int default 0 not null,
    user_coupon int default 0
);

create table user_pw
(
    Unum    int
        references user_account
            on update cascade on delete cascade,
    user_pw text not null
);


