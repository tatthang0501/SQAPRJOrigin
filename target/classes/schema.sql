-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: dangkytinchii
-- ------------------------------------------------------
-- Server version	8.0.23
create database if not exists dangkytinchii;
use dangkytinchii;
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
-- Table structure for table `bomon`
--

DROP TABLE IF EXISTS `bomon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bomon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(30) DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  `khoa_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoaid` (`khoa_id`),
  CONSTRAINT `bomon_ibfk_1` FOREIGN KEY (`khoa_id`) REFERENCES `khoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bomon`
--

LOCK TABLES `bomon` WRITE;
/*!40000 ALTER TABLE `bomon` DISABLE KEYS */;
INSERT INTO `bomon` VALUES (1,'Công nghệ phần mềm','Chuyên ngành CNTT',1),(2,'Trí tuệ nhân tạo','Chuyên ngành HTTT',1),(3,'Bảo mật hệ thống','Chuyên ngành ATTT',2),(4,'Ngăn chặn tấn công DDOS','Chuyên ngành ATTT',2),(5,'Khai phá dữ liệu đa phương tiệ','Chuyên ngành CNĐPT',3),(6,'Lập trình game','Chuyên ngành CNĐPT',3);
/*!40000 ALTER TABLE `bomon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bomon_ds_giang_vien`
--

DROP TABLE IF EXISTS `bomon_ds_giang_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bomon_ds_giang_vien` (
  `bo_mon_id` int NOT NULL,
  `ds_giang_vien_id` int NOT NULL,
  `ds_giang_vien_order` int NOT NULL,
  PRIMARY KEY (`bo_mon_id`,`ds_giang_vien_order`),
  UNIQUE KEY `UK_ibmj3wva9yjdne3yuubblyqno` (`ds_giang_vien_id`),
  CONSTRAINT `FKbfj0sn0wlmoqtcw584rhf9v2a` FOREIGN KEY (`ds_giang_vien_id`) REFERENCES `thanhvien` (`id`),
  CONSTRAINT `FKq978bh729bisqlmhjhdgvwtb7` FOREIGN KEY (`bo_mon_id`) REFERENCES `bomon` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bomon_ds_giang_vien`
--

