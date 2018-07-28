-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: menu
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `dessert`
--

DROP TABLE IF EXISTS `dessert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dessert` (
  `id` int(11) NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `time_req` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dessert`
--

LOCK TABLES `dessert` WRITE;
/*!40000 ALTER TABLE `dessert` DISABLE KEYS */;
INSERT INTO `dessert` VALUES (1,'Sticky Date',12,7),(2,'Panacotta',12,5);
/*!40000 ALTER TABLE `dessert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entree`
--

DROP TABLE IF EXISTS `entree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entree` (
  `id` varchar(30) NOT NULL,
  `ITEM_NAME` varchar(30) NOT NULL,
  `PRICE` varchar(30) NOT NULL,
  `time_req` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entree`
--

LOCK TABLES `entree` WRITE;
/*!40000 ALTER TABLE `entree` DISABLE KEYS */;
INSERT INTO `entree` VALUES ('1','Beef Carpaccio','9','5');
/*!40000 ALTER TABLE `entree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main`
--

DROP TABLE IF EXISTS `main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `main` (
  `id` int(11) NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `time_req` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main`
--

LOCK TABLES `main` WRITE;
/*!40000 ALTER TABLE `main` DISABLE KEYS */;
INSERT INTO `main` VALUES (1,'Steak of the Day',18,'15');
/*!40000 ALTER TABLE `main` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-28 12:37:22
