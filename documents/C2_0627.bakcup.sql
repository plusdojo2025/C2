-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: C2
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `files`
--

DROP TABLE IF EXISTS `files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `files` (
  `id` int NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `filedata` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `files`
--

LOCK TABLES `files` WRITE;
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
/*!40000 ALTER TABLE `files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_checkbag`
--

DROP TABLE IF EXISTS `tbl_checkbag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_checkbag` (
  `bagNumber` int NOT NULL AUTO_INCREMENT,
  `bagCheck` tinyint(1) DEFAULT NULL,
  `bagName` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bagStock` int DEFAULT NULL,
  `bagLink` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `userNumber` int NOT NULL,
  PRIMARY KEY (`bagNumber`),
  KEY `userNumber` (`userNumber`),
  CONSTRAINT `tbl_checkbag_ibfk_1` FOREIGN KEY (`userNumber`) REFERENCES `tbl_registuser` (`userNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_checkbag`
--

LOCK TABLES `tbl_checkbag` WRITE;
/*!40000 ALTER TABLE `tbl_checkbag` DISABLE KEYS */;
INSERT INTO `tbl_checkbag` VALUES (1,0,'防災頭巾',1,'https://item.rakuten.co.jp/ccstyle/cg_bousai_k2/',1),(2,0,'衣類・下着',3,'https://item.rakuten.co.jp/peaceup/10002147/',1),(3,0,'ウェットティッシュ',3,'https://item.rakuten.co.jp/lilyan/ko-14/?iasid=07rpp_10095___3a-mca3sy9c-9a-99a54da8-3dfc-41f6-8056-55b1c7bcd40c',1),(4,0,'レインウェア',1,'https://item.rakuten.co.jp/beisia/st-404/?iasid=07rpp_10095___2u-mca3tjv2-a3-5a85a1b5-2e28-441a-ab6c-52c91d243a5f',1),(5,0,'懐中電灯',1,'https://item.rakuten.co.jp/hrktonya/yj-l37/?iasid=07rpp_10095___3o-mca3uceh-as-a942e76c-5d8f-42ad-aaf9-0b18b2d0bb6f',1),(6,0,'携帯ラジオ',1,'https://item.rakuten.co.jp/hermanherman/200000896/',1),(7,0,'予備電池',1,'https://item.rakuten.co.jp/f222216-kosai/1392541/',1),(8,0,'救急箱',1,'https://item.rakuten.co.jp/lifebest/f0098ht13/',1),(9,0,'使い捨てカイロ',5,'https://item.rakuten.co.jp/kurashikenkou/1894687/?iasid=07rpp_10095___31-mca4ag1g-6v-41d046d9-f038-4094-987d-9b75c5e92942',1),(10,0,'ブランケット',1,'https://item.rakuten.co.jp/at-rescue/10000829/?iasid=07rpp_10095___2w-mca4avs9-8s-64c2b18f-e411-4f42-b156-052b306afea1',1),(11,0,'軍手',2,'https://item.rakuten.co.jp/liferinger/gloves/?iasid=07rpp_10095___3u-mca4bc56-6h-3f30a1f2-3e40-4390-9055-ea7062c77288',1),(12,0,'洗面用具',1,'https://item.rakuten.co.jp/at-rescue/10000848/',1),(13,0,'タオル',3,'https://item.rakuten.co.jp/ito-ito/10000017/?iasid=07rpp_10095___3u-mca4di5w-9u-cc17611c-5913-4727-a6f6-7643559c707a',1),(14,0,'手指消毒用アルコール',1,'https://item.rakuten.co.jp/kagu-eline/eg1147/?variantId=eg1147-1',1),(15,0,'',1,'',1),(16,0,'',1,'',1),(17,0,'',1,'',1),(18,0,'',1,'',1),(19,0,'',1,'',1),(20,0,'',1,'',1),(21,0,'',1,'',1),(22,0,'',1,'',1),(23,0,'防災頭巾',1,'https://item.rakuten.co.jp/ccstyle/cg_bousai_k2/',2),(24,0,'衣類・下着',3,'https://item.rakuten.co.jp/peaceup/10002147/',2),(25,0,'ウェットティッシュ',3,'https://item.rakuten.co.jp/lilyan/ko-14/?iasid=07rpp_10095___3a-mca3sy9c-9a-99a54da8-3dfc-41f6-8056-55b1c7bcd40c',2),(26,0,'レインウェア',1,'https://item.rakuten.co.jp/beisia/st-404/?iasid=07rpp_10095___2u-mca3tjv2-a3-5a85a1b5-2e28-441a-ab6c-52c91d243a5f',2),(27,0,'懐中電灯',1,'https://item.rakuten.co.jp/hrktonya/yj-l37/?iasid=07rpp_10095___3o-mca3uceh-as-a942e76c-5d8f-42ad-aaf9-0b18b2d0bb6f',2),(28,0,'携帯ラジオ',1,'https://item.rakuten.co.jp/hermanherman/200000896/',2),(29,0,'予備電池',1,'https://item.rakuten.co.jp/f222216-kosai/1392541/',2),(30,0,'救急箱',1,'https://item.rakuten.co.jp/lifebest/f0098ht13/',2),(31,0,'使い捨てカイロ',5,'https://item.rakuten.co.jp/kurashikenkou/1894687/?iasid=07rpp_10095___31-mca4ag1g-6v-41d046d9-f038-4094-987d-9b75c5e92942',2),(32,0,'ブランケット',1,'https://item.rakuten.co.jp/at-rescue/10000829/?iasid=07rpp_10095___2w-mca4avs9-8s-64c2b18f-e411-4f42-b156-052b306afea1',2),(33,0,'軍手',2,'https://item.rakuten.co.jp/liferinger/gloves/?iasid=07rpp_10095___3u-mca4bc56-6h-3f30a1f2-3e40-4390-9055-ea7062c77288',2),(34,0,'洗面用具',1,'https://item.rakuten.co.jp/at-rescue/10000848/',2),(35,0,'タオル',3,'https://item.rakuten.co.jp/ito-ito/10000017/?iasid=07rpp_10095___3u-mca4di5w-9u-cc17611c-5913-4727-a6f6-7643559c707a',2),(36,0,'手指消毒用アルコール',1,'https://item.rakuten.co.jp/kagu-eline/eg1147/?variantId=eg1147-1',2),(37,0,'',0,'',2),(38,0,'',0,'',2),(39,0,'',0,'',2),(40,0,'',0,'',2),(41,0,'',0,'',2),(42,0,'',0,'',2),(43,0,'',0,'',2),(44,0,'',0,'',2),(45,0,'防災頭巾',1,'https://item.rakuten.co.jp/ccstyle/cg_bousai_k2/',3),(46,0,'衣類・下着',3,'https://item.rakuten.co.jp/peaceup/10002147/',3),(47,0,'ウェットティッシュ',3,'https://item.rakuten.co.jp/lilyan/ko-14/?iasid=07rpp_10095___3a-mca3sy9c-9a-99a54da8-3dfc-41f6-8056-55b1c7bcd40c',3),(48,0,'レインウェア',1,'https://item.rakuten.co.jp/beisia/st-404/?iasid=07rpp_10095___2u-mca3tjv2-a3-5a85a1b5-2e28-441a-ab6c-52c91d243a5f',3),(49,0,'懐中電灯',1,'https://item.rakuten.co.jp/hrktonya/yj-l37/?iasid=07rpp_10095___3o-mca3uceh-as-a942e76c-5d8f-42ad-aaf9-0b18b2d0bb6f',3),(50,0,'携帯ラジオ',1,'https://item.rakuten.co.jp/hermanherman/200000896/',3),(51,0,'予備電池',1,'https://item.rakuten.co.jp/f222216-kosai/1392541/',3),(52,0,'救急箱',1,'https://item.rakuten.co.jp/lifebest/f0098ht13/',3),(53,0,'使い捨てカイロ',5,'https://item.rakuten.co.jp/kurashikenkou/1894687/?iasid=07rpp_10095___31-mca4ag1g-6v-41d046d9-f038-4094-987d-9b75c5e92942',3),(54,0,'ブランケット',1,'https://item.rakuten.co.jp/at-rescue/10000829/?iasid=07rpp_10095___2w-mca4avs9-8s-64c2b18f-e411-4f42-b156-052b306afea1',3),(55,0,'軍手',2,'https://item.rakuten.co.jp/liferinger/gloves/?iasid=07rpp_10095___3u-mca4bc56-6h-3f30a1f2-3e40-4390-9055-ea7062c77288',3),(56,0,'洗面用具',1,'https://item.rakuten.co.jp/at-rescue/10000848/',3),(57,0,'タオル',3,'https://item.rakuten.co.jp/ito-ito/10000017/?iasid=07rpp_10095___3u-mca4di5w-9u-cc17611c-5913-4727-a6f6-7643559c707a',3),(58,0,'手指消毒用アルコール',1,'https://item.rakuten.co.jp/kagu-eline/eg1147/?variantId=eg1147-1',3),(59,0,'',0,'',3),(60,0,'',0,'',3),(61,0,'',0,'',3),(62,0,'',0,'',3),(63,0,'',0,'',3),(64,0,'',0,'',3),(65,0,'',0,'',3),(66,0,'',0,'',3),(67,0,'防災頭巾',1,'https://item.rakuten.co.jp/ccstyle/cg_bousai_k2/',4),(68,0,'衣類・下着',3,'https://item.rakuten.co.jp/peaceup/10002147/',4),(69,0,'ウェットティッシュ',3,'https://item.rakuten.co.jp/lilyan/ko-14/?iasid=07rpp_10095___3a-mca3sy9c-9a-99a54da8-3dfc-41f6-8056-55b1c7bcd40c',4),(70,0,'レインウェア',1,'https://item.rakuten.co.jp/beisia/st-404/?iasid=07rpp_10095___2u-mca3tjv2-a3-5a85a1b5-2e28-441a-ab6c-52c91d243a5f',4),(71,0,'懐中電灯',1,'https://item.rakuten.co.jp/hrktonya/yj-l37/?iasid=07rpp_10095___3o-mca3uceh-as-a942e76c-5d8f-42ad-aaf9-0b18b2d0bb6f',4),(72,0,'携帯ラジオ',1,'https://item.rakuten.co.jp/hermanherman/200000896/',4),(73,0,'予備電池',1,'https://item.rakuten.co.jp/f222216-kosai/1392541/',4),(74,0,'救急箱',1,'https://item.rakuten.co.jp/lifebest/f0098ht13/',4),(75,0,'使い捨てカイロ',5,'https://item.rakuten.co.jp/kurashikenkou/1894687/?iasid=07rpp_10095___31-mca4ag1g-6v-41d046d9-f038-4094-987d-9b75c5e92942',4),(76,0,'ブランケット',1,'https://item.rakuten.co.jp/at-rescue/10000829/?iasid=07rpp_10095___2w-mca4avs9-8s-64c2b18f-e411-4f42-b156-052b306afea1',4),(77,0,'軍手',2,'https://item.rakuten.co.jp/liferinger/gloves/?iasid=07rpp_10095___3u-mca4bc56-6h-3f30a1f2-3e40-4390-9055-ea7062c77288',4),(78,0,'洗面用具',1,'https://item.rakuten.co.jp/at-rescue/10000848/',4),(79,0,'タオル',3,'https://item.rakuten.co.jp/ito-ito/10000017/?iasid=07rpp_10095___3u-mca4di5w-9u-cc17611c-5913-4727-a6f6-7643559c707a',4),(80,0,'手指消毒用アルコール',1,'https://item.rakuten.co.jp/kagu-eline/eg1147/?variantId=eg1147-1',4),(81,0,'',0,'',4),(82,0,'',0,'',4),(83,0,'',0,'',4),(84,0,'',0,'',4),(85,0,'',0,'',4),(86,0,'',0,'',4),(87,0,'',0,'',4),(88,0,'',0,'',4),(89,0,'防災頭巾',1,'https://item.rakuten.co.jp/ccstyle/cg_bousai_k2/',5),(90,0,'衣類・下着',3,'https://item.rakuten.co.jp/peaceup/10002147/',5),(91,0,'ウェットティッシュ',3,'https://item.rakuten.co.jp/lilyan/ko-14/?iasid=07rpp_10095___3a-mca3sy9c-9a-99a54da8-3dfc-41f6-8056-55b1c7bcd40c',5),(92,0,'レインウェア',1,'https://item.rakuten.co.jp/beisia/st-404/?iasid=07rpp_10095___2u-mca3tjv2-a3-5a85a1b5-2e28-441a-ab6c-52c91d243a5f',5),(93,0,'懐中電灯',1,'https://item.rakuten.co.jp/hrktonya/yj-l37/?iasid=07rpp_10095___3o-mca3uceh-as-a942e76c-5d8f-42ad-aaf9-0b18b2d0bb6f',5),(94,0,'携帯ラジオ',1,'https://item.rakuten.co.jp/hermanherman/200000896/',5),(95,0,'予備電池',1,'https://item.rakuten.co.jp/f222216-kosai/1392541/',5),(96,0,'救急箱',1,'https://item.rakuten.co.jp/lifebest/f0098ht13/',5),(97,0,'使い捨てカイロ',5,'https://item.rakuten.co.jp/kurashikenkou/1894687/?iasid=07rpp_10095___31-mca4ag1g-6v-41d046d9-f038-4094-987d-9b75c5e92942',5),(98,0,'ブランケット',1,'https://item.rakuten.co.jp/at-rescue/10000829/?iasid=07rpp_10095___2w-mca4avs9-8s-64c2b18f-e411-4f42-b156-052b306afea1',5),(99,0,'軍手',2,'https://item.rakuten.co.jp/liferinger/gloves/?iasid=07rpp_10095___3u-mca4bc56-6h-3f30a1f2-3e40-4390-9055-ea7062c77288',5),(100,0,'洗面用具',1,'https://item.rakuten.co.jp/at-rescue/10000848/',5),(101,0,'タオル',3,'https://item.rakuten.co.jp/ito-ito/10000017/?iasid=07rpp_10095___3u-mca4di5w-9u-cc17611c-5913-4727-a6f6-7643559c707a',5),(102,0,'手指消毒用アルコール',1,'https://item.rakuten.co.jp/kagu-eline/eg1147/?variantId=eg1147-1',5),(103,0,'',0,'',5),(104,0,'',0,'',5),(105,0,'',0,'',5),(106,0,'',0,'',5),(107,0,'',0,'',5),(108,0,'',0,'',5),(109,0,'',0,'',5),(110,0,'',0,'',5);
/*!40000 ALTER TABLE `tbl_checkbag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_checkbagtemp`
--

DROP TABLE IF EXISTS `tbl_checkbagtemp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_checkbagtemp` (
  `bagNumber` int NOT NULL AUTO_INCREMENT,
  `bagCheck` tinyint(1) DEFAULT NULL,
  `bagName` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bagStock` int DEFAULT NULL,
  `bagLink` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`bagNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_checkbagtemp`
--

LOCK TABLES `tbl_checkbagtemp` WRITE;
/*!40000 ALTER TABLE `tbl_checkbagtemp` DISABLE KEYS */;
INSERT INTO `tbl_checkbagtemp` VALUES (1,0,'防災頭巾',1,'https://item.rakuten.co.jp/ccstyle/cg_bousai_k2/'),(2,0,'衣類・下着',3,'https://item.rakuten.co.jp/peaceup/10002147/'),(3,0,'ウェットティッシュ',3,'https://item.rakuten.co.jp/lilyan/ko-14/?iasid=07rpp_10095___3a-mca3sy9c-9a-99a54da8-3dfc-41f6-8056-55b1c7bcd40c'),(4,0,'レインウェア',1,'https://item.rakuten.co.jp/beisia/st-404/?iasid=07rpp_10095___2u-mca3tjv2-a3-5a85a1b5-2e28-441a-ab6c-52c91d243a5f'),(5,0,'懐中電灯',1,'https://item.rakuten.co.jp/hrktonya/yj-l37/?iasid=07rpp_10095___3o-mca3uceh-as-a942e76c-5d8f-42ad-aaf9-0b18b2d0bb6f'),(6,0,'携帯ラジオ',1,'https://item.rakuten.co.jp/hermanherman/200000896/'),(7,0,'予備電池',1,'https://item.rakuten.co.jp/f222216-kosai/1392541/'),(8,0,'救急箱',1,'https://item.rakuten.co.jp/lifebest/f0098ht13/'),(9,0,'使い捨てカイロ',5,'https://item.rakuten.co.jp/kurashikenkou/1894687/?iasid=07rpp_10095___31-mca4ag1g-6v-41d046d9-f038-4094-987d-9b75c5e92942'),(10,0,'ブランケット',1,'https://item.rakuten.co.jp/at-rescue/10000829/?iasid=07rpp_10095___2w-mca4avs9-8s-64c2b18f-e411-4f42-b156-052b306afea1'),(11,0,'軍手',2,'https://item.rakuten.co.jp/liferinger/gloves/?iasid=07rpp_10095___3u-mca4bc56-6h-3f30a1f2-3e40-4390-9055-ea7062c77288'),(12,0,'洗面用具',1,'https://item.rakuten.co.jp/at-rescue/10000848/'),(13,0,'タオル',3,'https://item.rakuten.co.jp/ito-ito/10000017/?iasid=07rpp_10095___3u-mca4di5w-9u-cc17611c-5913-4727-a6f6-7643559c707a'),(14,0,'手指消毒用アルコール',1,'https://item.rakuten.co.jp/kagu-eline/eg1147/?variantId=eg1147-1'),(15,0,'',0,''),(16,0,'',0,''),(17,0,'',0,''),(18,0,'',0,''),(19,0,'',0,''),(20,0,'',0,''),(21,0,'',0,''),(22,0,'',0,'');
/*!40000 ALTER TABLE `tbl_checkbagtemp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_lifehackfavorite`
--

DROP TABLE IF EXISTS `tbl_lifehackfavorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_lifehackfavorite` (
  `lifehackfavoriteNumber` int NOT NULL AUTO_INCREMENT,
  `familyId` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lifehackNumber` int NOT NULL,
  PRIMARY KEY (`lifehackfavoriteNumber`),
  KEY `familyId` (`familyId`),
  KEY `lifehackNumber` (`lifehackNumber`),
  CONSTRAINT `tbl_lifehackfavorite_ibfk_1` FOREIGN KEY (`familyId`) REFERENCES `tbl_registfamily` (`familyId`),
  CONSTRAINT `tbl_lifehackfavorite_ibfk_2` FOREIGN KEY (`lifehackNumber`) REFERENCES `tbl_lifehacklist` (`lifehackNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_lifehackfavorite`
--

LOCK TABLES `tbl_lifehackfavorite` WRITE;
/*!40000 ALTER TABLE `tbl_lifehackfavorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_lifehackfavorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_lifehacklist`
--

DROP TABLE IF EXISTS `tbl_lifehacklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_lifehacklist` (
  `lifehackNumber` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `textline` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`lifehackNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_lifehacklist`
--

LOCK TABLES `tbl_lifehacklist` WRITE;
/*!40000 ALTER TABLE `tbl_lifehacklist` DISABLE KEYS */;
INSERT INTO `tbl_lifehacklist` VALUES (1,'サランラップの再利用','img/Rap.jpg','サランラップはテーピング代わり負傷箇所に巻き付ける。'),(2,'レジ袋の再利用','img/Shoppingbag.jpg','腕を支える形で安定させれば、レジ袋は三角巾の代わりになり得る。'),(3,'ペットボトルで作る即席ランタン','img/Rantan.jpg','懐中電灯のライト部分に水を入れたペットボトルをかぶせる。'),(4,'電池の代用','img/Tansandenchi.jpg','単三電池にアルミホイルや紙を巻いてサイズを調整し、単一電池として使用が可能。'),(5,'使い捨てカイロの有効活用','img/kairo.jpg','段ボールの中に新聞紙、使い捨てカイロを入れると簡易カイロ床暖房の完成。'),(6,'ジップロックでスマホ保護','img/Ziprock.jpg','雨や水害でも、ジップロックにスマホを入れるとスマホを守ることができる。操作もそのままで非常に便利。');
/*!40000 ALTER TABLE `tbl_lifehacklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_lifehackrequest`
--

DROP TABLE IF EXISTS `tbl_lifehackrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_lifehackrequest` (
  `registNumber` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `photo` int DEFAULT NULL,
  `textline` varchar(1000) NOT NULL,
  PRIMARY KEY (`registNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_lifehackrequest`
--

LOCK TABLES `tbl_lifehackrequest` WRITE;
/*!40000 ALTER TABLE `tbl_lifehackrequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_lifehackrequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_registfamily`
--

DROP TABLE IF EXISTS `tbl_registfamily`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_registfamily` (
  `familyId` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`familyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_registfamily`
--

LOCK TABLES `tbl_registfamily` WRITE;
/*!40000 ALTER TABLE `tbl_registfamily` DISABLE KEYS */;
INSERT INTO `tbl_registfamily` VALUES ('dojouser1'),('dojouser2');
/*!40000 ALTER TABLE `tbl_registfamily` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_registuser`
--

DROP TABLE IF EXISTS `tbl_registuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_registuser` (
  `userNumber` int NOT NULL AUTO_INCREMENT,
  `mail` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `familyId` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userNumber`),
  UNIQUE KEY `mail` (`mail`),
  KEY `familyId` (`familyId`),
  CONSTRAINT `tbl_registuser_ibfk_1` FOREIGN KEY (`familyId`) REFERENCES `tbl_registfamily` (`familyId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_registuser`
--

LOCK TABLES `tbl_registuser` WRITE;
/*!40000 ALTER TABLE `tbl_registuser` DISABLE KEYS */;
INSERT INTO `tbl_registuser` VALUES (1,'dojouser1@plusdojo.jp','#SEplus2025SEplus','ユーザー1','dojouser1'),(2,'dojouser2@plusdojo.jp','#SEplus2025SEplus','ユーザー2','dojouser1'),(3,'dojouser3@plusdojo.jp','#SEplus2025SEplus','ユーザー3','dojouser1'),(4,'dojouser4@plusdojo.jp','#SEplus2025SEplus','ユーザー4','dojouser2'),(5,'dojouser5@plusdojo.jp','#SEplus2025SEplus','ユーザー5','dojouser2');
/*!40000 ALTER TABLE `tbl_registuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_safestamp`
--

DROP TABLE IF EXISTS `tbl_safestamp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_safestamp` (
  `safeNumber` int NOT NULL AUTO_INCREMENT,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `familyId` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `userNumber` int DEFAULT NULL,
  PRIMARY KEY (`safeNumber`),
  KEY `familyId` (`familyId`),
  KEY `userNumber` (`userNumber`),
  CONSTRAINT `tbl_safestamp_ibfk_1` FOREIGN KEY (`familyId`) REFERENCES `tbl_registfamily` (`familyId`),
  CONSTRAINT `tbl_safestamp_ibfk_2` FOREIGN KEY (`userNumber`) REFERENCES `tbl_registuser` (`userNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_safestamp`
--

LOCK TABLES `tbl_safestamp` WRITE;
/*!40000 ALTER TABLE `tbl_safestamp` DISABLE KEYS */;
INSERT INTO `tbl_safestamp` VALUES (1,'SOS','dojouser1',1),(2,'安全です','dojouser1',2),(3,'安全です','dojouser1',3),(4,'SOS','dojouser2',4),(5,'SOS','dojouser2',5);
/*!40000 ALTER TABLE `tbl_safestamp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_stockprefood`
--

DROP TABLE IF EXISTS `tbl_stockprefood`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_stockprefood` (
  `prefoodNumber` int NOT NULL AUTO_INCREMENT,
  `prefoodName` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prefoodDate` date NOT NULL,
  `prefoodQuantity` int NOT NULL,
  `userNumber` int DEFAULT NULL,
  `checked` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`prefoodNumber`),
  KEY `userNumber` (`userNumber`),
  CONSTRAINT `tbl_stockprefood_ibfk_1` FOREIGN KEY (`userNumber`) REFERENCES `tbl_registuser` (`userNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_stockprefood`
--

LOCK TABLES `tbl_stockprefood` WRITE;
/*!40000 ALTER TABLE `tbl_stockprefood` DISABLE KEYS */;
INSERT INTO `tbl_stockprefood` VALUES (1,'乾パン','2027-06-10',2,1,0),(2,'水','2030-10-10',5,1,0),(3,'備蓄米','2028-09-30',2,1,0),(4,'メールテスト','2025-07-01',2,1,0),(5,'乾パン','2027-06-10',2,2,0),(6,'水','2030-10-10',5,2,0),(7,'備蓄米','2028-09-30',2,2,0),(8,'メールテスト','2025-07-01',2,2,0),(9,'乾パン','2027-06-10',2,3,0),(10,'水','2030-10-10',5,3,0),(11,'備蓄米','2028-09-30',2,3,0),(12,'メールテスト','2025-07-01',2,3,0),(13,'乾パン','2027-06-10',2,4,0),(14,'水','2030-10-10',5,4,0),(15,'備蓄米','2028-09-30',2,4,0),(16,'メールテスト','2025-07-01',2,4,0),(17,'乾パン','2027-06-10',2,5,0),(18,'水','2030-10-10',5,5,0),(19,'備蓄米','2028-09-30',2,5,0),(20,'メールテスト','2025-07-01',2,5,0);
/*!40000 ALTER TABLE `tbl_stockprefood` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-27 11:46:26
