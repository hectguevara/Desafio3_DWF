-- Inserciones de razas en la Federación Nebulon
INSERT INTO razas (nombre, planeta_origen, nivel_tecnologico, poblacion_total, descripcion) 
VALUES 
('Vulcanos', 'Vulcano', 9, 10000000, 'Raza alienígena altamente lógica y tecnológicamente avanzada'),
('Xendridianos', 'Xendrix Prime', 92, 800000000, 'Raza antigua de comerciantes espaciales, expertos en navegación interestelar y diplomacia comercial'),
('Krolosianos', 'Krolos', 88, 500000000, 'Especie guerrera pero honorable, destacados en ingeniería y construcción de naves espaciales'),
('Mindarianos', 'Mindara', 97, 300000000, 'Seres telepáticos especializados en tecnología de comunicaciones y procesamiento de datos'),
('Aquarianos', 'Aquarius IV', 91, 400000000, 'Raza anfibia experta en biotecnología y medicina avanzada'),
('Humanos', 'Tierra', 95, 1500000000, 'Especie dominante en la Federación Nebulón, originaria de la Tierra. Conocidos por su adaptabilidad y avances tecnológicos');

-- Tabla de especialidades comerciales por raza
INSERT INTO especialidades_comerciales (raza_id, especialidad, nivel_expertise)
VALUES 
(1, 'Tecnología de IA', 95),
(2, 'Comercio Interestelar', 98),
(3, 'Ingeniería Espacial', 94),
(4, 'Tecnología de Comunicaciones', 96),
(5, 'Biotecnología', 97); 