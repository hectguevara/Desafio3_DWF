-- Inserciones de razas en la Federación Nebulon
INSERT INTO razas (id, nombre, descripcion, nivel_tecnologico, poblacion_total, planeta_origen) 
VALUES 
(1, 'Humanos', 'Especie dominante en la Federación Nebulon, originaria de la Tierra. Conocidos por su adaptabilidad y avances tecnológicos.', 95, 15000000000, 'Tierra'),
(2, 'Xendridianos', 'Raza antigua de comerciantes espaciales, expertos en navegación interestelar y diplomacia comercial.', 92, 8000000000, 'Xendrix Prime'),
(3, 'Krolosianos', 'Especie guerrera pero honorable, destacados en ingeniería y construcción de naves espaciales.', 88, 5000000000, 'Krolos'),
(4, 'Mindarianos', 'Seres telepáticos especializados en tecnología de comunicaciones y procesamiento de datos.', 97, 3000000000, 'Mindara'),
(5, 'Aquarianos', 'Raza anfibia experta en biotecnología y medicina avanzada.', 91, 4000000000, 'Aquarius IV');

-- Tabla de especialidades comerciales por raza
INSERT INTO especialidades_comerciales (id, raza_id, especialidad, nivel_expertise)
VALUES 
(1, 1, 'Tecnología de IA', 95),
(2, 2, 'Comercio Interestelar', 98),
(3, 3, 'Ingeniería Espacial', 94),
(4, 4, 'Tecnología de Comunicaciones', 96),
(5, 5, 'Biotecnología', 97); 