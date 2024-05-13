insert  into `drzava`(`drzavaID`,`naziv`) values 
(1,'Srbija'),
(2,'Grcka'),
(5,'Spanija'),
(8,'Ex-yu');

insert  into `grad`(`gradID`,`drzavaID`,`naziv`) values 
(2,1,'Novi Sad'),
(5,1,'Kragujevac');

insert  into `tim`(`timID`,`naziv`,`gradId`,`drzavaID`) values 
(1,'Vojvodina MTS',2,1),
(4,'SPD Radnicki',5,1);

insert  into `igraci`(`igracId`,`ime`,`prezime`,`broj`,`datum`,`visina`,`pozicija`,`drzavaId`,`timId`) values 
(4,'Luka','Cerovina',3,'2001-04-15',201,'PG',2,1),
(7,'Boban','Todic',3,'2024-04-21',195,'C',8,1),
(8,'Boban','Todic',4,'2002-04-21',195,'PF',5,4);