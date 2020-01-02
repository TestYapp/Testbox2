drop table if exists t_order;

drop table if exists t_user;

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order
(
   id                   int not null auto_increment comment '主键',
   create_time          datetime comment '创建时间',
   total_price          double comment '总价格',
   user_id              int comment '用户id',
   primary key (id)
);

alter table t_order comment '订单表';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null auto_increment comment '主键',
   name                 varchar(32) comment '姓名',
   account              varchar(32) comment '账号',
   password             varchar(32) comment '密码',
   birthday             date comment '生日',
   gender               boolean comment '性别',
   status               int comment '状态，0-管理员，1-普通用户',
   primary key (id)
);

alter table t_user comment '用户表';

alter table t_order add constraint fk_userid_id foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;
