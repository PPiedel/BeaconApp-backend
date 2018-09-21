INSERT INTO place(id, description, name, place_type) VALUES (1,'Schody ruchome znajdujące się w metrze','Schody Metro Świętokrzyska','DANGER');
INSERT INTO place(id, description, name, place_type) VALUES (2,'Schody ruchome znajdujące się w metrze','Schody Metro Politechnika','DANGER');
INSERT INTO place(id, description, name, place_type) VALUES (3,'Bramki biletowe','Bramki biletowe Metro Politechnika','DANGER');

INSERT INTO beacon(mac_adress, name, place_id) VALUES ('D0:F0:18:43:DD:65', 'Beacon 1', 1);
INSERT INTO beacon(mac_adress, name, place_id) VALUES ('D0:F0:18:43:DD:68', 'Beacon 2', 2);
INSERT INTO beacon(mac_adress, name, place_id) VALUES ('D0:F0:18:43:DD:72', 'Beacon 3', 3);