-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: i6b104.p.ssafy.io    Database: azit
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `group_status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone_num` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sign_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('',NULL,'',NULL,NULL,'',NULL,'',NULL,'2022-02-17 11:57:00.298000'),('coach',NULL,'coach@coach.com',NULL,NULL,'1',NULL,'coachcoach',NULL,'2022-02-16 01:16:03.603000'),('ej08',NULL,'ej08@ssafy.com',NULL,NULL,'오은진',NULL,'eunjin123',NULL,'2022-02-16 05:04:29.385000'),('ejo',NULL,'ejo@ssafy.com',NULL,NULL,'오은진',NULL,'eunjin123',NULL,'2022-02-17 02:14:02.663000'),('gil',NULL,'gilgiho@babo.com',NULL,NULL,'길기호',NULL,'rlghqkqh1',NULL,NULL),('gilgiho',NULL,'gilgiho@babo.mhelong',NULL,NULL,'길기호',NULL,'gihobabo123',NULL,'2022-02-16 16:11:18.600000'),('gilgiho123',NULL,'gilgiho@babo.com',NULL,NULL,'길기호',NULL,'rlghqkqh1',NULL,'2022-02-16 16:05:05.365000'),('hh',NULL,'hh',NULL,NULL,'hh',NULL,'kkkkkkkkk',NULL,NULL),('hhh',NULL,'hhh',NULL,NULL,'hhh',NULL,'hhhhhhhhh',NULL,'2022-02-16 16:11:35.449000'),('jisu',NULL,'jisu@jisu.com',NULL,NULL,'jisu',NULL,'123456789',NULL,'2022-02-17 05:50:46.251000'),('jst',NULL,'jst1365',NULL,NULL,'장성태',NULL,'123456789',NULL,'2022-02-16 17:41:41.286000'),('jst1365',NULL,'sassy',NULL,NULL,'장성태',NULL,'123456789',NULL,NULL),('jstjst',NULL,'jstjstjst',NULL,NULL,'1',NULL,'jstjstjst',NULL,'2022-02-15 15:07:30.077000'),('jyg',NULL,'jyg@ssafy.com',NULL,NULL,'조용구',NULL,'123456789',NULL,'2022-02-15 14:39:30.222000'),('kgh',NULL,'kgh',NULL,NULL,'1',NULL,'kghkghkgh',NULL,'2022-02-16 01:16:22.559000'),('kkk',NULL,'kkk',NULL,NULL,'기호',NULL,'kkkkkkkkk',NULL,'2022-02-16 15:35:41.208000'),('kkkkkkkkk',NULL,'kkk',NULL,NULL,'rlgh',NULL,'kkkkkkkkk',NULL,NULL),('kyj',NULL,'sss@naver.com',NULL,NULL,'김유정',NULL,'123456789',NULL,'2022-02-17 06:24:04.049000'),('mh',NULL,'ssafy@naver.com',NULL,NULL,'1',NULL,'korea1234',NULL,NULL),('mh2',NULL,'djdj@naver.com',NULL,NULL,'1',NULL,'korea1234',NULL,'2022-02-16 05:03:14.824000'),('mh3',NULL,'mh2',NULL,NULL,'김민현',NULL,'korea1234',NULL,NULL),('mh5',NULL,'123@',NULL,NULL,'김민현',NULL,'123412341234',NULL,'2022-02-17 01:56:41.691000'),('min',NULL,'mh2@',NULL,NULL,'김민현',NULL,'korea1234',NULL,'2022-02-17 08:35:30.092000'),('muyaho',NULL,'muyaho@naver.com',NULL,NULL,'1',NULL,'123qwe!@#',NULL,'2022-02-16 09:22:37.118000'),('qwe123',NULL,'qwe123',NULL,NULL,'qwe123',NULL,'qwe123qwe123',NULL,'2022-02-17 08:09:51.482000'),('qwer',NULL,'qwer@qwer.com',NULL,NULL,'qwer',NULL,'qwer`123@',NULL,'2022-02-16 17:12:28.304000'),('qwerty',NULL,'123',NULL,NULL,'123',NULL,'111111111',NULL,'2022-02-16 16:07:07.824000'),('ssafy',NULL,'ssafy',NULL,NULL,'김싸피',NULL,'ssafytestpwd',NULL,'2022-02-16 04:13:24.881000'),('ssafytest',NULL,'ssafy@ssafy.com',NULL,NULL,'김싸피',NULL,'ssafytestpwd','','2022-02-16 05:56:02.371000'),('sss',NULL,'sss',NULL,NULL,'sss',NULL,'sssssssss',NULL,'2022-02-16 16:34:33.827000'),('test',NULL,'test@test.com',NULL,NULL,'김실험',NULL,'1q2w3e4r!',NULL,NULL),('test01@ssafy.com',NULL,'test01@ssafy.com',NULL,NULL,'test01@ssafy.com',NULL,'123123123',NULL,'2022-02-16 16:38:36.635000'),('test1',NULL,'test1@naver.com',NULL,NULL,'test1',NULL,'testtest1',NULL,'2022-02-17 11:40:04.158000'),('testjyg',NULL,'q',NULL,NULL,'1',NULL,'111111111',NULL,'2022-02-16 05:07:44.888000'),('yuj',NULL,'ss@naver.com',NULL,NULL,'김유정',NULL,'123456789',NULL,'2022-02-16 05:56:02.371000'),('yuj2',NULL,'aaa@naver.com',NULL,NULL,'유정',NULL,'123456789',NULL,NULL),('기호',NULL,'kh@naver.com',NULL,NULL,'기호',NULL,'123123123',NULL,'2022-02-17 11:51:09.652000'),('길기호',NULL,'길기호',NULL,NULL,'길기호',NULL,'123123123',NULL,'2022-02-17 08:37:56.534000');
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

-- Dump completed on 2022-02-17 21:56:30
