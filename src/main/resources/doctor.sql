CREATE DATABASE `data_explosion` /*!40100 DEFAULT CHARACTER SET utf8 */;


USE `data_explosion`;


CREATE TABLE `doctor_table` (
  `doctor_id` int(11) NOT NULL,
  `doctor_name` varchar(75) DEFAULT NULL,
  `doctor_speciality` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `data_explosion`.`doctor_table` (`doctor_id`, `doctor_name`, `doctor_speciality`) VALUES ('1', 'Deepak', 'Urologist');
INSERT INTO `data_explosion`.`doctor_table` (`doctor_id`, `doctor_name`, `doctor_speciality`) VALUES ('2', 'Naveen', 'Cosmetologist');
INSERT INTO `data_explosion`.`doctor_table` (`doctor_id`, `doctor_name`, `doctor_speciality`) VALUES ('3', 'Syed', 'Dermatologist');
INSERT INTO `data_explosion`.`doctor_table` (`doctor_id`, `doctor_name`, `doctor_speciality`) VALUES ('4', 'Thomas', 'Cardiologist');
INSERT INTO `data_explosion`.`doctor_table` (`doctor_id`, `doctor_name`, `doctor_speciality`) VALUES ('5', 'Singh', 'Physician');
