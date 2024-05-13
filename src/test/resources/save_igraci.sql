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

