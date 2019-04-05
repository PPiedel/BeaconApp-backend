INSERT INTO place(id, description, name, place_type) VALUES (1,'Schody ruchome znajdujące się w metrze','Schody Metro Świętokrzyska', 'DANGER');
INSERT INTO place(id, description, name, place_type) VALUES (2,'Schody ruchome znajdujące się w metrze','Schody Metro Politechnika', 'DANGER');
INSERT INTO place(id, description, name, place_type) VALUES (3,'Bramki biletowe','Bramki biletowe Metro Politechnika', 'DANGER');
INSERT INTO place(id, description, name, place_type) VALUES (4,'Winda znajdująca się po wschodniej ścianie Blue City','Winda Blue City', 'DANGER');

INSERT INTO beacon(mac_address, name, place_id, calibrated_strength, environmental_constant) VALUES ('D0:F0:18:43:E5:78', 'Beacon 1', 1, -65.788, 1.7);
INSERT INTO beacon(mac_address, name, place_id, calibrated_strength, environmental_constant) VALUES ('D0:F0:18:43:E6:B8', 'Beacon 4', 4, -67.74, 1.7);
INSERT INTO beacon(mac_address, name, place_id, calibrated_strength, environmental_constant) VALUES ('D0:F0:18:43:E6:B1', 'Beacon 3', 3, -65.54, 1.7);
INSERT INTO beacon(mac_address, name, place_id, calibrated_strength, environmental_constant) VALUES ('D0:F0:18:43:E5:71', 'Beacon 2', 2, -64.82, 1.7);
