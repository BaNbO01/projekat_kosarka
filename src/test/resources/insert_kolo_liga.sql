insert  into `drzava`(`drzavaID`,`naziv`) values 
(1,"Srbija"),
(2,"Grcka");


insert  into `liga`(`ligaId`,`naziv`,`drzavaID`) values 
(1,'AdmiralBet KLS',1),
(2,'Grcka liga',2);

insert  into `kolo`(`koloId`,`ligaId`) values 
(1,1),
(2,1),
(3,1),
(1,2);


