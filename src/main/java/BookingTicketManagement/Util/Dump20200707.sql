CREATE DATABASE  IF NOT EXISTS `BOOKINGTICKETMANAGEMENT` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `BOOKINGTICKETMANAGEMENT`;
-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: BOOKINGTICKETMANAGEMENT
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int NOT NULL,
  `seat` int NOT NULL,
  `departure` datetime DEFAULT NULL,
  `route` int NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(16) DEFAULT NULL,
  `isactive` int DEFAULT '1',
  `ispaid` int DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  KEY `seat` (`seat`),
  KEY `route` (`route`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`seat`) REFERENCES `seat` (`id`),
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`route`) REFERENCES `route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,3,1,'2019-08-10 05:00:00',1,'2019-08-10 10:10:10',NULL,NULL,1,0);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `type` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`),
  CONSTRAINT `bus_ibfk_1` FOREIGN KEY (`type`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` VALUES (1,'Xe 1',1),(2,'Xe 2',1),(3,'Xe 3',1),(4,'Xe 4',1),(5,'Xe 5',1),(6,'Xe 6',1),(7,'Xe 7',2),(8,'Xe 8',2),(9,'Xe 9',2),(10,'Xe 10',2),(11,'Xe 11',2),(12,'Xe 12',2);
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus_route`
--

DROP TABLE IF EXISTS `bus_route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bus_route` (
  `id` int NOT NULL AUTO_INCREMENT,
  `busId` int NOT NULL,
  `routeId` int NOT NULL,
  `price` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `busId` (`busId`),
  KEY `routeId` (`routeId`),
  CONSTRAINT `bus_route_ibfk_1` FOREIGN KEY (`busId`) REFERENCES `bus` (`id`),
  CONSTRAINT `bus_route_ibfk_2` FOREIGN KEY (`routeId`) REFERENCES `route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus_route`
--

LOCK TABLES `bus_route` WRITE;
/*!40000 ALTER TABLE `bus_route` DISABLE KEYS */;
INSERT INTO `bus_route` VALUES (1,1,1,100000),(2,2,1,100000),(3,3,1,100000),(4,7,1,150000),(5,8,1,150000),(6,9,1,150000),(7,1,2,100000),(8,2,2,100000),(9,3,2,100000),(10,7,2,150000),(11,8,2,150000),(12,9,2,150000),(13,4,3,200000),(14,5,3,200000),(15,6,3,200000),(16,10,3,250000),(17,11,3,250000),(18,12,3,250000),(19,4,4,200000),(20,5,4,200000),(21,6,4,200000),(22,10,4,250000),(23,11,4,250000),(24,12,4,250000);
/*!40000 ALTER TABLE `bus_route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'SELLER'),(3,'CUSTOMER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `id` int NOT NULL AUTO_INCREMENT,
  `from` varchar(128) DEFAULT NULL,
  `to` varchar(128) DEFAULT NULL,
  `timeGo` time DEFAULT NULL,
  `duration` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'Tp Hồ Chí Minh','Đà Lạt','05:00:00','08:00:00'),(2,'Đà Lạt','Tp Hồ Chí Minh','14:00:00','08:00:00'),(3,'Tp Hồ Chí Minh','Cần Thơ','05:00:00','05:00:00'),(4,'Cần Thơ','Tp Hồ Chí Minh','14:00:00','05:00:00');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `bus` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bus` (`bus`),
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`bus`) REFERENCES `bus` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=421 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,'A1',1),(2,'A2',1),(3,'A3',1),(4,'A4',1),(5,'A5',1),(6,'A6',1),(7,'A7',1),(8,'B1',1),(9,'B2',1),(10,'B3',1),(11,'B4',1),(12,'B5',1),(13,'B6',1),(14,'B7',1),(15,'C1',1),(16,'C2',1),(17,'C3',1),(18,'C4',1),(19,'C5',1),(20,'C6',1),(21,'C7',1),(22,'D1',1),(23,'D2',1),(24,'D3',1),(25,'D4',1),(26,'D5',1),(27,'D6',1),(28,'D7',1),(29,'A1',2),(30,'A2',2),(31,'A3',2),(32,'A4',2),(33,'A5',2),(34,'A6',2),(35,'A7',2),(36,'B1',2),(37,'B2',2),(38,'B3',2),(39,'B4',2),(40,'B5',2),(41,'B6',2),(42,'B7',2),(43,'C1',2),(44,'C2',2),(45,'C3',2),(46,'C4',2),(47,'C5',2),(48,'C6',2),(49,'C7',2),(50,'D1',2),(51,'D2',2),(52,'D3',2),(53,'D4',2),(54,'D5',2),(55,'D6',2),(56,'D7',2),(57,'A1',3),(58,'A2',3),(59,'A3',3),(60,'A4',3),(61,'A5',3),(62,'A6',3),(63,'A7',3),(64,'B1',3),(65,'B2',3),(66,'B3',3),(67,'B4',3),(68,'B5',3),(69,'B6',3),(70,'B7',3),(71,'C1',3),(72,'C2',3),(73,'C3',3),(74,'C4',3),(75,'C5',3),(76,'C6',3),(77,'C7',3),(78,'D1',3),(79,'D2',3),(80,'D3',3),(81,'D4',3),(82,'D5',3),(83,'D6',3),(84,'D7',3),(85,'A1',4),(86,'A2',4),(87,'A3',4),(88,'A4',4),(89,'A5',4),(90,'A6',4),(91,'A7',4),(92,'B1',4),(93,'B2',4),(94,'B3',4),(95,'B4',4),(96,'B5',4),(97,'B6',4),(98,'B7',4),(99,'C1',4),(100,'C2',4),(101,'C3',4),(102,'C4',4),(103,'C5',4),(104,'C6',4),(105,'C7',4),(106,'D1',4),(107,'D2',4),(108,'D3',4),(109,'D4',4),(110,'D5',4),(111,'D6',4),(112,'D7',4),(113,'A1',5),(114,'A2',5),(115,'A3',5),(116,'A4',5),(117,'A5',5),(118,'A6',5),(119,'A7',5),(120,'B1',5),(121,'B2',5),(122,'B3',5),(123,'B4',5),(124,'B5',5),(125,'B6',5),(126,'B7',5),(127,'C1',5),(128,'C2',5),(129,'C3',5),(130,'C4',5),(131,'C5',5),(132,'C6',5),(133,'C7',5),(134,'D1',5),(135,'D2',5),(136,'D3',5),(137,'D4',5),(138,'D5',5),(139,'D6',5),(140,'D7',5),(141,'A1',6),(142,'A2',6),(143,'A3',6),(144,'A4',6),(145,'A5',6),(146,'A6',6),(147,'A7',6),(148,'B1',6),(149,'B2',6),(150,'B3',6),(151,'B4',6),(152,'B5',6),(153,'B6',6),(154,'B7',6),(155,'C1',6),(156,'C2',6),(157,'C3',6),(158,'C4',6),(159,'C5',6),(160,'C6',6),(161,'C7',6),(162,'D1',6),(163,'D2',6),(164,'D3',6),(165,'D4',6),(166,'D5',6),(167,'D6',6),(168,'D7',6),(169,'A1',7),(170,'A2',7),(171,'A3',7),(172,'A4',7),(173,'A5',7),(174,'A6',7),(175,'A7',7),(176,'B1',7),(177,'B2',7),(178,'B3',7),(179,'B4',7),(180,'B5',7),(181,'B6',7),(182,'B7',7),(183,'C1',7),(184,'C2',7),(185,'C3',7),(186,'C4',7),(187,'C5',7),(188,'C6',7),(189,'C7',7),(190,'D1',7),(191,'D2',7),(192,'D3',7),(193,'D4',7),(194,'D5',7),(195,'D6',7),(196,'D7',7),(197,'E1',7),(198,'E2',7),(199,'E3',7),(200,'E4',7),(201,'E5',7),(202,'E6',7),(203,'E7',7),(204,'F1',7),(205,'F2',7),(206,'F3',7),(207,'F4',7),(208,'F5',7),(209,'F6',7),(210,'F7',7),(211,'A1',8),(212,'A2',8),(213,'A3',8),(214,'A4',8),(215,'A5',8),(216,'A6',8),(217,'A7',8),(218,'B1',8),(219,'B2',8),(220,'B3',8),(221,'B4',8),(222,'B5',8),(223,'B6',8),(224,'B7',8),(225,'C1',8),(226,'C2',8),(227,'C3',8),(228,'C4',8),(229,'C5',8),(230,'C6',8),(231,'C7',8),(232,'D1',8),(233,'D2',8),(234,'D3',8),(235,'D4',8),(236,'D5',8),(237,'D6',8),(238,'D7',8),(239,'E1',8),(240,'E2',8),(241,'E3',8),(242,'E4',8),(243,'E5',8),(244,'E6',8),(245,'E7',8),(246,'F1',8),(247,'F2',8),(248,'F3',8),(249,'F4',8),(250,'F5',8),(251,'F6',8),(252,'F7',8),(253,'A1',9),(254,'A2',9),(255,'A3',9),(256,'A4',9),(257,'A5',9),(258,'A6',9),(259,'A7',9),(260,'B1',9),(261,'B2',9),(262,'B3',9),(263,'B4',9),(264,'B5',9),(265,'B6',9),(266,'B7',9),(267,'C1',9),(268,'C2',9),(269,'C3',9),(270,'C4',9),(271,'C5',9),(272,'C6',9),(273,'C7',9),(274,'D1',9),(275,'D2',9),(276,'D3',9),(277,'D4',9),(278,'D5',9),(279,'D6',9),(280,'D7',9),(281,'E1',9),(282,'E2',9),(283,'E3',9),(284,'E4',9),(285,'E5',9),(286,'E6',9),(287,'E7',9),(288,'F1',9),(289,'F2',9),(290,'F3',9),(291,'F4',9),(292,'F5',9),(293,'F6',9),(294,'F7',9),(295,'A1',10),(296,'A2',10),(297,'A3',10),(298,'A4',10),(299,'A5',10),(300,'A6',10),(301,'A7',10),(302,'B1',10),(303,'B2',10),(304,'B3',10),(305,'B4',10),(306,'B5',10),(307,'B6',10),(308,'B7',10),(309,'C1',10),(310,'C2',10),(311,'C3',10),(312,'C4',10),(313,'C5',10),(314,'C6',10),(315,'C7',10),(316,'D1',10),(317,'D2',10),(318,'D3',10),(319,'D4',10),(320,'D5',10),(321,'D6',10),(322,'D7',10),(323,'E1',10),(324,'E2',10),(325,'E3',10),(326,'E4',10),(327,'E5',10),(328,'E6',10),(329,'E7',10),(330,'F1',10),(331,'F2',10),(332,'F3',10),(333,'F4',10),(334,'F5',10),(335,'F6',10),(336,'F7',10),(337,'A1',11),(338,'A2',11),(339,'A3',11),(340,'A4',11),(341,'A5',11),(342,'A6',11),(343,'A7',11),(344,'B1',11),(345,'B2',11),(346,'B3',11),(347,'B4',11),(348,'B5',11),(349,'B6',11),(350,'B7',11),(351,'C1',11),(352,'C2',11),(353,'C3',11),(354,'C4',11),(355,'C5',11),(356,'C6',11),(357,'C7',11),(358,'D1',11),(359,'D2',11),(360,'D3',11),(361,'D4',11),(362,'D5',11),(363,'D6',11),(364,'D7',11),(365,'E1',11),(366,'E2',11),(367,'E3',11),(368,'E4',11),(369,'E5',11),(370,'E6',11),(371,'E7',11),(372,'F1',11),(373,'F2',11),(374,'F3',11),(375,'F4',11),(376,'F5',11),(377,'F6',11),(378,'F7',11),(379,'A1',12),(380,'A2',12),(381,'A3',12),(382,'A4',12),(383,'A5',12),(384,'A6',12),(385,'A7',12),(386,'B1',12),(387,'B2',12),(388,'B3',12),(389,'B4',12),(390,'B5',12),(391,'B6',12),(392,'B7',12),(393,'C1',12),(394,'C2',12),(395,'C3',12),(396,'C4',12),(397,'C5',12),(398,'C6',12),(399,'C7',12),(400,'D1',12),(401,'D2',12),(402,'D3',12),(403,'D4',12),(404,'D5',12),(405,'D6',12),(406,'D7',12),(407,'E1',12),(408,'E2',12),(409,'E3',12),(410,'E4',12),(411,'E5',12),(412,'E6',12),(413,'E7',12),(414,'F1',12),(415,'F2',12),(416,'F3',12),(417,'F4',12),(418,'F5',12),(419,'F6',12),(420,'F7',12);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Non-bed'),(2,'Bed');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` int NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `displayname` varchar(100) NOT NULL,
  `isactive` int DEFAULT '1',
  `createdDate` datetime DEFAULT NULL,
  `createdBy` varchar(16) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `updatedBy` varchar(16) DEFAULT NULL,
  `phonenumber` varchar(20) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `CT_USER_ROLE_FK` (`role`),
  CONSTRAINT `CT_USER_ROLE_FK` FOREIGN KEY (`role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'admin','admin','Admin',1,'2020-07-07 20:57:20','1','2020-07-07 21:10:42','1','0978675676','TPHCM','admin@gmail.com'),(2,2,'seller','seller','Seller',1,'2020-07-07 20:57:21','1','2020-07-07 21:10:43','1','0978675623','Ha Noi','seller@gmail.com'),(3,3,'customer','customer','Customer',1,'2020-07-07 20:57:23','1','2020-07-07 21:10:44','1','0978675645','Ha Noi','customer@gmail.com'),(4,1,'nghianq3','123456','Nguyễn Quang Nghĩa',1,'2020-07-07 20:57:24','1','2020-07-07 21:10:45','1','0976565715','TPHCM','quangnghiauit@gmail.com');
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

-- Dump completed on 2020-07-07 21:34:12
