create database biblio_app;
create user 'bibli'@'localhost' identified by 'biblipwd';
grant all privileges on biblio_app.* to 'bibli'@'localhost';
use biblio_app;