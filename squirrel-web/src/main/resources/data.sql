INSERT INTO sys_user (id, username, password) VALUES (1, 'wyf', 'wyf');
INSERT INTO sys_user (id, username, password) VALUES (2, 'wisely', 'wisely');

INSERT INTO sys_role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO sys_role (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO sys_user_roles (sys_user_id, roles_id) VALUES (1, 1);
INSERT INTO sys_user_roles (sys_user_id, roles_id) VALUES (2, 2);