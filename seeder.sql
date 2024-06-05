# empty the vehicles and persons tables
TRUNCATE TABLE vehicles;
TRUNCATE TABLE persons;

# fill 50 persons with random rut, name, last name
INSERT INTO persons (rut, name, lastname) VALUES
('11111111-1', 'Juan', 'Perez'),
('22222222-2', 'Pedro', 'Gonzalez'),
('33333333-3', 'Maria', 'Lopez'),
('44444444-4', 'Jose', 'Rodriguez'),
('55555555-5', 'Ana', 'Martinez'),
('66666666-6', 'Luis', 'Hernandez'),
('77777777-7', 'Carlos', 'Garcia'),
('88888888-8', 'Fernando', 'Torres'),
('99999999-9', 'Ricardo', 'Fernandez'),
('10101010-0', 'Roberto', 'Sanchez');

# now the vehicle but vehicles have a foreign key to person and the plate is 6 characters long
# and some of the vehicles are stolen, the id of the persons are the rut
INSERT INTO vehicles (plate, brand, model, year, wasStolen, person_id) VALUES
('AA1234', 'Toyota', 'Corolla', 2010, 1, '11111111-1'),
('BB1234', 'Ford', 'Fusion', 2011, 0, '22222222-2'),
('CC1234', 'Chevrolet', 'Malibu', 2012, 1, '33333333-3'),
('DD1234', 'Honda', 'Accord', 2013, 0, '44444444-4'),
('EE1234', 'Nissan', 'Altima', 2014, 1, '55555555-5'),
('FF1234', 'Volkswagen', 'Jetta', 2015, 0, '66666666-6'),
('GG1234', 'Toyota', 'Camry', 2016, 1, '77777777-7'),
('HH1234', 'BMW', '3 Series', 2017, 0, '88888888-8'),
('II1234', 'Mercedes-Benz', 'C-Class', 2018, 1, '99999999-9'),
('JJ1234', 'Audi', 'A4', 2019, 0, '10101010-0');