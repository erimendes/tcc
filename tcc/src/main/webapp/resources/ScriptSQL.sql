CREATE DATABASE userbase
use userbase;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
CREATE  TABLE users (
  userid int(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  login VARCHAR(255) NOT NULL,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (userid));
   
CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  userid int(11) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_userid_role (role,userid),
  KEY fk_user_idx (userid),
  CONSTRAINT fk_userid FOREIGN KEY (userid) REFERENCES users (userid));
 
INSERT INTO users(username,email,password,enabled)
VALUES ('erimendes','erimendes', 'juloru', true);
INSERT INTO users(username,email,password,enabled)
VALUES ('eri.mendes','eri.mendes','juloru', true);
 
INSERT INTO user_roles (userid, role)
VALUES (001, 'ROLE_USER');
INSERT INTO user_roles (userid, role)
VALUES (002, 'ROLE_ADMIN');
INSERT INTO user_roles (userid, role)
VALUES (002, 'ROLE_USER');
