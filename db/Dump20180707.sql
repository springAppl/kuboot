-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: luna
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Dumping data for table `article`
--
use luna;
LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (2,'java入门',NULL,'[\"java\",\"linux\"]',NULL,NULL,NULL),(3,'linxu入门',NULL,'[\"感悟\",\"随笔\"]',NULL,NULL,NULL),(4,'java入门到放弃',NULL,'[\"技术\",\"java\"]',NULL,NULL,NULL),(5,'java哈哈哈',NULL,'[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(6,'java出现',NULL,'[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(7,'spring入门到放弃','<p >spring是一个依赖注入框架</p>','[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(8,'linux入门到精通','<p >linux是世界上使用非常广泛的操作系统</p>','[\"技术\",\"linux\"]',NULL,NULL,NULL),(9,'asdf','<p >请输入内容asdfasdfasd</p>','[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(10,'asdf','<p >请输入内容asdfasdfasdf</p>','[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(11,'adfasdf',NULL,'[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(12,'linxu入门','<p >你好this is adfasdfasdfasdfasd</p>','[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(13,'java哈哈哈','<p >请输入内容asdfasdfa</p>','[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(14,'asdfasd','<p >请输入内容asdfadsf</p>','[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(15,'google',NULL,'[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(16,'高考加油','<p >又到了高考时期，很多人居然又丢了高考证</p>','[\"感悟\",\"随笔\"]',NULL,NULL,NULL),(17,'add image','<p >只是为了图片演示</p>\n<p ><br></p>\n<p ><img src=\"http://www.news.com/api/image/1\"/></p>\n<p ><br></p>\n<p ><br></p>\n<p ><br></p>\n<p ><img src=\"http://www.news.com/api/image/2\"/></p>\n<p ><br></p>','[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(18,'文件大小','<p >大图片终于上传成功了</p>\n<p ><br></p>\n<p ><img src=\"http://www.news.com/api/image/3\"/></p>\n<p ><br></p>','[\"技术\",\"产品\",\"感悟\",\"随笔\"]',NULL,NULL,NULL),(19,'新版蚂蚁','<p >新版这个</p>','[\"java\",\"spring\",\"reactjs\"]','2018-06-25 12:58:40','2018-06-25 12:58:40',11),(20,'新版蚂蚁','<p >新版这个啊啊啊</p>','[\"java\",\"spring\",\"reactjs\"]','2018-06-25 12:59:32','2018-06-25 12:59:32',11),(21,'新版蚂蚁','<p >阿斯顿发发是新版这个啊啊啊　</p>','[\"java\",\"spring\",\"reactjs\"]','2018-06-25 13:00:50','2018-06-25 13:00:50',11),(22,'java','<p >请输入内容adsfadfasd</p>','[\"java\",\"spring\",\"reactjs\"]','2018-07-05 14:25:55','2018-07-05 14:25:55',8),(23,'阿斯佳的','<p >请输入内容thor</p>','[\"java\",\"spring\",\"reactjs\"]','2018-07-05 17:39:20','2018-07-05 17:39:20',8);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (8,'liu','123456','123456','[\"ADMIN\"]'),(9,'neo','123456','123456',NULL),(10,'lee','123456','123456',NULL),(11,'linus','123',NULL,NULL);
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

-- Dump completed on 2018-07-07 15:39:26
