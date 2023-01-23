CREATE SCHEMA if not exists dronesdb Authorization sa;


Create table drone (serial_number varchar(50) primary key  , model varchar(50) ,weight_limit int , battery_capacity int ,state varchar(50) );
Create table medication (code varchar(50) primary key , name varchar(50) , weight int , image varchar(50) );
Create table loaded_medication_item( LOAD_MED_ITEM_ID int AUTO_INCREMENT primary key,code varchar(50) ,  serial_number varchar(50) )