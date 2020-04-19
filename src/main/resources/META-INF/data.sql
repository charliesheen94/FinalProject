CREATE DATABASE IF NOT EXISTS gamedb;
USE gamedb;


DROP TABLE IF EXISTS `console`;
CREATE TABLE `console` (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  console_code varchar(3) NOT NULL,
  console_name varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_oqixmig4k8qxc8oba3fl4gqkr` (`console_code`),
  UNIQUE KEY `UK_qrkn270121aljmucrdbnmd35p` (`console_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


INSERT INTO `console` (id,console_code,console_name) VALUES
 (1,'PS4','Playstation 4'),
 (2,'XB1','Xbox One'),
 (3,'nSW','Nintendo Switch'),
 (4,'PC','Computer Games');

DROP TABLE IF EXISTS game_details;
CREATE TABLE game_details (
  game_id bigint(20) NOT NULL AUTO_INCREMENT,
  console_name varchar(50) NOT NULL,
  price int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  publisher varchar(50) NOT NULL,
  PRIMARY KEY (game_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
