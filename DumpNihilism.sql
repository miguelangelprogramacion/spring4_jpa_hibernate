CREATE DATABASE  IF NOT EXISTS `nihilism` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `nihilism`;
-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: nihilism
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `concept`
--

DROP TABLE IF EXISTS `concept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concept` (
  `concept_Id` int(11) NOT NULL AUTO_INCREMENT,
  `abstract` varchar(45) DEFAULT NULL,
  `resume` varchar(45) DEFAULT NULL,
  `good` binary(1) DEFAULT NULL,
  PRIMARY KEY (`concept_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concept`
--

LOCK TABLES `concept` WRITE;
/*!40000 ALTER TABLE `concept` DISABLE KEYS */;
INSERT INTO `concept` VALUES (23,'rage','Violent, explosive anger.',NULL),(24,'fear','A very unpleasant or disturbing feeling cause',NULL),(25,'sadness','Showing, expressing, or feeling sorrow or unh',NULL),(26,'violence','Behavior or treatment in which physical force',NULL);
/*!40000 ALTER TABLE `concept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nihilist`
--

DROP TABLE IF EXISTS `nihilist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nihilist` (
  `nihilist_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `rage` int(11) DEFAULT NULL,
  PRIMARY KEY (`nihilist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nihilist`
--

LOCK TABLES `nihilist` WRITE;
/*!40000 ALTER TABLE `nihilist` DISABLE KEYS */;
INSERT INTO `nihilist` VALUES (1,'rust',75),(2,'cohle',NULL);
/*!40000 ALTER TABLE `nihilist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nihilist_concept`
--

DROP TABLE IF EXISTS `nihilist_concept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nihilist_concept` (
  `nihilist_id` int(11) NOT NULL,
  `concept_id` int(11) NOT NULL,
  PRIMARY KEY (`nihilist_id`,`concept_id`),
  KEY `fk_nihilist_concept_concept_id_idx` (`concept_id`),
  CONSTRAINT `fk_nihilist_concept_concept_id` FOREIGN KEY (`concept_id`) REFERENCES `concept` (`concept_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_nihilist_concept_nihilist_id` FOREIGN KEY (`nihilist_id`) REFERENCES `nihilist` (`nihilist_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nihilist_concept`
--

LOCK TABLES `nihilist_concept` WRITE;
/*!40000 ALTER TABLE `nihilist_concept` DISABLE KEYS */;
INSERT INTO `nihilist_concept` VALUES (2,23),(1,24),(1,25);
/*!40000 ALTER TABLE `nihilist_concept` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-25 11:00:03