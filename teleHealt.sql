-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.24-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for telehealth
CREATE DATABASE IF NOT EXISTS `telehealth` /*!40100 DEFAULT CHARACTER SET utf16 COLLATE utf16_bin */;
USE `telehealth`;


-- Dumping structure for table telehealth.doctor
CREATE TABLE IF NOT EXISTS `doctor` (
  `userId` int(11) DEFAULT NULL,
  `availability` int(11) DEFAULT NULL,
  `location` varchar(50) COLLATE utf16_bin DEFAULT NULL,
  KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

-- Dumping data for table telehealth.doctor: ~0 rows (approximately)
DELETE FROM `doctor`;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;


-- Dumping structure for table telehealth.patient
CREATE TABLE IF NOT EXISTS `patient` (
  `userId` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `location` varchar(50) COLLATE utf16_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

-- Dumping data for table telehealth.patient: ~1 rows (approximately)
DELETE FROM `patient`;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`userId`, `weight`, `location`, `age`) VALUES
	(2, 50, 'Dhaka', 123),
	(3, 1, 'daf', 1);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;


-- Dumping structure for table telehealth.user
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) COLLATE utf16_bin DEFAULT NULL,
  `lastName` varchar(50) COLLATE utf16_bin DEFAULT NULL,
  `userName` varchar(50) COLLATE utf16_bin DEFAULT NULL,
  `userPassword` varchar(50) COLLATE utf16_bin DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

-- Dumping data for table telehealth.user: ~1 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userId`, `firstName`, `lastName`, `userName`, `userPassword`, `userType`) VALUES
	(2, 'M.A saif', 'saif', 'saif', 'saif', 1),
	(3, 'a', 'a', 'a', 'a', 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
