
INSERT INTO drone(serial_number, model, weight_limit, battery_capacity, state) 
VALUES ('123_abc',0,450,80,0);
INSERT INTO drone(serial_number, model, weight_limit, battery_capacity, state) 
VALUES ('123_xyz',1,450,95,2);

INSERT INTO medication(code, name, weight, image)
 VALUES ('amox','amoxicillian',250,'jjj');
INSERT INTO medication(code, name, weight, image)
 VALUES ('panado','panado',50,'bb');


INSERT INTO loaded_medication_item( code,  serial_number)
 VALUES ('amox','123_abc');
INSERT INTO loaded_medication_item( code,  serial_number)
 VALUES ('panado','123_xyz');

