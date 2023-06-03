create schema like;

use like;


create table `like`
(
    like_id     bigint   not null
        primary key,
    user_id     bigint   not null,
    target_id   bigint   not null,
    target_type tinyint  not null comment '1:资源2:评论',
    update_time datetime not null,
    create_time datetime not null
);

