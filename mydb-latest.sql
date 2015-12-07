-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.26-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for mydb
CREATE DATABASE IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;


-- Dumping structure for table mydb.courses
CREATE TABLE IF NOT EXISTS `courses` (
  `courseID` varchar(10) NOT NULL,
  `courseDesc` varchar(150) DEFAULT NULL,
  `expectedCapacity` int(11) DEFAULT NULL,
  `program` varchar(15) DEFAULT NULL,
  `prerequisiteID` varchar(10) DEFAULT NULL,
  `resourceID` varchar(10) DEFAULT NULL,
  `degreeID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`courseID`),
  KEY `COURSE_PREREQ_FK_idx` (`prerequisiteID`),
  KEY `COURSE_RESC_PK_idx` (`resourceID`),
  KEY `COURSE_DEGREE_FK` (`degreeID`),
  CONSTRAINT `COURSE_DEGREE_FK` FOREIGN KEY (`degreeID`) REFERENCES `degree` (`degreeID`),
  CONSTRAINT `COURSE_PREREQ_FK` FOREIGN KEY (`prerequisiteID`) REFERENCES `prerequisite` (`prerequisiteID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `COURSE_RESC_FK` FOREIGN KEY (`resourceID`) REFERENCES `resources` (`resourceID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mydb.courses: ~8 rows (approximately)
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` (`courseID`, `courseDesc`, `expectedCapacity`, `program`, `prerequisiteID`, `resourceID`, `degreeID`) VALUES
	('BUS1010', 'Introduction to Business Organizations', 50, 'UNDG', '0', 'PJ', 'IST'),
	('COM1500', 'Intercultural Communication', 50, 'UNDG', '0', 'PJ', 'IST'),
	('FYE1010', 'First Year Experience', 50, 'UNDG', '0', 'PJ', 'IST'),
	('HUM1000', 'Word Civilization', 50, 'UNDG', '0', 'PJ', 'IST'),
	('IST1020', 'Introduction to IS', 50, 'UNDG', 'BEGINRIT', 'CMPS', 'IST'),
	('IST2030', 'Fundamentals of Programming Languages', 30, 'UNDG', 'GENIT', 'CMPS', 'IST'),
	('ISTT2230', 'Introduction to Computer Fundamentals and Programming ', 30, 'UNDG', 'GENIT', 'CMPS', 'IST'),
	('MTH1109', 'College Algebra', 50, 'UNDG', 'BEGINRMTH', 'PJ', 'IST');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;


-- Dumping structure for table mydb.days
CREATE TABLE IF NOT EXISTS `days` (
  `dayID` varchar(10) NOT NULL,
  `dayDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dayID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mydb.days: ~4 rows (approximately)
/*!40000 ALTER TABLE `days` DISABLE KEYS */;
INSERT INTO `days` (`dayID`, `dayDesc`) VALUES
	('F', 'Friday'),
	('MW', 'Monday-Wednesday'),
	('S', 'Saturday'),
	('TR', 'Tuesday-Thursday');
/*!40000 ALTER TABLE `days` ENABLE KEYS */;


-- Dumping structure for table mydb.degree
CREATE TABLE IF NOT EXISTS `degree` (
  `degreeID` varchar(10) NOT NULL,
  `degreeDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`degreeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mydb.degree: ~4 rows (approximately)
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
INSERT INTO `degree` (`degreeID`, `degreeDesc`) VALUES
	('APT', 'Applied Computer Technologies'),
	('IST', 'Information Systems and Technology'),
	('MIS', 'Management Information Systems'),
	('MIST', 'Masters of Information Systems and Technology');
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;


-- Dumping structure for table mydb.hardwareassets
CREATE TABLE IF NOT EXISTS `hardwareassets` (
  `assetID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `labID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`assetID`),
  KEY `HW_ASSET_LAB_FK_idx` (`labID`),
  CONSTRAINT `HW_ASSET_LAB_FK` FOREIGN KEY (`labID`) REFERENCES `labs` (`labID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mydb.hardwareassets: ~0 rows (approximately)
/*!40000 ALTER TABLE `hardwareassets` DISABLE KEYS */;
/*!40000 ALTER TABLE `hardwareassets` ENABLE KEYS */;


-- Dumping structure for table mydb.labs
CREATE TABLE IF NOT EXISTS `labs` (
  `labID` varchar(10) NOT NULL,
  `labName` varchar(45) DEFAULT NULL,
  `labCapacity` int(11) DEFAULT NULL,
  `resourceID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`labID`),
  KEY `RESOURCE_LABS_FK_idx` (`resourceID`),
  CONSTRAINT `RESOURCE_LABS_FK` FOREIGN KEY (`resourceID`) REFERENCES `resources` (`resourceID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mydb.labs: ~9 rows (approximately)
/*!40000 ALTER TABLE `labs` DISABLE KEYS */;
INSERT INTO `labs` (`labID`, `labName`, `labCapacity`, `resourceID`) VALUES
	('HW1', 'Hardware Lab', 30, 'HW'),
	('LB1', 'Lab 1', 25, 'CMPS'),
	('LB2', 'Lab 2', 25, 'CMPS'),
	('LB3', 'Lab 3', 20, 'SPSS'),
	('LB4', 'Lab 4', 35, 'CMPS'),
	('LB5', 'Lab 5', 80, 'CMPS'),
	('LBG', 'Lab General', 30, 'PJ'),
	('LBG2', 'Lab General 2', 30, 'PJ'),
	('SW1', 'Software Lab', 30, 'SW');
/*!40000 ALTER TABLE `labs` ENABLE KEYS */;


-- Dumping structure for table mydb.machines
CREATE TABLE IF NOT EXISTS `machines` (
  `machineID` varchar(10) NOT NULL,
  `labID` varchar(10) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`machineID`),
  KEY `MACHINE_LAB_FK_idx` (`labID`),
  CONSTRAINT `MACHINE_LAB_FK` FOREIGN KEY (`labID`) REFERENCES `labs` (`labID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mydb.machines: ~0 rows (approximately)
/*!40000 ALTER TABLE `machines` DISABLE KEYS */;
/*!40000 ALTER TABLE `machines` ENABLE KEYS */;


-- Dumping structure for table mydb.prerequisite
CREATE TABLE IF NOT EXISTS `prerequisite` (
  `prerequisiteID` varchar(10) NOT NULL,
  `prerequisiteDesc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`prerequisiteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mydb.prerequisite: ~4 rows (approximately)
/*!40000 ALTER TABLE `prerequisite` DISABLE KEYS */;
INSERT INTO `prerequisite` (`prerequisiteID`, `prerequisiteDesc`) VALUES
	('0', 'No Prerequisite'),
	('BEGINRIT', 'IT Placement,IST0999'),
	('BEGINRMTH', 'MTH Placement,MTH1105'),
	('GENIT', 'IST1020');
/*!40000 ALTER TABLE `prerequisite` ENABLE KEYS */;


-- Dumping structure for table mydb.resources
CREATE TABLE IF NOT EXISTS `resources` (
  `resourceID` varchar(10) NOT NULL,
  `resourceDesc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`resourceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mydb.resources: ~4 rows (approximately)
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
INSERT INTO `resources` (`resourceID`, `resourceDesc`) VALUES
	('CMPS', 'Projector,Computers,Office,Dev'),
	('HW', 'Projector,Computers,Word,Dev,Networking,Electronics'),
	('PJ', 'Projector'),
	('SPSS', 'Projector,Computers,Word,Dev,SPSS'),
	('SW', 'Projector,Computers,Office,Dev');
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;


-- Dumping structure for table mydb.schedule
CREATE TABLE IF NOT EXISTS `schedule` (
  `scheduleID` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` varchar(10) DEFAULT NULL,
  `labID` varchar(10) DEFAULT NULL,
  `timeID` varchar(10) DEFAULT NULL,
  `dayID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`scheduleID`),
  KEY `SCHEDULE_COURSE_FK_idx` (`courseID`),
  KEY `SCHEDULE_LABS_FK_idx` (`labID`),
  KEY `SCHEDULE_TIMES_FK_idx` (`timeID`),
  KEY `SCHEDULE_DAYS_FK` (`dayID`),
  CONSTRAINT `SCHEDULE_COURSE_FK` FOREIGN KEY (`courseID`) REFERENCES `courses` (`courseID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SCHEDULE_DAYS_FK` FOREIGN KEY (`dayID`) REFERENCES `days` (`dayID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SCHEDULE_LABS_FK` FOREIGN KEY (`labID`) REFERENCES `labs` (`labID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SCHEDULE_TIMES_FK` FOREIGN KEY (`timeID`) REFERENCES `times` (`timeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mydb.schedule: ~0 rows (approximately)
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;


-- Dumping structure for table mydb.times
CREATE TABLE IF NOT EXISTS `times` (
  `timeID` varchar(10) NOT NULL,
  `times` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`timeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mydb.times: ~8 rows (approximately)
/*!40000 ALTER TABLE `times` DISABLE KEYS */;
INSERT INTO `times` (`timeID`, `times`) VALUES
	('AfterNoon', '3:30pm-5:00pm'),
	('EarlyMorn', '9:00am-10:30am'),
	('Evening', '5:40pm-7:10pm '),
	('LateNight', '7:20pm-9:00pm'),
	('LongEven', '5:40pm-9:00pm'),
	('LongMorn', '9:00am-12:00pm'),
	('LongNoon', '1:30pm-4:50pm'),
	('MidMorn', '11:00am-12:30pm'),
	('Noon', '1:20pm-3:00pm');
/*!40000 ALTER TABLE `times` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
