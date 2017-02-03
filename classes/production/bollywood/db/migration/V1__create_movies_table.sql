CREATE TABLE `movies` (
  `id`        INT           NOT NULL  AUTO_INCREMENT,
  `version`   INT           NOT NULL  DEFAULT 0,
  `title`     VARCHAR(255)  NOT NULL,
  `watched`   TINYINT                 DEFAULT 0,
  `rating`    VARCHAR(5),
  `released`  DATE,
  `length`    INT,
  `created`   TIMESTAMP                  DEFAULT NOW(),
  `modified`   TIMESTAMP                DEFAULT NOW(),
  PRIMARY KEY (`id`));