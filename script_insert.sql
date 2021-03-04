insert into biblio_app.categorie (id,nom,label,information_technique)values (1,'Roman','ROM','Informations à venir');
insert into biblio_app.categorie (id,nom,label,information_technique)values (2,'Bande dessinée','BD','Informations à venir');
insert into biblio_app.categorie (id,nom,label,information_technique)values (3,'Mangas','MNG','Informations à venir');
insert into biblio_app.categorie (id,nom,label,information_technique)values (4,'Encyclopédies','ROM','Informations à venir');
insert into biblio_app.categorie (id,nom,label,information_technique)values (5,'Dictionnaires ','ROM','Informations à venir');

insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('1',"Le monde s'effondre",STR_TO_DATE("1958,8,14", "%Y,%m,%d") ,'20','LMSE','2');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('1',"Orgueil et Préjugés",STR_TO_DATE("1837,7,02", "%Y,%m,%d") ,'20','OEP','3');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('1',"Fictions",STR_TO_DATE("1944,2,20", "%Y,%m,%d") ,'20','FICT','1');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('1',"Les Enfants de minuit",STR_TO_DATE("1981,2,04", "%Y,%m,%d") ,'20','LEDM','2');

insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('2',"Astérix le Gaulois",STR_TO_DATE("1959,10,29", "%Y,%m,%d") ,'15','ALG','2');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('2',"Le Fils d'Astérix",STR_TO_DATE("1983,8,14", "%Y,%m,%d") ,'15','LFDA','6');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('2',"Astérix chez Rahazade",STR_TO_DATE("1987,6,04", "%Y,%m,%d") ,'15','ACR','3');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('2',"Astérix chez les Pictes",STR_TO_DATE("2013,10,24", "%Y,%m,%d") ,'15','ACLP','1');

insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('3',"One Piece T01",STR_TO_DATE("1997,8,14", "%Y,%m,%d") ,'6.50','OP01','2');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('3',"One Piece T02",STR_TO_DATE("1998,8,14", "%Y,%m,%d") ,'6.50','OP02','3');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('3',"One Piece T03",STR_TO_DATE("1999,8,14", "%Y,%m,%d") ,'6.50','OP03','1');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('3',"One Piece T04",STR_TO_DATE("2000,8,14", "%Y,%m,%d") ,'6.50','OP04','5');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('3',"One Piece T05",STR_TO_DATE("2001,8,14", "%Y,%m,%d") ,'6.50','OP05','4');

insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('4',"Encyclopédie nouvelle",STR_TO_DATE("1841,8,04", "%Y,%m,%d") ,'30','ENCN','4');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('4',"Encyclopédie berbère",STR_TO_DATE("1984,7,18", "%Y,%m,%d") ,'30','ENCB','1');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('4',"Encyclopédia Britannica",STR_TO_DATE("1990,4,04", "%Y,%m,%d") ,'30','ENCR','6');

insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('5',"Larousse",STR_TO_DATE("2018,8,14", "%Y,%m,%d") ,'20','LAR','2');
insert into biblio_app.livre (id_categorie,titre,date_edition ,prix ,label ,stock )values ('5',"Robert",STR_TO_DATE("2020,8,14", "%Y,%m,%d") ,'20','ROB','2');
