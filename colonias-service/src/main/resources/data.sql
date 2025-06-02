-- Inserciones de colonias en la Federación Nebulon
INSERT INTO colonias (
    nombre, 
    coordenada_x, 
    coordenada_y, 
    coordenada_z, 
    poblacion, 
    recursos_naturales, 
    tecnologia, 
    alianzas_politicas, 
    activa
) VALUES 
('Nueva Terra', 123.45, 67.89, 10.11, 5000000, 'Minerales raros, Cristales energéticos', 'Tecnología de fusión avanzada', 'Alianza con Xendridianos', true),
('Puerto Estelar Xendrix', 234.56, 78.90, 12.13, 3000000, 'Metales preciosos, Gases nobles', 'Tecnología de teletransporte', 'Pacto comercial con Humanos', true),
('Fortaleza Krolos', 345.67, 89.01, 14.15, 2000000, 'Minerales pesados, Cristales de poder', 'Tecnología militar avanzada', 'Alianza defensiva con Mindarianos', true),
('Ciudad Mindara', 456.78, 90.12, 16.17, 1500000, 'Cristales psíquicos, Minerales raros', 'Tecnología psiónica', 'Tratado de paz con Aquarianos', true),
('Oasis Aquariano', 567.89, 01.23, 18.19, 2500000, 'Recursos marinos, Cristales acuáticos', 'Biotecnología marina', 'Cooperación científica con Humanos', true);

-- Rutas comerciales entre colonias
INSERT INTO rutas_comerciales (id, colonia_origen_id, colonia_destino_id, tipo_comercio, volumen_mensual)
VALUES 
(1, 1, 2, 'Tecnología y Minerales', 1000000),
(2, 2, 3, 'Suministros y Armamento', 800000),
(3, 3, 4, 'Materiales de Construcción', 600000),
(4, 4, 5, 'Tecnología de Comunicaciones', 750000),
(5, 5, 1, 'Suministros Médicos', 900000);

-- Recursos específicos por colonia
INSERT INTO recursos_colonia (id, colonia_id, recurso, cantidad_mensual, valor_comercial)
VALUES 
(1, 1, 'Cristales de Neutrio', 5000, 1000000),
(2, 2, 'Aleaciones Espaciales', 8000, 1200000),
(3, 3, 'Núcleos de Energía', 3000, 1500000),
(4, 4, 'Procesadores Cuánticos', 2000, 2000000),
(5, 5, 'Compuestos Medicinales', 6000, 900000);

-- Acuerdos comerciales entre colonias
INSERT INTO acuerdos_comerciales (id, colonia_origen_id, colonia_destino_id, tipo_acuerdo, fecha_inicio, duracion_meses)
VALUES 
(1, 1, 2, 'Tratado de Libre Comercio', '2157-01-01', 60),
(2, 2, 3, 'Pacto de Suministros Estratégicos', '2157-02-15', 48),
(3, 3, 4, 'Alianza Tecnológica', '2157-03-30', 36),
(4, 4, 5, 'Acuerdo de Intercambio Científico', '2157-04-15', 24),
(5, 5, 1, 'Convenio Médico-Tecnológico', '2157-05-01', 36); 