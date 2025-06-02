-- Tabla de colonias
DROP TABLE IF EXISTS colonias CASCADE;
CREATE TABLE colonias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    coordenada_x DOUBLE,
    coordenada_y DOUBLE,
    coordenada_z DOUBLE,
    poblacion INTEGER,
    recursos_naturales TEXT,
    tecnologia VARCHAR(255),
    alianzas_politicas TEXT,
    activa BOOLEAN DEFAULT true
);

-- Tabla de rutas comerciales
CREATE TABLE IF NOT EXISTS rutas_comerciales (
    id BIGINT PRIMARY KEY,
    colonia_origen_id BIGINT NOT NULL,
    colonia_destino_id BIGINT NOT NULL,
    tipo_comercio VARCHAR(100) NOT NULL,
    volumen_mensual BIGINT NOT NULL,
    FOREIGN KEY (colonia_origen_id) REFERENCES colonias(id),
    FOREIGN KEY (colonia_destino_id) REFERENCES colonias(id)
);

-- Tabla de recursos por colonia
CREATE TABLE IF NOT EXISTS recursos_colonia (
    id BIGINT PRIMARY KEY,
    colonia_id BIGINT NOT NULL,
    recurso VARCHAR(100) NOT NULL,
    cantidad_mensual INTEGER NOT NULL,
    valor_comercial BIGINT NOT NULL,
    FOREIGN KEY (colonia_id) REFERENCES colonias(id)
);

-- Tabla de acuerdos comerciales
CREATE TABLE IF NOT EXISTS acuerdos_comerciales (
    id BIGINT PRIMARY KEY,
    colonia_origen_id BIGINT NOT NULL,
    colonia_destino_id BIGINT NOT NULL,
    tipo_acuerdo VARCHAR(100) NOT NULL,
    fecha_inicio DATE NOT NULL,
    duracion_meses INTEGER NOT NULL,
    FOREIGN KEY (colonia_origen_id) REFERENCES colonias(id),
    FOREIGN KEY (colonia_destino_id) REFERENCES colonias(id)
); 