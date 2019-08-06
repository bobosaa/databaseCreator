create user datagod with password 'datagodrules';
create database test_database owner datagod encoding = 'UTF-8' lc_collate = 'en_US.utf8' lc_ctype = 'en_US.utf8';
grant all privileges on database test_database to datagod;