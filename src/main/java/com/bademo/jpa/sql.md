### sqlFile

> table = `s_qtck`

```sql
DROP TABLE IF EXISTS `s_qtck`;
 CREATE TABLE `s_qtck` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `paper` char(15) DEFAULT NULL,
   `pcid` int(11) DEFAULT NULL,
   `kcid` int(11) DEFAULT NULL,
   `price` decimal(18,2) DEFAULT NULL,
   `number` decimal(18,2) DEFAULT NULL,
   `date` datetime DEFAULT NULL,
   `note` varchar(100) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 ```