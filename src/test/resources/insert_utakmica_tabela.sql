insert  into `drzava`(`drzavaID`,`naziv`) values 
(1,'Srbija');

insert  into `grad`(`gradID`,`drzavaID`,`naziv`) values 
(2,1,'Novi Sad'),
(5,1,'Kragujevac');

insert  into `tim`(`timID`,`naziv`,`gradId`,`drzavaID`) values 
(1,'Vojvodina MTS',2,1),
(2,'SPD Radnicki',5,1);

insert  into `liga`(`ligaId`,`naziv`,`drzavaID`) values 
(1,'AdmiralBet KLS',1);

insert  into `kolo`(`koloId`,`ligaId`) values 
(1,1);