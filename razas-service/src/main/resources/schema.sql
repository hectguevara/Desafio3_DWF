-- Tabla de razas
CREATE TABLE IF NOT EXISTS razas (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    nivel_tecnologico INTEGER NOT NULL,
    poblacion_total BIGINT NOT NULL,
    planeta_origen VARCHAR(100) NOT NULL
);

-- Tabla de especialidades comerciales
CREATE TABLE IF NOT EXISTS especialidades_comerciales (
    id BIGINT PRIMARY KEY,
    raza_id BIGINT NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    nivel_expertise INTEGER NOT NULL,
    FOREIGN KEY (raza_id) REFERENCES razas(id)
); 