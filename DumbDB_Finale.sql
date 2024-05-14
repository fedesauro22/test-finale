CREATE DATABASE  IF NOT EXISTS `weather_report` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `weather_report`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: weather_report
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `latitude` decimal(8,6) DEFAULT NULL,
  `longitude` decimal(8,6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Palermo',38.115700,13.361900),(2,'Catania',37.502100,15.087100),(3,'Messina',38.193800,15.554200),(4,'Siracusa',37.075500,15.286600),(5,'Trapani',38.018500,12.513700),(6,'Ragusa',36.929200,14.723800),(7,'Caltanissetta',37.492500,14.064400),(8,'Agrigento',37.311300,13.576000),(9,'Enna',37.567000,14.279100),(10,'New York',40.712800,-74.006000);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forecast`
--

DROP TABLE IF EXISTS `forecast`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forecast` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_city` int NOT NULL,
  `id_user` int NOT NULL,
  `date_forecast` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_city` (`id_city`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `forecast_ibfk_1` FOREIGN KEY (`id_city`) REFERENCES `city` (`id`),
  CONSTRAINT `forecast_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forecast`
--

LOCK TABLES `forecast` WRITE;
/*!40000 ALTER TABLE `forecast` DISABLE KEYS */;
INSERT INTO `forecast` VALUES (2,2,4,'2024-05-14'),(4,1,4,'2024-05-14'),(5,1,4,'2024-05-14'),(6,1,4,'2024-05-14'),(7,1,4,'2024-05-14'),(8,9,4,'2024-05-14'),(9,2,4,'2024-05-14'),(10,5,4,'2024-05-14'),(11,10,4,'2024-05-14');
/*!40000 ALTER TABLE `forecast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precipitation`
--

DROP TABLE IF EXISTS `precipitation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `precipitation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_forecast` int DEFAULT NULL,
  `value` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_forecast` (`id_forecast`),
  CONSTRAINT `precipitation_ibfk_1` FOREIGN KEY (`id_forecast`) REFERENCES `forecast` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precipitation`
--

LOCK TABLES `precipitation` WRITE;
/*!40000 ALTER TABLE `precipitation` DISABLE KEYS */;
INSERT INTO `precipitation` VALUES (25,2,4.00),(26,2,9.00),(27,2,13.00),(28,2,27.00),(29,2,41.00),(30,2,55.00),(31,2,55.00),(32,2,55.00),(33,2,55.00),(34,2,37.00),(35,2,18.00),(36,2,0.00),(37,2,1.00),(38,2,2.00),(39,2,3.00),(40,2,30.00),(41,2,57.00),(42,2,84.00),(43,2,80.00),(44,2,75.00),(45,2,71.00),(46,2,49.00),(47,2,28.00),(48,2,6.00),(49,4,5.00),(50,4,4.00),(51,4,3.00),(52,4,3.00),(53,4,3.00),(54,4,3.00),(55,4,7.00),(56,4,12.00),(57,4,16.00),(58,4,17.00),(59,4,18.00),(60,4,19.00),(61,4,13.00),(62,4,6.00),(63,4,0.00),(64,4,0.00),(65,4,0.00),(66,4,0.00),(67,4,0.00),(68,4,0.00),(69,4,0.00),(70,4,0.00),(71,4,0.00),(72,4,0.00),(73,5,5.00),(74,5,4.00),(75,5,3.00),(76,5,3.00),(77,5,3.00),(78,5,3.00),(79,5,7.00),(80,5,12.00),(81,5,16.00),(82,5,17.00),(83,5,18.00),(84,5,19.00),(85,5,13.00),(86,5,6.00),(87,5,0.00),(88,5,0.00),(89,5,0.00),(90,5,0.00),(91,5,0.00),(92,5,0.00),(93,5,0.00),(94,5,0.00),(95,5,0.00),(96,5,0.00),(97,6,5.00),(98,6,4.00),(99,6,3.00),(100,6,3.00),(101,6,3.00),(102,6,3.00),(103,6,7.00),(104,6,12.00),(105,6,16.00),(106,6,17.00),(107,6,18.00),(108,6,19.00),(109,6,13.00),(110,6,6.00),(111,6,0.00),(112,6,0.00),(113,6,0.00),(114,6,0.00),(115,6,0.00),(116,6,0.00),(117,6,0.00),(118,6,0.00),(119,6,0.00),(120,6,0.00),(121,7,5.00),(122,7,4.00),(123,7,3.00),(124,7,3.00),(125,7,3.00),(126,7,3.00),(127,7,7.00),(128,7,12.00),(129,7,16.00),(130,7,17.00),(131,7,18.00),(132,7,19.00),(133,7,13.00),(134,7,6.00),(135,7,0.00),(136,7,0.00),(137,7,0.00),(138,7,0.00),(139,7,0.00),(140,7,0.00),(141,7,0.00),(142,7,0.00),(143,7,0.00),(144,7,0.00),(145,8,12.00),(146,8,14.00),(147,8,16.00),(148,8,33.00),(149,8,51.00),(150,8,68.00),(151,8,47.00),(152,8,27.00),(153,8,6.00),(154,8,9.00),(155,8,13.00),(156,8,16.00),(157,8,11.00),(158,8,5.00),(159,8,0.00),(160,8,4.00),(161,8,9.00),(162,8,13.00),(163,8,12.00),(164,8,11.00),(165,8,10.00),(166,8,7.00),(167,8,3.00),(168,8,0.00),(169,9,8.00),(170,9,15.00),(171,9,23.00),(172,9,34.00),(173,9,44.00),(174,9,55.00),(175,9,42.00),(176,9,29.00),(177,9,16.00),(178,9,11.00),(179,9,5.00),(180,9,0.00),(181,9,5.00),(182,9,11.00),(183,9,16.00),(184,9,42.00),(185,9,68.00),(186,9,94.00),(187,9,83.00),(188,9,72.00),(189,9,61.00),(190,9,41.00),(191,9,20.00),(192,9,0.00),(193,10,10.00),(194,10,6.00),(195,10,3.00),(196,10,4.00),(197,10,5.00),(198,10,6.00),(199,10,12.00),(200,10,17.00),(201,10,23.00),(202,10,21.00),(203,10,18.00),(204,10,16.00),(205,10,11.00),(206,10,5.00),(207,10,0.00),(208,10,0.00),(209,10,0.00),(210,10,0.00),(211,10,0.00),(212,10,0.00),(213,10,0.00),(214,10,0.00),(215,10,0.00),(216,10,0.00),(217,11,0.00),(218,11,0.00),(219,11,0.00),(220,11,0.00),(221,11,0.00),(222,11,0.00),(223,11,0.00),(224,11,0.00),(225,11,0.00),(226,11,0.00),(227,11,0.00),(228,11,0.00),(229,11,0.00),(230,11,0.00),(231,11,0.00),(232,11,5.00),(233,11,11.00),(234,11,16.00),(235,11,21.00),(236,11,27.00),(237,11,32.00),(238,11,30.00),(239,11,28.00),(240,11,26.00);
/*!40000 ALTER TABLE `precipitation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temperature`
--

DROP TABLE IF EXISTS `temperature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temperature` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_forecast` int DEFAULT NULL,
  `value` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_forecast` (`id_forecast`),
  CONSTRAINT `temperature_ibfk_1` FOREIGN KEY (`id_forecast`) REFERENCES `forecast` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temperature`
--

LOCK TABLES `temperature` WRITE;
/*!40000 ALTER TABLE `temperature` DISABLE KEYS */;
INSERT INTO `temperature` VALUES (25,2,17.50),(26,2,17.50),(27,2,17.50),(28,2,17.40),(29,2,17.40),(30,2,17.30),(31,2,17.30),(32,2,17.40),(33,2,17.60),(34,2,18.00),(35,2,18.70),(36,2,19.20),(37,2,19.70),(38,2,19.80),(39,2,19.60),(40,2,19.60),(41,2,19.20),(42,2,19.00),(43,2,19.10),(44,2,18.70),(45,2,18.30),(46,2,18.10),(47,2,18.00),(48,2,18.10),(49,4,17.30),(50,4,17.00),(51,4,16.30),(52,4,16.50),(53,4,16.70),(54,4,16.70),(55,4,16.60),(56,4,16.80),(57,4,17.40),(58,4,18.00),(59,4,18.80),(60,4,19.60),(61,4,19.70),(62,4,20.90),(63,4,21.30),(64,4,21.50),(65,4,21.40),(66,4,21.50),(67,4,21.50),(68,4,21.10),(69,4,20.80),(70,4,20.00),(71,4,19.10),(72,4,18.50),(73,5,17.30),(74,5,17.00),(75,5,16.30),(76,5,16.50),(77,5,16.70),(78,5,16.70),(79,5,16.60),(80,5,16.80),(81,5,17.40),(82,5,18.00),(83,5,18.80),(84,5,19.60),(85,5,19.70),(86,5,20.90),(87,5,21.30),(88,5,21.50),(89,5,21.40),(90,5,21.50),(91,5,21.50),(92,5,21.10),(93,5,20.80),(94,5,20.00),(95,5,19.10),(96,5,18.50),(97,6,17.30),(98,6,17.00),(99,6,16.30),(100,6,16.50),(101,6,16.70),(102,6,16.70),(103,6,16.60),(104,6,16.80),(105,6,17.40),(106,6,18.00),(107,6,18.80),(108,6,19.60),(109,6,19.70),(110,6,20.90),(111,6,21.30),(112,6,21.50),(113,6,21.40),(114,6,21.50),(115,6,21.50),(116,6,21.10),(117,6,20.80),(118,6,20.00),(119,6,19.10),(120,6,18.50),(121,7,17.30),(122,7,17.00),(123,7,16.30),(124,7,16.50),(125,7,16.70),(126,7,16.70),(127,7,16.60),(128,7,16.80),(129,7,17.40),(130,7,18.00),(131,7,18.80),(132,7,19.60),(133,7,19.70),(134,7,20.90),(135,7,21.30),(136,7,21.50),(137,7,21.40),(138,7,21.50),(139,7,21.50),(140,7,21.10),(141,7,20.80),(142,7,20.00),(143,7,19.10),(144,7,18.50),(145,8,13.90),(146,8,13.60),(147,8,13.50),(148,8,13.50),(149,8,13.60),(150,8,13.40),(151,8,13.10),(152,8,13.00),(153,8,13.90),(154,8,15.00),(155,8,15.70),(156,8,16.50),(157,8,17.20),(158,8,18.00),(159,8,19.60),(160,8,19.20),(161,8,19.20),(162,8,20.00),(163,8,19.30),(164,8,18.10),(165,8,16.50),(166,8,14.90),(167,8,14.20),(168,8,13.70),(169,9,17.60),(170,9,17.40),(171,9,17.50),(172,9,17.70),(173,9,17.50),(174,9,17.20),(175,9,17.60),(176,9,17.70),(177,9,18.20),(178,9,18.80),(179,9,19.50),(180,9,19.70),(181,9,20.00),(182,9,20.00),(183,9,20.10),(184,9,20.50),(185,9,20.80),(186,9,20.50),(187,9,20.10),(188,9,19.40),(189,9,18.60),(190,9,18.10),(191,9,18.00),(192,9,17.60),(193,10,18.70),(194,10,19.00),(195,10,18.80),(196,10,19.20),(197,10,18.40),(198,10,18.10),(199,10,18.30),(200,10,18.60),(201,10,19.30),(202,10,20.20),(203,10,21.20),(204,10,22.90),(205,10,25.00),(206,10,25.20),(207,10,22.40),(208,10,23.70),(209,10,25.10),(210,10,24.10),(211,10,23.20),(212,10,22.60),(213,10,21.50),(214,10,20.40),(215,10,20.90),(216,10,20.50),(217,11,13.60),(218,11,12.80),(219,11,12.50),(220,11,11.90),(221,11,11.50),(222,11,11.30),(223,11,11.30),(224,11,12.80),(225,11,14.80),(226,11,16.40),(227,11,18.40),(228,11,19.80),(229,11,21.70),(230,11,22.50),(231,11,22.80),(232,11,22.50),(233,11,20.60),(234,11,22.00),(235,11,21.20),(236,11,20.30),(237,11,18.80),(238,11,17.80),(239,11,17.20),(240,11,16.90);
/*!40000 ALTER TABLE `temperature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'Federico','Mollica','prova@mail.com','b83cb68a006bf684628aaae5775e3794fe4d9ee57bb3d5c9173772b5cd4a4a94'),(5,'John','Doe','john@example.com','password123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-14 18:10:31
