# use dw;


alter table dim_operations add constraint fk_dim_operations_dim_action_targets foreign key (action_target_id) references dim_action_targets (id);
alter table dim_operations add constraint fk_dim_operations_dim_actions foreign key (action_id) references dim_actions (id);

alter table dim_reference_data_structure add constraint fk_dim_reference_data_structure_dim_users foreign key (UID)
    references dim_users (UID);



alter table dim_reference_data_structure add constraint fk_dim_reference_data_structure_dim_dates foreign key (date_id)
    references dim_dates (id);



insert into dim_action_targets (id, name) values
      (1, 'email'),
      (2, 'post'),
      (3, 'discussion');
#     (4, 'notification'),
#     (5, 'page'),
#     (6, 'link'),
#     ( 7, 'log-in');


insert into dim_actions (name, id) values
       ('draft', 1),
       ('approve', 2),
       ('send', 3),
       ('receive', 4),
       ('open', 5),

       ('draft', 6),
       ('post', 7),
       ('update',  8),
       ('delete', 9),

       ('start',  10),
       ('resume', 11),
       ('pause', 12),
       ('stop', 13);


insert into dim_operations (action_target_id, action_id)
values(1, 1),
      (1, 2),
      (1, 3),
      (1, 4),
      (1, 5),

      (2, 6),
      (2, 7),
      (2, 8),
      (2, 9),

      (3, 10),
      (3, 11),
      (3, 12),
      (3, 13);

update dim_operations  o
    inner join dim_action_targets target
    on o.action_target_id = target.id
    inner join dim_actions a on o.action_id = a.id
set o.name = concat_ws("_",   target.name, a.name)
where o.id >0 ;


insert into dim_processing_status (id, name, description)
values(11, 'db data processing started', 'db data processing started'),
      (12, 'db data processing in session', 'db data processing in session'),
      (13, 'db data processing end', 'db data processing end'),

      (21, 'event data processing started', 'event data processing started'),
      (22, 'event data processing in session', 'event data processing in session'),
      (23, 'event data processing ended', 'event data processing ended');

