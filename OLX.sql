create schema OLX;
USE `OLX`;

CREATE TABLE IF NOT EXISTS `User` (
  `id` int  auto_increment primary key,
  `name` varchar(50) NOT NULL unique,
  `password` varchar(50) NOT NULL ,
  `email` varchar(25) NOT NULL ,
  `phone` int NOT NULL ,
  `address` varchar(100) NOT NULL ,
  `city` varchar(25) NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `Category` (
	`id` int auto_increment primary key,
  `name` varchar(50) Not NULL unique
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Product` (
  `id` int auto_increment primary key,
  `name` int ,
  `date` datetime ,
  `price` double,
  `categ_id` int,
  `descreption` varchar(300),
  `user_id` int,
  `image` varchar(300),
  `status` varchar(10)
);
  alter table `Product` Add CONSTRAINT `FK_product_User` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);
ALTER TABLE `Product` ADD CONSTRAINT `FK_Product_categ`  FOREIGN KEY (`categ_id`) REFERENCES `category` (`id`);
insert into `Category` (name) values('Clothes');
insert into `Category` (name) values('Phones&Accessories');
insert into `Category` (name) values('Bag&shoes');
insert into `Category` (name) values('Car');
