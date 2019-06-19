CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `date_created` varchar(10),
  `finished` bit(1) DEFAULT b'0',
  `userid` int(11),
  `emprestado` varchar(5),
  `edicao` varchar(20),
  `editora` varchar(30),
  `isbn` varchar(20),
  `assunto` varchar(30),
  `idioma` varchar(20),
  `anopublicacao` varchar(4),
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11),
  `email` varchar(255),
  `name` varchar(255),
  `password` varchar(255) DEFAULT NULL,
  `role_id` int(11),
  `userid` int(11),
  `telefone` varchar(20),
  PRIMARY KEY (`id`),
  KEY `id_role_id` (`role_id`),
  CONSTRAINT `id_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


CREATE TABLE `user_task` (
	`id` int(11) not NULL AUTO_INCREMENT,
  `user_id` int(11)  NOT NULL,
  `task_id` int(11)  NOT NULL,
  `userid` int(11),
  `date_created` varchar(10),
  PRIMARY KEY (`id`),
  KEY `id_usertask_user_id` (`user_id`),
  KEY `id_usertask_task_id` (`task_id`),
  CONSTRAINT `id_usertask_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_usertask_task_id` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `role` VALUES (1,'ADMIN');
INSERT INTO `role` VALUES (2,'USER');