-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: sms
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `stu_id` varchar(6) DEFAULT NULL,
  `roll_no` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(400) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `father_name` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `blood` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `class` varchar(10) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('47042','1','Arsha Kadam','student101','O3rfFVNx09mQZ7zlRDd19Q==:Ih/v8r+5K6MGg4hKhzgcD0OUxAadV+4t8xBDunftsIk=','student101@gmail.com','Atharv Kadam','654789321','A-','Female','Karad','16','X','1/1/2010'),('88388','1','Sharvil Gala','student81','6WsRkRW9OeYZwLDTulY//A==:ccVrmZw/rgUj1tyOust+8vxMj2TKyBzT3rV0xghYfQw=','student81@gmail.com','Manan Gala','123456789','O+','Male','Kolhapur','14','VIII','1/1/2012'),('58883','1','Praful Nahata','student91','TVOgIN2jlkf+VSaLXvrThA==:uf82gBXdIHNmUfwzzqC0nALlTiQj5Vq+pq6pAGAAaAA=','student91@gmail.com','Khush Nahata','789456123','A+','Male','Pune','15','IX','1/1/2011'),('73936','1','Nidhi Jain','studenta1','KaSPcsieCFv3Ep7N5sNqeA==:x+rKZrOqfywyKF0i+5yksj5CnLDm0NXe4glzceeaEtc=','nishi.jain@gmail.com','Taneesh Jain','124698538','O+','Female','Bangalore','18','A-LEVEL','1/1/2008'),('63390','1','Samrudhi Jawar','studentas1','KUYHwNwzHq86+9yQta+S/Q==:MN9kkc22vDf50HUjaDOMVT+hlmIcdkxdROsS2sA394U=','samrudhi.jawar@gmail.com','Shlok Jawar','124785963','A+','Female','Hydrabad','17','AS-LEVEL','1/1/2009'),('6538','1','Nidhi Munde','studentib11','BYIu46bqPjs4bwn2tZWvDA==:hruR94D9J3/52xBU3FhboVGCWG2tvpdN3lzmW24dDzc=','nidhi.munde@gmail.com','Sai Munde','456789321','O+','Female','Lathur','17','IBDP-I','1/1/2009'),('85009','1','Sidhi Gosavi','studentib21','3q4Xnj0p3UnQ3n/ZqrebpA==:YOA3KFRB8NmtgTVXZutaaWTGhPT/lVZ7JHaXu47wDAE=','sidhi.gosavi@gmail.com','Shubham K Gosavi','423651798','B+','Select Gender','Mumbai','18','IBDP-II','1/1/2008');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-17  9:00:33
