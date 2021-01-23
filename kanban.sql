/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     21.1.2021. 22:53:42                          */
/*==============================================================*/



drop table if exists comment;

drop table if exists label;

drop table if exists project;

drop table if exists role;

drop table if exists status;

drop table if exists task;

drop table if exists task_label;

drop table if exists user;

drop table if exists user_project;

drop table if exists user_role;

drop table if exists project_status;


/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   comment_id           int not null auto_increment,
   task_id              int not null,
   comment_text         text not null,
   primary key (comment_id)
);


/*==============================================================*/
/* Table: label                                               */
/*==============================================================*/
create table label
(
   label_id             int not null auto_increment,
   name                 varchar(128) not null,
   created_date         date,
   last_modified_date   timestamp,
   last_modified_by     varchar(43),
   record_status         int,
   primary key (label_id)
);

/*==============================================================*/
/* Table: project                                               */
/*==============================================================*/
create table project
(
   project_id           int not null auto_increment,
   name                 varchar(128) not null,
   description          text not null,
   start_date           date not null,
   end_date             date not null,
   created_date         date,
   last_modified_date   timestamp,
   last_modified_by     varchar(43),
   record_status         int,
   primary key (project_id)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role_id              int not null auto_increment,
   name                 varchar(128) not null,
   created_date         date,
   last_modified_date   timestamp,
   last_modified_by     varchar(43),
   record_status         int,
   primary key (role_id)
);

/*==============================================================*/
/* Table: status                                                */
/*==============================================================*/
create table status
(
   status_id            int not null auto_increment,
   name                 varchar(128) not null,
   created_date         date,
   last_modified_date   timestamp,
   last_modified_by     varchar(43),
   record_status         int,
   primary key (status_id)
);

/*==============================================================*/
/* Table: task                                                  */
/*==============================================================*/
create table task
(
   task_id              int not null auto_increment,
   project_id           int,
   status_id            int not null,
   user_id              int not null,
   name                 varchar(128) not null,
   description          text not null,
   due_date             date not null,
   primary key (task_id)
);

/*==============================================================*/
/* Table: task_label                                            */
/*==============================================================*/
create table task_label
(
   label_id             int not null,
   task_id              int not null,
   primary key (label_id, task_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null auto_increment,
   first_name           varchar(128) not null,
   last_name            varchar(128) not null,
   prof_PIC             longblob,
   email                varchar(128) not null,
   username                varchar(128) not null,
   password                 varchar(128) not null,
   created_date         date,
   last_modified_date   timestamp,
   last_modified_by     varchar(43),
   record_status         int,
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_project                                          */
/*==============================================================*/
create table user_project
(
   user_id              int not null,
   project_id           int not null,
   primary key (user_id, project_id)
);

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   user_id              int not null,
   role_id              int not null,
   primary key (user_id, role_id)
);

/*==============================================================*/
/* Table: project_status                                           */
/*==============================================================*/
create table project_status
(
   status_id            int not null,
   project_id           int not null,
   primary key (status_id, project_id)
);

alter table comment add constraint FK_RELATIONSHIP_12 foreign key (task_id)
      references task (task_id) on delete restrict on update restrict;

alter table task add constraint FK_RELATIONSHIP_5 foreign key (status_id)
      references status (status_id) on delete restrict on update restrict;

alter table task add constraint FK_RELATIONSHIP_6 foreign key (project_id)
      references project (project_id) on delete restrict on update restrict;

alter table task add constraint FK_RELATIONSHIP_7 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table task_label add constraint FK_RELATIONSHIP_10 foreign key (label_id)
      references label (label_id) on delete restrict on update restrict;

alter table task_label add constraint FK_RELATIONSHIP_11 foreign key (task_id)
      references task (task_id) on delete restrict on update restrict;

alter table user_project add constraint FK_RELATIONSHIP_8 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table user_project add constraint FK_RELATIONSHIP_9 foreign key (project_id)
      references project (project_id) on delete restrict on update restrict;

alter table user_role add constraint FK_RELATIONSHIP_1 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table user_role add constraint FK_RELATIONSHIP_2 foreign key (role_id)
      references role (role_id) on delete restrict on update restrict;

alter table project_status add constraint FK_RELATIONSHIP_3 foreign key (status_id)
      references status (status_id) on delete restrict on update restrict;

alter table project_status add constraint FK_RELATIONSHIP_4 foreign key (project_id)
      references project (project_id) on delete restrict on update restrict;

