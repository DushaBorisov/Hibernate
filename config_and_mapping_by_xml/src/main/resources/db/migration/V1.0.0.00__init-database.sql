create table if not exists users
(
    id          bigint,
    name        varchar(255) not null,
    surname     varchar(255) not null,
    age         integer not null,

    constraint user_id primary key(id)
);