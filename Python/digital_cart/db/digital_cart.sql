-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 25, 2020 at 10:58 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `digital_cart`
--

-- --------------------------------------------------------

--
-- Table structure for table `auth_group`
--

CREATE TABLE IF NOT EXISTS `auth_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `auth_group_permissions`
--

CREATE TABLE IF NOT EXISTS `auth_group_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_group_permissions_group_id_permission_id_0cd325b0_uniq` (`group_id`,`permission_id`),
  KEY `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `auth_permission`
--

CREATE TABLE IF NOT EXISTS `auth_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_permission_content_type_id_codename_01ab375a_uniq` (`content_type_id`,`codename`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `auth_permission`
--

INSERT INTO `auth_permission` (`id`, `name`, `content_type_id`, `codename`) VALUES
(1, 'Can add log entry', 1, 'add_logentry'),
(2, 'Can change log entry', 1, 'change_logentry'),
(3, 'Can delete log entry', 1, 'delete_logentry'),
(4, 'Can view log entry', 1, 'view_logentry'),
(5, 'Can add permission', 2, 'add_permission'),
(6, 'Can change permission', 2, 'change_permission'),
(7, 'Can delete permission', 2, 'delete_permission'),
(8, 'Can view permission', 2, 'view_permission'),
(9, 'Can add group', 3, 'add_group'),
(10, 'Can change group', 3, 'change_group'),
(11, 'Can delete group', 3, 'delete_group'),
(12, 'Can view group', 3, 'view_group'),
(13, 'Can add user', 4, 'add_user'),
(14, 'Can change user', 4, 'change_user'),
(15, 'Can delete user', 4, 'delete_user'),
(16, 'Can view user', 4, 'view_user'),
(17, 'Can add content type', 5, 'add_contenttype'),
(18, 'Can change content type', 5, 'change_contenttype'),
(19, 'Can delete content type', 5, 'delete_contenttype'),
(20, 'Can view content type', 5, 'view_contenttype'),
(21, 'Can add session', 6, 'add_session'),
(22, 'Can change session', 6, 'change_session'),
(23, 'Can delete session', 6, 'delete_session'),
(24, 'Can view session', 6, 'view_session');

-- --------------------------------------------------------

--
-- Table structure for table `auth_user`
--

CREATE TABLE IF NOT EXISTS `auth_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(128) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `email` varchar(254) NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `auth_user_groups`
--

CREATE TABLE IF NOT EXISTS `auth_user_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_user_groups_user_id_group_id_94350c0c_uniq` (`user_id`,`group_id`),
  KEY `auth_user_groups_group_id_97559544_fk_auth_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `auth_user_user_permissions`
--

CREATE TABLE IF NOT EXISTS `auth_user_user_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_user_user_permissions_user_id_permission_id_14a6b632_uniq` (`user_id`,`permission_id`),
  KEY `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bill_details`
--

CREATE TABLE IF NOT EXISTS `bill_details` (
  `b_id` int(10) NOT NULL AUTO_INCREMENT,
  `trolley_id` int(20) NOT NULL,
  `pr_id` int(20) NOT NULL,
  `date` varchar(100) NOT NULL,
  `time` varchar(50) NOT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `bill_details`
--

INSERT INTO `bill_details` (`b_id`, `trolley_id`, `pr_id`, `date`, `time`) VALUES
(1, 1, 1, '12-12-2019', '2:pm'),
(2, 1, 2, '12-12-2019', '2:pm');

-- --------------------------------------------------------

--
-- Table structure for table `complaint_and_give_reply`
--

CREATE TABLE IF NOT EXISTS `complaint_and_give_reply` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `v_id` int(10) NOT NULL,
  `complaint` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `reply` varchar(50) NOT NULL DEFAULT 'pending',
  `status` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `complaint_and_give_reply`
--

INSERT INTO `complaint_and_give_reply` (`id`, `v_id`, `complaint`, `date`, `reply`, `status`) VALUES
(1, 5, 'very poor', '2020-01-15', 'sdfds', 'pending'),
(2, 5, 'sdgfff', '2020-01-23', 'dfgdfg', 'pending'),
(3, 5, 'dfffg', '2020-01-15', 'pending', 'pending'),
(4, 5, 'dfffg', '2020-01-16', 'pending', 'pending'),
(5, 5, 'fereftr4tg54', '2020-01-09', 'pending', 'pending'),
(6, 5, 'fdfgd', '2020-01-23', 'pending', 'pending'),
(7, 7, 'gfhdgsfh', '2020-01-16', 'pending', 'pending'),
(8, 1, 'sadsa', '2020-01-17', 'pending', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email_id` varchar(20) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cid`, `name`, `address`, `phone`, `email_id`) VALUES
(1, 'Shafna', 'Kalamsekharath', '3h', 'j'),
(2, 'd', 'bg', '1245', 'frt'),
(3, 'fghfg', 'hfgf', 'hgf', ''),
(4, 'fghfg', 'hfgf', 'hgf', ''),
(5, 'fghfg', 'hfgf', 'hgf', ''),
(6, 'sd', 'asd', '1', 'dd'),
(7, 'anu', 'dfghdsg', '8862347828', 'anu123@gmail.com'),
(8, 'anu', 'dfghdsg', '3254356554', 'anu123@gmail.com'),
(9, 'anu', 'dfghdsg', '3254356554', 'anu123@gmail.com'),
(10, 'anu', 'dfghdsg', '3254356554', 'anu123@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `django_admin_log`
--

CREATE TABLE IF NOT EXISTS `django_admin_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext,
  `object_repr` varchar(200) NOT NULL,
  `action_flag` smallint(5) unsigned NOT NULL,
  `change_message` longtext NOT NULL,
  `content_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `django_admin_log_content_type_id_c4bce8eb_fk_django_co` (`content_type_id`),
  KEY `django_admin_log_user_id_c564eba6_fk_auth_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `django_content_type`
--

CREATE TABLE IF NOT EXISTS `django_content_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `django_content_type_app_label_model_76bd3d3b_uniq` (`app_label`,`model`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `django_content_type`
--

INSERT INTO `django_content_type` (`id`, `app_label`, `model`) VALUES
(1, 'admin', 'logentry'),
(3, 'auth', 'group'),
(2, 'auth', 'permission'),
(4, 'auth', 'user'),
(5, 'contenttypes', 'contenttype'),
(6, 'sessions', 'session');

-- --------------------------------------------------------

--
-- Table structure for table `django_migrations`
--

CREATE TABLE IF NOT EXISTS `django_migrations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `applied` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `django_migrations`
--

INSERT INTO `django_migrations` (`id`, `app`, `name`, `applied`) VALUES
(1, 'contenttypes', '0001_initial', '2020-01-15 07:03:07.928505'),
(2, 'auth', '0001_initial', '2020-01-15 07:03:09.428459'),
(3, 'admin', '0001_initial', '2020-01-15 07:03:13.803331'),
(4, 'admin', '0002_logentry_remove_auto_add', '2020-01-15 07:03:14.865802'),
(5, 'admin', '0003_logentry_add_action_flag_choices', '2020-01-15 07:03:14.912675'),
(6, 'contenttypes', '0002_remove_content_type_name', '2020-01-15 07:03:15.772028'),
(7, 'auth', '0002_alter_permission_name_max_length', '2020-01-15 07:03:16.475128'),
(8, 'auth', '0003_alter_user_email_max_length', '2020-01-15 07:03:17.490722'),
(9, 'auth', '0004_alter_user_username_opts', '2020-01-15 07:03:17.631340'),
(10, 'auth', '0005_alter_user_last_login_null', '2020-01-15 07:03:18.084452'),
(11, 'auth', '0006_require_contenttypes_0002', '2020-01-15 07:03:18.115700'),
(12, 'auth', '0007_alter_validators_add_error_messages', '2020-01-15 07:03:18.146949'),
(13, 'auth', '0008_alter_user_username_max_length', '2020-01-15 07:03:18.725063'),
(14, 'auth', '0009_alter_user_last_name_max_length', '2020-01-15 07:03:19.256292'),
(15, 'auth', '0010_alter_group_name_max_length', '2020-01-15 07:03:19.818780'),
(16, 'auth', '0011_update_proxy_permissions', '2020-01-15 07:03:19.865656'),
(17, 'sessions', '0001_initial', '2020-01-15 07:03:20.131271');

-- --------------------------------------------------------

--
-- Table structure for table `django_session`
--

CREATE TABLE IF NOT EXISTS `django_session` (
  `session_key` varchar(40) NOT NULL,
  `session_data` longtext NOT NULL,
  `expire_date` datetime(6) NOT NULL,
  PRIMARY KEY (`session_key`),
  KEY `django_session_expire_date_a5c62663` (`expire_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `django_session`
--

INSERT INTO `django_session` (`session_key`, `session_data`, `expire_date`) VALUES
('re4au0k05dq1jt5tjawujajv9ba27qu7', 'NGEzZDA1NjhkM2ZjYTk1Zjk2ZWQ2ZDcyNWI2ZWU3YTEzZGMzZWQ2MDp7ImV4IjoianMifQ==', '2020-02-08 09:44:40.378202');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `v_id` int(10) NOT NULL,
  `feedback` varchar(50) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `v_id`, `feedback`, `date`) VALUES
(2, 5, 'sfdsd', '0000-00-00'),
(3, 5, 'fghtrtjmu', '0000-00-00'),
(4, 7, 'very bad', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(10) NOT NULL,
  `lid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `user_name`, `password`, `type`, `lid`) VALUES
(1, 'admin@gmail.com', 'admin123', 'admin', 1),
(2, '', 'fgh', 'customer', 0),
(3, '', 'fgh', 'customer', 5),
(4, '', 'fgh', 'customer', 6),
(5, 'dd', 'dd', 'customer', 7),
(6, 'staff', 'staff', 'staff', 1),
(7, 'anu123@gmail.com', '12345678', 'customer', 8),
(8, 'anu123@gmail.com', '12345678', 'customer', 9),
(9, 'anu123@gmail.com', '12345678435', 'customer', 10),
(10, 'anu123@gmail.com', '1234', 'customer', 11);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `pr_id` int(10) NOT NULL AUTO_INCREMENT,
  `p_id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `price` varchar(20) NOT NULL,
  `quantity` varchar(50) NOT NULL,
  PRIMARY KEY (`pr_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pr_id`, `p_id`, `name`, `description`, `price`, `quantity`) VALUES
(1, 1, 'salt', 'dfhgh', '5', '89'),
(2, 2, 'nirma', 'dsgfgh', '10', '20'),
(3, 1, 'retgret', 'etre', '34', '4343'),
(4, 2, 'retet', 'retre', '435', '324'),
(5, 1, 'retet', 'retre', '435', '324'),
(6, 1, 'nirma', 'gghjj', '23', '20');

-- --------------------------------------------------------

--
-- Table structure for table `product_type`
--

CREATE TABLE IF NOT EXISTS `product_type` (
  `p_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_type` varchar(50) NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `product_type`
--

INSERT INTO `product_type` (`p_id`, `product_type`) VALUES
(1, 'soap'),
(2, 'pen');

-- --------------------------------------------------------

--
-- Table structure for table `sales_report`
--

CREATE TABLE IF NOT EXISTS `sales_report` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `number_of_purchase` int(10) NOT NULL,
  `profit` int(20) NOT NULL,
  `date` varchar(10) NOT NULL,
  `loss` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `sales_report`
--

INSERT INTO `sales_report` (`id`, `number_of_purchase`, `profit`, `date`, `loss`) VALUES
(1, 15, 3456, '12/1/19', 1000),
(3, 0, 0, '', 0),
(4, 50, 15000, '11/12/19', 100),
(5, 12, 2144, '10', 12423);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`sid`, `name`, `gender`, `address`, `phone`, `mail`, `password`) VALUES
(1, 'manu', 'male', 'sgfs', '35632', 'staff', 'staff'),
(2, 'sdsf', 'Male', 'sfds', '5555', 'sdfsd', 'sdf'),
(3, 'sdfsdf', 'Male', 'dsf', '54643', 'fvdgd', 'fgdfg'),
(4, 'ranjith', 'Male', 'rerreg', '1234567891', 'ranjith@gmail.com', 'qwert123'),
(5, 'qwertu', 'Male', 'asfd', '1234567891', 'ranjith@gmail.com', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `trolley_registration`
--

CREATE TABLE IF NOT EXISTS `trolley_registration` (
  `trolley_id` int(10) NOT NULL AUTO_INCREMENT,
  `trolley_no` int(20) NOT NULL,
  PRIMARY KEY (`trolley_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `trolley_registration`
--

INSERT INTO `trolley_registration` (`trolley_id`, `trolley_no`) VALUES
(1, 123),
(2, 4048);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `auth_group_permissions`
--
ALTER TABLE `auth_group_permissions`
  ADD CONSTRAINT `auth_group_permissions_group_id_b120cbf9_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`),
  ADD CONSTRAINT `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`);

--
-- Constraints for table `auth_permission`
--
ALTER TABLE `auth_permission`
  ADD CONSTRAINT `auth_permission_content_type_id_2f476e4b_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`);

--
-- Constraints for table `auth_user_groups`
--
ALTER TABLE `auth_user_groups`
  ADD CONSTRAINT `auth_user_groups_group_id_97559544_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`),
  ADD CONSTRAINT `auth_user_groups_user_id_6a12ed8b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`);

--
-- Constraints for table `auth_user_user_permissions`
--
ALTER TABLE `auth_user_user_permissions`
  ADD CONSTRAINT `auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`),
  ADD CONSTRAINT `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`);

--
-- Constraints for table `django_admin_log`
--
ALTER TABLE `django_admin_log`
  ADD CONSTRAINT `django_admin_log_content_type_id_c4bce8eb_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`),
  ADD CONSTRAINT `django_admin_log_user_id_c564eba6_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
