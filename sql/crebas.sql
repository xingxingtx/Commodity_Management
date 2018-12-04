/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/30 16:12:17                          */
/*==============================================================*/


drop table if exists activity;

drop table if exists activity_info;

drop table if exists activity_user_info;

drop table if exists area_info;

drop table if exists comment_info;

drop table if exists commodity_info;

drop table if exists commodity_merchant_info;

drop table if exists commodity_sale_info;

drop table if exists img_video;

drop table if exists merchant;

drop table if exists role;

drop table if exists rore_auth;

drop table if exists sys_auth;

drop table if exists sys_dictionary;

drop table if exists user;

drop table if exists user_role;

/*==============================================================*/
/* Table: activity                                              */
/*==============================================================*/
create table activity
(
   id                   bigint not null comment '主键id',
   activity_name        char(100) comment '活动名称',
   start_time           timestamp comment '活动开始时间',
   end_time             timestamp comment '活动结束时间',
   merchant_id          int comment '商家id',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table activity comment '优惠活动表';

/*==============================================================*/
/* Table: activity_info                                         */
/*==============================================================*/
create table activity_info
(
   id                   bigint not null comment '主键id',
   activity_id          bigint comment '活动id',
   activity_type        char(50) comment '活动类型名称',
   activity_condition   char(20) comment '活动条件',
   activity_value       char(20) comment '活动优惠值',
   activity_count       bigint comment '活动优惠发行数量',
   number_get           bigint comment '活动领取数量',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table activity_info comment '活动详情表';

/*==============================================================*/
/* Table: activity_user_info                                    */
/*==============================================================*/
create table activity_user_info
(
   id                   bigint not null comment '主键id',
   activity_id          bigint comment '活动详情id',
   user_id              bigint comment '用户id',
   is_complete          int comment '是否参加完成活动 0-未完成；1-已经完成',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table activity_user_info comment '活动与用户关联表';

/*==============================================================*/
/* Table: area_info                                             */
/*==============================================================*/
create table area_info
(
   id                   bigint comment '主键id',
   area_name            char(50) comment '地区名称',
   area_code            char(50) comment '地区代码',
   parent_code          char(50) comment '父级代码',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人'
);

alter table area_info comment '地区表';

/*==============================================================*/
/* Table: comment_info                                          */
/*==============================================================*/
create table comment_info
(
   id                   bigint not null,
   comment_content      varchar(1000),
   comment_score        float,
   merchant_id          bigint,
   commodity_id         bigint,
   user_id              bigint,
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table comment_info comment '评论表';

/*==============================================================*/
/* Table: commodity_info                                        */
/*==============================================================*/
create table commodity_info
(
   id                   bigint not null comment '主键id',
   commodity_name       char(100) comment '商品名称',
   commodity_type       char(50) comment '商品分类类型',
   state                int comment '状态0-删除；1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table commodity_info comment '商品表';

/*==============================================================*/
/* Table: commodity_merchant_info                               */
/*==============================================================*/
create table commodity_merchant_info
(
   id                   bigint not null,
   commodity_id         bigint,
   commodity_price      float comment '商品价格',
   is_limit_count       int comment '是否限制出售数量:0-限制；1不限制',
   commodity_count      int comment '商品数量',
   merchant_id          bigint,
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table commodity_merchant_info comment '商家商品详情表';

/*==============================================================*/
/* Table: commodity_sale_info                                   */
/*==============================================================*/
create table commodity_sale_info
(
   id                   bigint not null comment '主键id',
   commodity_merchant_id bigint comment '商家商品详情表ID',
   sale_count           bigint comment '出售数量',
   sale_way             int comment '出售方式',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table commodity_sale_info comment '商家商品出售详情表';

/*==============================================================*/
/* Table: img_video                                             */
/*==============================================================*/
create table img_video
(
   id                   bigint not null comment '主键id',
   relation_id          bigint comment '关联ID',
   url                  char(200) comment '视频图片url',
   type                 int comment '所属类型',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table img_video comment '视频图片详情表';

/*==============================================================*/
/* Table: merchant                                              */
/*==============================================================*/
create table merchant
(
   id                   bigint not null,
   merchant_name        char(100),
   merchant_phone       char(20),
   latitude             char(20),
   longitude            char(20),
   merchant_details     text comment '商家详情描述',
   user_id              bigint comment '用户id',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table merchant comment '商家表';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   bigint not null,
   role_name            char(20) comment '角色名称',
   description          char(100) comment '角色简介',
   state                int comment '状态0-删除；1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table role comment '角色表';

/*==============================================================*/
/* Table: rore_auth                                             */
/*==============================================================*/
create table rore_auth
(
   id                   bigint not null comment '主键id',
   role_id              bigint comment '角色id',
   auth_id              bigint comment '权限id',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table rore_auth comment '角色与权限表';

/*==============================================================*/
/* Table: sys_auth                                              */
/*==============================================================*/
create table sys_auth
(
   id                   bigint not null comment '主键id',
   auth_code            char(30) comment '权限编码',
   auth_name            char(10) comment '权限名称',
   parent_code          char(10) comment '父权限编码',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table sys_auth comment '权限表';

/*==============================================================*/
/* Table: sys_dictionary                                        */
/*==============================================================*/
create table sys_dictionary
(
   id                   bigint not null comment '主键id',
   dic_key              char(20) comment '字典类型',
   dic_value            char(30) comment '字典值',
   ext1                 char(20) comment '扩展字段1',
   ext2                 char(20) comment '扩展字段2',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table sys_dictionary comment '字典表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   bigint not null comment '用户id',
   login_name           char(20) comment '登录名',
   password             char(50) comment '登录密码',
   sex                  int comment '性别 0-男；1-女',
   id_number            char(50) comment '身份证号',
   age                  int comment '年龄',
   phone                char(20) comment '电话',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table user comment '用户表';

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   id                   bigint not null,
   user_id              bigint comment '用户id',
   role_id              bigint comment '角色id',
   state                int comment '状态 0-删除 1未删除',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   create_user          bigint comment '创建人',
   update_user          bigint comment '修改人',
   primary key (id)
);

alter table user_role comment '用户角色表';

alter table activity add constraint FK_Reference_11 foreign key (merchant_id)
      references merchant (id) on delete restrict on update restrict;

alter table activity_info add constraint FK_Reference_12 foreign key (activity_id)
      references activity (id) on delete restrict on update restrict;

alter table activity_user_info add constraint FK_Reference_13 foreign key (activity_id)
      references activity_info (id) on delete restrict on update restrict;

alter table comment_info add constraint FK_Reference_5 foreign key (merchant_id)
      references merchant (id) on delete restrict on update restrict;

alter table comment_info add constraint FK_Reference_6 foreign key (commodity_id)
      references commodity_info (id) on delete restrict on update restrict;

alter table commodity_merchant_info add constraint FK_Reference_8 foreign key (merchant_id)
      references merchant (id) on delete restrict on update restrict;

alter table commodity_merchant_info add constraint FK_Reference_9 foreign key (commodity_id)
      references commodity_info (id) on delete restrict on update restrict;

alter table commodity_sale_info add constraint FK_Reference_7 foreign key (commodity_merchant_id)
      references commodity_merchant_info (id) on delete restrict on update restrict;

alter table merchant add constraint FK_Reference_10 foreign key (user_id)
      references user (id) on delete restrict on update restrict;

alter table rore_auth add constraint FK_Reference_3 foreign key (role_id)
      references role (id) on delete restrict on update restrict;

alter table rore_auth add constraint FK_Reference_4 foreign key (auth_id)
      references sys_auth (id) on delete restrict on update restrict;

alter table user_role add constraint FK_Reference_1 foreign key (user_id)
      references user (id) on delete restrict on update restrict;

alter table user_role add constraint FK_Reference_2 foreign key (role_id)
      references role (id) on delete restrict on update restrict;

