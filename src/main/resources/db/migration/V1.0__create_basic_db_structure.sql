create sequence if not exists text_id_seq start 1 increment 1;
create sequence if not exists word_id_seq start 1 increment 1;
create sequence if not exists word_occurrence_id_seq start 1 increment 1;

create table text (
    id                bigint not null primary key,
    created_date_time timestamp,
    text              oid
);

create table word (
    id         bigint not null primary key,
    word_value varchar(255) constraint uk_plvvc683thq77nue8ouwilomg unique
);

create table word_occurrence (
    id             bigint not null primary key,
    text_positions varchar(255),
    text_id        bigint constraint fk1nla302gey11nodja1iovulkc references text,
    word_id        bigint constraint fkh8fufbunl8xytl5efekysa2el references word,
    occurrences    integer
);