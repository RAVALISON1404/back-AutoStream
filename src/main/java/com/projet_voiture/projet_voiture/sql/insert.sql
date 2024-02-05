INSERT INTO categorie (nomcategorie) 
VALUES 
('Sport'), 
('Famille'), 
('Compacte'), 
('4x4'), 
('electrique');

INSERT INTO continent (nomcontinent) 
VALUES 
('Amerique du Nord'), 
('Amerique du Sud'), 
('Europe'), 
('Asie'), 
('Afrique'), 
('Oceanie'), 
('Antarctique');

INSERT INTO marque (nommarque, idcontinent, photo) 
VALUES 
('Acura', 2, 'zertyu'), -- Amerique du Nord
('Aston Martin', 2, 'qsdfg'), -- Amerique du Nord
('Audi', 2, 'qsdfg'), -- Amerique du Nord
('Bentley', 2, 'qsdfg'), -- Amerique du Nord
('BMW', 2, 'qsdfg'), -- Amerique du Nord
('Buick', 2, 'qsdfg'), -- Amerique du Nord
('Cadillac', 2, 'qsdfg'), -- Amerique du Nord
('Chevrolet', 2, 'qsdfg'), -- Amerique du Nord
('Chrysler', 2, 'qsdfg'), -- Amerique du Nord
('Dodge', 2, 'qsdfg'), -- Amerique du Nord
('Ferrari', 2, 'qsdfg'), -- Amerique du Nord
('Fiat', 3, 'qsdfg'), -- Europe
('Ford', 2, 'qsdfg'), -- Amerique du Nord
('GMC', 2, 'qsdfg'), -- Amerique du Nord
('Honda', 2, 'qsdfg'), -- Asie
('Hyundai', 3, 'qsdfg'), -- Asie
('Infiniti', 2, 'qsdfg'), -- Amerique du Nord
('Jaguar', 3, 'qsdfg'), -- Europe
('Jeep', 2, 'qsdfg'), -- Amerique du Nord
('Kia', 3, 'qsdfg'), -- Asie
('Lamborghini', 3, 'qsdfg'), -- Europe
('Land Rover', 3, 'qsdfg'), -- Europe
('Lexus', 2, 'qsdfg'), -- Amerique du Nord
('Lincoln', 2, 'qsdfg'), -- Amerique du Nord
('Lotus', 3, 'qsdfg'), -- Europe
('Maserati', 3, 'qsdfg'), -- Europe
('Mazda', 3, 'qsdfg'), -- Asie
('Mercedes Benz', 3, 'qsdfg'), -- Europe
('Mini', 3, 'qsdfg'), -- Europe
('Mitsubishi', 3, 'qsdfg'), -- Asie
('Nissan', 3, 'qsdfg'), -- Asie
('Porsche', 3, 'qsdfg'), -- Europe
('Ram Trucks', 2, 'qsdfg'), -- Amerique du Nord
('Rolls Royce', 3, 'qsdfg'), -- Europe
('Smart', 3, 'qsdfg'), -- Europe
('Subaru', 3, 'qsdfg'), -- Asie
('Tesla', 2, 'qsdfg'), -- Amerique du Nord
('Toyota', 3, 'qsdfg'), -- Asie
('Volkswagen', 3, 'qsdfg'), -- Europe
('Volvo', 3, 'qsdfg'); -- Europe

INSERT INTO energie (nomenergie) 
VALUES 
('Essence'), 
('Diesel'), 
('Bio-diesel'), 
('Ethanol'), 
('Gaz naturel'), 
('electrique');

INSERT INTO carrosserie (nomcarrosserie) 
VALUES 
('Berline'), 
('Break'), 
('SUV'), 
('Coupe'), 
('Cabriolet'), 
('Roadster'), 
('Monospace');

INSERT INTO transmission (nomtransmission) 
VALUES 
('Manuelle'), 
('Automatique'), 
('Semi-automatique'), 
('Continu variable');

INSERT INTO drivetype (nomdrivetype) 
VALUES 
('Avant'), 
('Arriere'), 
('Integrale');

INSERT INTO conduite (nomconduite) 
VALUES 
('Conduite a droite'), 
('Conduite a gauche');

INSERT INTO type (nomtype) 
VALUES 
('Interieur'), 
('Exterieur');

INSERT INTO commission (valeur, date)
VALUES
(30, '2023-01-01');

INSERT into options VALUES
(1,'Airbags', 1),
(2,'Systeme de navigation', 1),
(3,'Camera de recul', 1), 
(4,'Freins ABS', 1) ,
(5,'Toit ouvrant', 2) ,
(6,'Systeme audio haut de gamme', 2) ,
(7,'Systeme de climatisation automatique', 2) ,
(8,'Sieges en cuir', 2) ,
(9,'Systeme de freinage d''urgence', 1) ,
(10,'Systeme de surveillance de la pression des pneus', 1) ,
(11,'Systeme de contrôle de la stabilite', 1) ,
(12,'Systeme de securite actif', 1);
