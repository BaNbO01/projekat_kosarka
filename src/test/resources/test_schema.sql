



DROP TABLE IF EXISTS `drzava`;

CREATE TABLE `drzava` (
  `drzavaID` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`drzavaID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS `grad`;

CREATE TABLE `grad` (
  `gradID` bigint(20) NOT NULL AUTO_INCREMENT,
  `drzavaID` bigint(20) NOT NULL,
  `naziv` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`gradID`,`drzavaID`),
  KEY `drzavaID` (`drzavaID`),
  CONSTRAINT `grad_ibfk_1` FOREIGN KEY (`drzavaID`) REFERENCES `drzava` (`drzavaID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/

DROP TABLE IF EXISTS `igraci`;

CREATE TABLE `igraci` (
  `igracId` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(200) DEFAULT NULL,
  `prezime` varchar(200) DEFAULT NULL,
  `broj` int(11) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `visina` double DEFAULT NULL,
  `pozicija` varchar(5) DEFAULT NULL,
  `drzavaId` bigint(20) DEFAULT NULL,
  `timId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`igracId`),
  KEY `drzavaId` (`drzavaId`),
  KEY `timId` (`timId`),
  CONSTRAINT `igraci_ibfk_1` FOREIGN KEY (`drzavaId`) REFERENCES `drzava` (`drzavaID`),
  CONSTRAINT `igraci_ibfk_2` FOREIGN KEY (`timId`) REFERENCES `tim` (`timID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS `kolo`;

CREATE TABLE `kolo` (
  `koloId` bigint(20) NOT NULL,
  `ligaId` bigint(20) NOT NULL,
  PRIMARY KEY (`koloId`,`ligaId`),
  KEY `ligaId` (`ligaId`),
  CONSTRAINT `kolo_ibfk_1` FOREIGN KEY (`ligaId`) REFERENCES `liga` (`ligaId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `liga`;

CREATE TABLE `liga` (
  `ligaId` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(200) DEFAULT NULL,
  `drzavaID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ligaId`),
  KEY `drzavaID` (`drzavaID`),
  CONSTRAINT `liga_ibfk_1` FOREIGN KEY (`drzavaID`) REFERENCES `drzava` (`drzavaID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `tim`;

CREATE TABLE `tim` (
  `timID` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(200) DEFAULT NULL,
  `gradId` bigint(20) DEFAULT NULL,
  `drzavaID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`timID`),
  KEY `gradId` (`gradId`,`drzavaID`),
  CONSTRAINT `tim_ibfk_1` FOREIGN KEY (`gradId`, `drzavaID`) REFERENCES `grad` (`gradID`, `drzavaID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `utakmica`;

CREATE TABLE `utakmica` (
  `utakmicaId` bigint(20) NOT NULL AUTO_INCREMENT,
  `koloId` bigint(20) NOT NULL,
  `ligaId` bigint(20) NOT NULL,
  `brojKosevaTima1` int(11) DEFAULT NULL,
  `brojKosevaTima2` int(11) DEFAULT NULL,
  `timid1` bigint(20) DEFAULT NULL,
  `timid2` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`utakmicaId`,`koloId`,`ligaId`),
  KEY `koloId` (`koloId`,`ligaId`),
  KEY `timid1` (`timid1`),
  KEY `timid2` (`timid2`),
  CONSTRAINT `utakmica_ibfk_1` FOREIGN KEY (`koloId`, `ligaId`) REFERENCES `kolo` (`koloId`, `ligaId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `utakmica_ibfk_2` FOREIGN KEY (`timid1`) REFERENCES `tim` (`timID`),
  CONSTRAINT `utakmica_ibfk_3` FOREIGN KEY (`timid2`) REFERENCES `tim` (`timID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