LOCK TABLES `bomon_ds_giang_vien` WRITE;
/*!40000 ALTER TABLE `bomon_ds_giang_vien` DISABLE KEYS */;
/*!40000 ALTER TABLE `bomon_ds_giang_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diachi`
--

DROP TABLE IF EXISTS `diachi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diachi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sonha` varchar(50) DEFAULT NULL,
  `toanha` varchar(50) DEFAULT NULL,
  `xompho` varchar(50) DEFAULT NULL,
  `phuongxa` varchar(50) DEFAULT NULL,
  `quanhuyen` varchar(50) DEFAULT NULL,
  `tinhthanh` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diachi`
--

LOCK TABLES `diachi` WRITE;
/*!40000 ALTER TABLE `diachi` DISABLE KEYS */;
INSERT INTO `diachi` VALUES (1,'27','Nguyễn Đức Cảnh','Hoàng Văn Thụ','Trương Định','Hoàng Mai','Hà Nội');
/*!40000 ALTER TABLE `diachi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giangvienkhoa`
--

DROP TABLE IF EXISTS `giangvienkhoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giangvienkhoa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `k_id` int DEFAULT NULL,
  `giangvienid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoaid` (`k_id`),
  KEY `giangvienid` (`giangvienid`),
  CONSTRAINT `giangvienkhoa_ibfk_1` FOREIGN KEY (`k_id`) REFERENCES `khoa` (`id`),
  CONSTRAINT `giangvienkhoa_ibfk_2` FOREIGN KEY (`giangvienid`) REFERENCES `thanhvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giangvienkhoa`
--

LOCK TABLES `giangvienkhoa` WRITE;
/*!40000 ALTER TABLE `giangvienkhoa` DISABLE KEYS */;
INSERT INTO `giangvienkhoa` VALUES (1,1,1),(2,2,2),(3,3,3);
/*!40000 ALTER TABLE `giangvienkhoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (4);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocky`
--

DROP TABLE IF EXISTS `hocky`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hocky` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(30) DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocky`
--

LOCK TABLES `hocky` WRITE;
/*!40000 ALTER TABLE `hocky` DISABLE KEYS */;
INSERT INTO `hocky` VALUES (1,'Học kỳ 1',''),(2,'Học kỳ 2','');
/*!40000 ALTER TABLE `hocky` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa`
--

DROP TABLE IF EXISTS `khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(30) DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES (1,'CNTT',''),(2,'ATTT',''),(3,'CNĐPT','');
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kiphoc`
--

DROP TABLE IF EXISTS `kiphoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kiphoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` int DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  `lichhocid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lichhocid` (`lichhocid`),
  CONSTRAINT `kiphoc_ibfk_1` FOREIGN KEY (`lichhocid`) REFERENCES `lichhoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kiphoc`
--

LOCK TABLES `kiphoc` WRITE;
/*!40000 ALTER TABLE `kiphoc` DISABLE KEYS */;
INSERT INTO `kiphoc` VALUES (1,1,NULL,1),(2,2,NULL,1),(3,3,NULL,2),(4,4,NULL,2),(5,5,NULL,3),(6,6,NULL,3),(7,7,NULL,4),(8,8,NULL,4),(9,1,NULL,5),(10,2,NULL,5),(11,3,NULL,6),(12,4,NULL,6),(13,5,NULL,7),(14,6,NULL,7),(15,7,NULL,8),(16,8,NULL,8),(17,1,NULL,9),(18,2,NULL,9),(19,3,NULL,10),(20,4,NULL,10),(21,5,NULL,11),(22,6,NULL,11),(23,7,NULL,12),(24,8,NULL,12),(25,1,NULL,13),(26,2,NULL,13),(27,3,NULL,14),(28,4,NULL,14),(29,5,NULL,15),(30,6,NULL,15),(31,7,NULL,16),(32,8,NULL,16),(33,1,NULL,17),(34,2,NULL,17),(35,3,NULL,18),(36,4,NULL,18),(37,5,NULL,19),(38,6,NULL,19),(39,7,NULL,20),(40,8,NULL,20),(41,1,NULL,21),(42,2,NULL,21),(43,3,NULL,22),(44,4,NULL,22),(45,5,NULL,23),(46,6,NULL,23),(47,7,NULL,24),(48,8,NULL,24),(49,1,NULL,25),(50,2,NULL,25);
/*!40000 ALTER TABLE `kiphoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kyhoc`
--

DROP TABLE IF EXISTS `kyhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kyhoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `namhocid` int DEFAULT NULL,
  `hockyid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `namhocid` (`namhocid`),
  KEY `hockyid` (`hockyid`),
  CONSTRAINT `kyhoc_ibfk_1` FOREIGN KEY (`namhocid`) REFERENCES `namhoc` (`id`),
  CONSTRAINT `kyhoc_ibfk_2` FOREIGN KEY (`hockyid`) REFERENCES `hocky` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kyhoc`
--

LOCK TABLES `kyhoc` WRITE;
/*!40000 ALTER TABLE `kyhoc` DISABLE KEYS */;
INSERT INTO `kyhoc` VALUES (1,4,1),(2,4,2);
/*!40000 ALTER TABLE `kyhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lichhoc`
--

DROP TABLE IF EXISTS `lichhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lichhoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(30) DEFAULT NULL,
  `lhpid` int DEFAULT NULL,
  `phong` varchar(10) DEFAULT NULL,
  `nhomth` int DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  `giangvienid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lhpid` (`lhpid`),
  KEY `giangvienid` (`giangvienid`),
  CONSTRAINT `lichhoc_ibfk_1` FOREIGN KEY (`lhpid`) REFERENCES `lophocphan` (`id`),
  CONSTRAINT `lichhoc_ibfk_5` FOREIGN KEY (`giangvienid`) REFERENCES `thanhvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichhoc`
--

LOCK TABLES `lichhoc` WRITE;
/*!40000 ALTER TABLE `lichhoc` DISABLE KEYS */;
INSERT INTO `lichhoc` VALUES (1,'Nhập môn công nghệ phần mềm',1,'A2',1,'Hoc som',NULL),(2,'Nhập môn công nghệ phần mềm',2,'A2',1,'Hoc som',NULL),(3,'Nhập môn công nghệ phần mềm',3,'A2',1,'Hoc som',NULL),(4,'Nhập môn công nghệ phần mềm',4,'A2',1,'Hoc som',NULL),(5,'Nhập môn công nghệ phần mềm',5,'A2',1,'Hoc som',NULL),(6,'Các hệ thống phân tán',6,'A2',1,'Hoc som',NULL),(7,'Các hệ thống phân tán',7,'A2',1,'Hoc som',NULL),(8,'Các hệ thống phân tán',8,'A2',1,'Hoc som',NULL),(9,'Các hệ thống phân tán',9,'A2',1,'Hoc som',NULL),(10,'Các hệ thống phân tán',10,'A2',1,'Hoc som',NULL),(11,'Cơ sở dữ liệu phân tán',11,'A2',1,'Hoc som',NULL),(12,'Cơ sở dữ liệu phân tán',12,'A2',1,'Hoc som',NULL),(13,'Cơ sở dữ liệu phân tán',13,'A2',1,'Hoc som',NULL),(14,'Cơ sở dữ liệu phân tán',14,'A2',1,'Hoc som',NULL),(15,'Cơ sở dữ liệu phân tán',15,'A2',1,'Hoc som',NULL),(16,'Chuyên đề công nghệ phần mềm',16,'A2',1,'Hoc som',NULL),(17,'Chuyên đề công nghệ phần mềm',17,'A2',1,'Hoc som',NULL),(18,'Chuyên đề công nghệ phần mềm',18,'A2',1,'Hoc som',NULL),(19,'Chuyên đề công nghệ phần mềm',19,'A2',1,'Hoc som',NULL),(20,'Chuyên đề công nghệ phần mềm',20,'A2',1,'Hoc som',NULL),(21,'Lập trình hệ thống nhúng',21,'A2',1,'Hoc som',NULL),(22,'Lập trình hệ thống nhúng',22,'A2',1,'Hoc som',NULL),(23,'Lập trình hệ thống nhúng',23,'A2',1,'Hoc som',NULL),(24,'Lập trình hệ thống nhúng',24,'A2',1,'Hoc som',NULL),(25,'Lập trình hệ thống nhúng',25,'A2',1,'Hoc som',NULL),(26,'Nhập môn trí tuệ nhân tạo',26,'A2',1,'Hoc som',NULL),(27,'Nhập môn trí tuệ nhân tạo',27,'A2',1,'Hoc som',NULL),(28,'Nhập môn trí tuệ nhân tạo',28,'A2',1,'Hoc som',NULL),(29,'Nhập môn trí tuệ nhân tạo',29,'A2',1,'Hoc som',NULL),(30,'Nhập môn trí tuệ nhân tạo',30,'A2',1,'Hoc som',NULL),(31,'Nhập môn tương tác người - máy',31,'A2',1,'Hoc som',NULL),(32,'Nhập môn tương tác người - máy',32,'A2',1,'Hoc som',NULL),(33,'Nhập môn tương tác người - máy',33,'A2',1,'Hoc som',NULL),(34,'Nhập môn tương tác người - máy',34,'A2',1,'Hoc som',NULL),(35,'Nhập môn tương tác người - máy',35,'A2',1,'Hoc som',NULL),(36,'Cơ sở dữ liệu phân tán',36,'A2',1,'Hoc som',NULL),(37,'Cơ sở dữ liệu phân tán',37,'A2',1,'Hoc som',NULL),(38,'Cơ sở dữ liệu phân tán',38,'A2',1,'Hoc som',NULL),(39,'Cơ sở dữ liệu phân tán',39,'A2',1,'Hoc som',NULL),(40,'Cơ sở dữ liệu phân tán',40,'A2',1,'Hoc som',NULL),(41,'An toàn và bảo mật hệ thống cơ',41,'A2',1,'Hoc som',NULL),(42,'An toàn và bảo mật hệ thống cơ',42,'A2',1,'Hoc som',NULL),(43,'An toàn và bảo mật hệ thống cơ',43,'A2',1,'Hoc som',NULL),(44,'An toàn và bảo mật hệ thống cơ',44,'A2',1,'Hoc som',NULL),(45,'An toàn và bảo mật hệ thống cơ',45,'A2',1,'Hoc som',NULL),(46,'Bảo mật cơ sở dữ liệu',46,'A2',1,'Hoc som',NULL),(47,'Bảo mật cơ sở dữ liệu',47,'A2',1,'Hoc som',NULL),(48,'Bảo mật cơ sở dữ liệu',48,'A2',1,'Hoc som',NULL),(49,'Bảo mật cơ sở dữ liệu',49,'A2',1,'Hoc som',NULL),(50,'Bảo mật cơ sở dữ liệu',50,'A2',1,'Hoc som',NULL),(51,'Ngăn chặn tấn công SQL Injecti',51,'A2',1,'Hoc som',NULL),(52,'Ngăn chặn tấn công SQL Injecti',52,'A2',1,'Hoc som',NULL),(53,'Ngăn chặn tấn công SQL Injecti',53,'A2',1,'Hoc som',NULL),(54,'Ngăn chặn tấn công SQL Injecti',54,'A2',1,'Hoc som',NULL),(55,'Ngăn chặn tấn công SQL Injecti',55,'A2',1,'Hoc som',NULL),(56,'DDOS và các vấn đề liên quan',56,'A2',1,'Hoc som',NULL),(57,'DDOS và các vấn đề liên quan',57,'A2',1,'Hoc som',NULL),(58,'DDOS và các vấn đề liên quan',58,'A2',1,'Hoc som',NULL),(59,'DDOS và các vấn đề liên quan',59,'A2',1,'Hoc som',NULL),(60,'DDOS và các vấn đề liên quan',60,'A2',1,'Hoc som',NULL),(61,'Tìm hiểu và xử lý lỗ hổng hệ t',61,'A2',1,'Hoc som',NULL),(62,'Tìm hiểu và xử lý lỗ hổng hệ t',62,'A2',1,'Hoc som',NULL),(63,'Tìm hiểu và xử lý lỗ hổng hệ t',63,'A2',1,'Hoc som',NULL),(64,'Tìm hiểu và xử lý lỗ hổng hệ t',64,'A2',1,'Hoc som',NULL),(65,'Tìm hiểu và xử lý lỗ hổng hệ t',65,'A2',1,'Hoc som',NULL),(66,'Nhập môn dữ liệu đa phương tiệ',66,'A2',1,'Hoc som',NULL),(67,'Nhập môn dữ liệu đa phương tiệ',67,'A2',1,'Hoc som',NULL),(68,'Nhập môn dữ liệu đa phương tiệ',68,'A2',1,'Hoc som',NULL),(69,'Nhập môn dữ liệu đa phương tiệ',69,'A2',1,'Hoc som',NULL),(70,'Nhập môn dữ liệu đa phương tiệ',70,'A2',1,'Hoc som',NULL),(71,'Thao tác với dữ liệu đa phương',71,'A2',1,'Hoc som',NULL),(72,'Thao tác với dữ liệu đa phương',72,'A2',1,'Hoc som',NULL),(73,'Thao tác với dữ liệu đa phương',73,'A2',1,'Hoc som',NULL),(74,'Thao tác với dữ liệu đa phương',74,'A2',1,'Hoc som',NULL),(75,'Thao tác với dữ liệu đa phương',75,'A2',1,'Hoc som',NULL),(76,'Chuyên đề công nghệ đa phương ',76,'A2',1,'Hoc som',NULL),(77,'Chuyên đề công nghệ đa phương ',77,'A2',1,'Hoc som',NULL),(78,'Chuyên đề công nghệ đa phương ',78,'A2',1,'Hoc som',NULL),(79,'Chuyên đề công nghệ đa phương ',79,'A2',1,'Hoc som',NULL),(80,'Chuyên đề công nghệ đa phương ',80,'A2',1,'Hoc som',NULL),(81,'Nhập môn lập trình game',81,'A2',1,'Hoc som',NULL),(82,'Nhập môn lập trình game',82,'A2',1,'Hoc som',NULL),(83,'Nhập môn lập trình game',83,'A2',1,'Hoc som',NULL),(84,'Nhập môn lập trình game',84,'A2',1,'Hoc som',NULL),(85,'Nhập môn lập trình game',85,'A2',1,'Hoc som',NULL),(86,'Công nghệ phát triển game',86,'A2',1,'Hoc som',NULL),(87,'Công nghệ phát triển game',87,'A2',1,'Hoc som',NULL),(88,'Công nghệ phát triển game',88,'A2',1,'Hoc som',NULL),(89,'Công nghệ phát triển game',89,'A2',1,'Hoc som',NULL),(90,'Công nghệ phát triển game',90,'A2',1,'Hoc som',NULL),(91,'Công nghệ thực tế ảo',91,'A2',1,'Hoc som',NULL),(92,'Công nghệ thực tế ảo',92,'A2',1,'Hoc som',NULL),(93,'Công nghệ thực tế ảo',93,'A2',1,'Hoc som',NULL),(94,'Công nghệ thực tế ảo',94,'A2',1,'Hoc som',NULL),(95,'Công nghệ thực tế ảo',95,'A2',1,'Hoc som',NULL);
/*!40000 ALTER TABLE `lichhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lophocphan`
--

DROP TABLE IF EXISTS `lophocphan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lophocphan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(30) DEFAULT NULL,
  `sisotoida` int DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  `monhockyhocid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `monhockyhocid` (`monhockyhocid`),
  CONSTRAINT `lophocphan_ibfk_1` FOREIGN KEY (`monhockyhocid`) REFERENCES `monhockyhoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lophocphan`
--

LOCK TABLES `lophocphan` WRITE;
/*!40000 ALTER TABLE `lophocphan` DISABLE KEYS */;
INSERT INTO `lophocphan` VALUES (1,'NMCNPM',50,'',1),(2,'NMCNPM',45,'',1),(3,'NMCNPM',50,'',1),(4,'NMCNPM',50,'',1),(5,'NMCNPM',50,'',1),(6,NULL,50,'ok',2),(7,NULL,50,'ok',2),(8,NULL,50,'ok',2),(9,NULL,50,'ok',2),(10,NULL,50,'ok',2),(11,NULL,50,'ok',3),(12,NULL,50,'ok',3),(13,NULL,50,'ok',3),(14,NULL,50,'ok',3),(15,NULL,50,'ok',3),(16,NULL,50,'ok',4),(17,NULL,50,'ok',4),(18,NULL,50,'ok',4),(19,NULL,50,'ok',4),(20,NULL,50,'ok',4),(21,NULL,50,'ok',5),(22,NULL,50,'ok',5),(23,NULL,50,'ok',5),(24,NULL,50,'ok',5),(25,NULL,50,'ok',5),(26,NULL,50,'ok',6),(27,NULL,50,'ok',6),(28,NULL,50,'ok',6),(29,NULL,50,'ok',6),(30,NULL,50,'ok',6),(31,NULL,50,'ok',7),(32,NULL,50,'ok',7),(33,NULL,50,'ok',7),(34,NULL,50,'ok',7),(35,NULL,50,'ok',7),(36,NULL,50,'ok',8),(37,NULL,50,'ok',8),(38,NULL,50,'ok',8),(39,NULL,50,'ok',8),(40,NULL,50,'ok',8),(41,NULL,50,'ok',9),(42,NULL,50,'ok',9),(43,NULL,50,'ok',9),(44,NULL,50,'ok',9),(45,NULL,50,'ok',9),(46,NULL,50,'ok',10),(47,NULL,50,'ok',10),(48,NULL,50,'ok',10),(49,NULL,50,'ok',10),(50,NULL,50,'ok',10),(51,NULL,50,'ok',11),(52,NULL,50,'ok',11),(53,NULL,50,'ok',11),(54,NULL,50,'ok',11),(55,NULL,50,'ok',11),(56,NULL,50,'ok',12),(57,NULL,50,'ok',12),(58,NULL,50,'ok',12),(59,NULL,50,'ok',12),(60,NULL,50,'ok',12),(61,NULL,50,'ok',13),(62,NULL,50,'ok',13),(63,NULL,50,'ok',13),(64,NULL,50,'ok',13),(65,NULL,50,'ok',13),(66,NULL,50,'ok',14),(67,NULL,50,'ok',14),(68,NULL,50,'ok',14),(69,NULL,50,'ok',14),(70,NULL,50,'ok',14),(71,NULL,50,'ok',15),(72,NULL,50,'ok',15),(73,NULL,50,'ok',15),(74,NULL,50,'ok',15),(75,NULL,50,'ok',15),(76,NULL,50,'ok',16),(77,NULL,50,'ok',16),(78,NULL,50,'ok',16),(79,NULL,50,'ok',16),(80,NULL,50,'ok',16),(81,NULL,50,'ok',17),(82,NULL,50,'ok',17),(83,NULL,50,'ok',17),(84,NULL,50,'ok',17),(85,NULL,50,'ok',17),(86,NULL,50,'ok',18),(87,NULL,50,'ok',18),(88,NULL,50,'ok',18),(89,NULL,50,'ok',18),(90,NULL,50,'ok',18),(91,NULL,50,'ok',19),(92,NULL,50,'ok',19),(93,NULL,50,'ok',19),(94,NULL,50,'ok',19),(95,NULL,50,'ok',19);
/*!40000 ALTER TABLE `lophocphan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(30) DEFAULT NULL,
  `sotc` int DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  `bomonid` int DEFAULT NULL,
  `ds_mon_hoc_order` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bomonid` (`bomonid`),
  CONSTRAINT `monhoc_ibfk_1` FOREIGN KEY (`bomonid`) REFERENCES `bomon` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'Nhập môn công nghệ phần mềm',3,'Môn chuyên ngành',1,NULL),(2,'Các hệ thống phân tán',3,'Môn chuyên ngành',1,NULL),(3,'Cơ sở dữ liệu phân tán',2,'Môn chuyên ngành',1,NULL),(4,'Chuyên đề công nghệ phần mềm',1,'Môn chuyên ngành',1,NULL),(5,'Lập trình hệ thống nhúng',3,'Môn chuyên ngành',1,NULL),(6,'Nhập môn trí tuệ nhân tạo',3,'Môn chuyên ngành',2,NULL),(7,'Nhập môn tương tác người - máy',3,'Môn chuyên ngành',2,NULL),(8,'Cơ sở dữ liệu phân tán',3,'Môn chuyên ngành',2,NULL),(9,'An toàn và bảo mật hệ thống cơ',3,'Môn chuyên ngành',3,NULL),(10,'Bảo mật cơ sở dữ liệu',2,'Môn chuyên ngành',3,NULL),(11,'Ngăn chặn tấn công SQL Injecti',2,'Môn chuyên ngành',3,NULL),(12,'DDOS và các vấn đề liên quan',2,'Môn chuyên ngành',4,NULL),(13,'Tìm hiểu và xử lý lỗ hổng hệ t',3,'Môn chuyên ngành',4,NULL),(14,'Nhập môn dữ liệu đa phương tiệ',3,'Môn chuyên ngành',5,NULL),(15,'Thao tác với dữ liệu đa phương',2,'Môn chuyên ngành',5,NULL),(16,'Chuyên đề công nghệ đa phương ',1,'Môn chuyên ngành',5,NULL),(17,'Nhập môn lập trình game',3,'Môn chuyên ngành',6,NULL),(18,'Công nghệ phát triển game',3,'Môn chuyên ngành',6,NULL),(19,'Công nghệ thực tế ảo',3,'Môn chuyên ngành',6,NULL);
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhockyhoc`
--

DROP TABLE IF EXISTS `monhockyhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhockyhoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `monhocid` int DEFAULT NULL,
  `kyhocid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `monhocid` (`monhocid`),
  KEY `kyhocid` (`kyhocid`),
  CONSTRAINT `monhockyhoc_ibfk_1` FOREIGN KEY (`monhocid`) REFERENCES `monhoc` (`id`),
  CONSTRAINT `monhockyhoc_ibfk_2` FOREIGN KEY (`kyhocid`) REFERENCES `kyhoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhockyhoc`
--

LOCK TABLES `monhockyhoc` WRITE;
/*!40000 ALTER TABLE `monhockyhoc` DISABLE KEYS */;
INSERT INTO `monhockyhoc` VALUES (1,1,2),(2,2,2),(3,3,2),(4,4,2),(5,5,2),(6,6,2),(7,7,2),(8,8,2),(9,9,2),(10,10,2),(11,11,2),(12,12,2),(13,13,2),(14,14,2),(15,15,2),(16,16,2),(17,17,2),(18,18,2),(19,19,2);
/*!40000 ALTER TABLE `monhockyhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `namhoc`
--

DROP TABLE IF EXISTS `namhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `namhoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(30) DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `namhoc`
--

LOCK TABLES `namhoc` WRITE;
/*!40000 ALTER TABLE `namhoc` DISABLE KEYS */;
INSERT INTO `namhoc` VALUES (1,'2015-2016',''),(2,'2016-2017',''),(3,'2017-2018',''),(4,'2020-2021','');
/*!40000 ALTER TABLE `namhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ngayhoc`
--

DROP TABLE IF EXISTS `ngayhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ngayhoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` int DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  `lichhocid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lichhocid` (`lichhocid`),
  CONSTRAINT `ngayhoc_ibfk_1` FOREIGN KEY (`lichhocid`) REFERENCES `lichhoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ngayhoc`
--

LOCK TABLES `ngayhoc` WRITE;
/*!40000 ALTER TABLE `ngayhoc` DISABLE KEYS */;
INSERT INTO `ngayhoc` VALUES (1,2,NULL,1),(2,2,NULL,2),(3,2,NULL,3),(4,2,NULL,4),(5,3,NULL,5),(6,3,NULL,6),(7,3,NULL,7),(8,3,NULL,8),(9,4,NULL,9),(10,4,NULL,10),(11,4,NULL,11),(12,4,NULL,12),(13,5,NULL,13),(14,5,NULL,14),(15,5,NULL,15),(16,5,NULL,16),(17,6,NULL,17),(18,6,NULL,18),(19,6,NULL,18),(20,6,NULL,20),(21,7,NULL,21),(22,7,NULL,22),(23,7,NULL,23),(24,7,NULL,24),(25,7,NULL,25);
/*!40000 ALTER TABLE `ngayhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thanhvien`
--

DROP TABLE IF EXISTS `thanhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thanhvien` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dt` varchar(15) DEFAULT NULL,
  `ghichu` varchar(100) DEFAULT NULL,
  `vitri` varchar(15) DEFAULT NULL,
  `ho` varchar(10) DEFAULT NULL,
  `dem` varchar(10) DEFAULT NULL,
  `ten` varchar(10) DEFAULT NULL,
  `diachiid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKaqvl11qr32f5irlamc30ejhpc` (`username`),
  UNIQUE KEY `UK2a17y6sc1lnme5t0wn6bthpci` (`email`),
  KEY `diachiid` (`diachiid`),
  CONSTRAINT `thanhvien_ibfk_1` FOREIGN KEY (`diachiid`) REFERENCES `diachi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thanhvien`
--

LOCK TABLES `thanhvien` WRITE;
/*!40000 ALTER TABLE `thanhvien` DISABLE KEYS */;
INSERT INTO `thanhvien` VALUES (1,'thang','$2a$10$smbNcf.fuTOOfkdeV5VbEOstMpw45ee6Fpg7HDFIIE6o3wX9KExDa','1999-05-01','thang@123.com','0337971060','ghichu','giangvien','thang','thang','thang',NULL),(2,'thangATTT','$2a$10$3QOc.89PGPg/hsJqjMa0JO5SNHEVU2hlXxbqD/S.IdN9yitMpkGkm','1999-05-01','thangATTT@123.com','0337971060','ghichu','giangvien','thang','thang','thang',NULL),(3,'thangCNDPT','$2a$10$8/KVe4gK/n975iFDAlP6UeeCnRj0tBAFHTKPSk4BWtrDTf.8R25z.','1999-05-01','thangCNDPT@123.com','0337971060','ghichu','giangvien','thang','thang','thang',NULL);
/*!40000 ALTER TABLE `thanhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuanhoc`
--

DROP TABLE IF EXISTS `tuanhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuanhoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` int DEFAULT NULL,
  `mota` varchar(30) DEFAULT NULL,
  `lichhocid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lichhocid` (`lichhocid`),
  CONSTRAINT `tuanhoc_ibfk_1` FOREIGN KEY (`lichhocid`) REFERENCES `lichhoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuanhoc`
--

LOCK TABLES `tuanhoc` WRITE;
/*!40000 ALTER TABLE `tuanhoc` DISABLE KEYS */;
INSERT INTO `tuanhoc` VALUES (1,1,NULL,1),(2,2,NULL,1),(3,3,NULL,1),(4,4,NULL,1),(5,5,NULL,1),(6,6,NULL,1),(7,7,NULL,1),(8,8,NULL,1),(9,9,NULL,1),(10,10,NULL,1),(11,11,NULL,1),(12,12,NULL,1),(13,13,NULL,1),(14,14,NULL,1),(15,15,NULL,1),(16,16,NULL,1),(17,1,NULL,2),(18,2,NULL,2),(19,3,NULL,2),(20,4,NULL,2),(21,5,NULL,2),(22,6,NULL,2),(23,7,NULL,2),(24,8,NULL,2),(25,9,NULL,2),(26,10,NULL,2),(27,11,NULL,2),(28,12,NULL,2),(29,13,NULL,2),(30,14,NULL,2),(31,15,NULL,2),(32,16,NULL,2),(33,1,NULL,3),(34,2,NULL,3),(35,3,NULL,3),(36,4,NULL,3),(37,5,NULL,3),(38,6,NULL,3),(39,7,NULL,3),(40,8,NULL,3),(41,9,NULL,3),(42,10,NULL,3),(43,11,NULL,3),(44,12,NULL,3),(45,13,NULL,3),(47,15,NULL,3),(48,16,NULL,3),(49,1,NULL,4),(50,2,NULL,4),(51,3,NULL,4),(52,4,NULL,4),(53,5,NULL,4),(54,6,NULL,4),(55,7,NULL,4),(56,8,NULL,4),(57,9,NULL,4),(58,10,NULL,4),(59,11,NULL,4),(60,12,NULL,4),(61,13,NULL,4),(62,14,NULL,4),(63,15,NULL,4),(64,16,NULL,4),(146,14,NULL,3);
/*!40000 ALTER TABLE `tuanhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dangkytinchii'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-07  3:03:31
