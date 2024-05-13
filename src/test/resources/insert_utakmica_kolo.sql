insert  into `drzava`(`drzavaID`,`naziv`) values 
(1,"Srbija"),
(2,'Grcka'),
(5,'Spanija'),
(8,'Ex-yu');

insert  into `grad`(`gradID`,`drzavaID`,`naziv`) values 
(2,1,'Novi Sad'),
(3,1,'Subotica'),
(4,1,'Cacak'),
(5,1,'Kragujevac');

insert  into `tim`(`timID`,`naziv`,`gradId`,`drzavaID`) values 
(1,'Vojvodina MTS',2,1),
(2,'Spartak Office Shoes',3,1),
(3,'Cacak 94 Quantox',4,1),
(4,'SPD Radnicki',5,1);


insert  into `liga`(`ligaId`,`naziv`,`drzavaID`) values 
(1,'AdmiralBet KLS',1);

insert  into `kolo`(`koloId`,`ligaId`) values 
(1,1);

insert  into `utakmica`(`utakmicaId`,`koloId`,`ligaId`,`brojKosevaTima1`,`brojKosevaTima2`,`timid1`,`timid2`) values 
(1,1,1,84,80,1,2),
(2,1,1,64,82,4,3);

insert  into `tabela`(`tabelaid`,`ligaid`,`brojpobeda`,`brojporaza`,`kosrazlika`,`timid`) values 
(1,1,1,0,4,1),
(4,1,0,1,-4,2),
(5,1,0,1,-18,4),
(6,1,1,0,18,3);

