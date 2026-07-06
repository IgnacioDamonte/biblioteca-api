# 📚 Biblioteca API

Sistema de gestión de biblioteca desarrollado como proyecto de **Prácticas Profesionales** — Tecnicatura en Programación, Teclab.

API REST completa para la administración de libros, autores y préstamos, con frontend integrado responsive (compatible con escritorio y dispositivos móviles).

---

## 🛠️ Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3.5.0**
- **Spring Data JPA**
- **H2 Database** (en memoria)
- **Lombok**
- **Maven**
- HTML / CSS / JavaScript para el frontend

---

## ✨ Funcionalidades

- CRUD completo de **Autores**, **Libros** y **Préstamos**
- Relaciones entre entidades (`@OneToMany` / `@ManyToOne`)
- Validaciones de campos obligatorios (backend y frontend)
- Manejo global de excepciones
- Datos de prueba precargados automáticamente al iniciar
- Frontend responsive: vista de tablas en escritorio y tarjetas en celular
- Indicador de disponibilidad de libros (disponible / prestado)
- Contador de libros por autor
- Filtro de préstamos por estado (Activos / Devueltos)
- Botón de devolución rápida de préstamos
- Modal de confirmación antes de eliminar registros
- Notificaciones visuales (toasts) de éxito y error

---

## 📁 Estructura del proyecto

```
biblioteca-api/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/facultad/biblioteca/
    │   │   ├── BibliotecaApplication.java
    │   │   ├── model/         → Autor, Libro, Prestamo
    │   │   ├── repository/    → Interfaces JpaRepository
    │   │   ├── service/       → Lógica de negocio
    │   │   ├── controller/    → Endpoints REST
    │   │   ├── exception/     → Manejo global de errores
    │   │   └── config/        → CORS y carga de datos iniciales
    │   └── resources/
    │       ├── application.properties
    │       └── static/index.html   → Frontend SPA
    └── test/
```

---

## 🌐 Endpoints disponibles

### Autores
| Método | Endpoint | Descripción |
|--------|----------|--------------|
| GET | `/api/autores` | Listar todos los autores |
| GET | `/api/autores/{id}` | Obtener autor por ID |
| POST | `/api/autores` | Crear nuevo autor |
| PUT | `/api/autores/{id}` | Actualizar autor |
| DELETE | `/api/autores/{id}` | Eliminar autor |

### Libros
| Método | Endpoint | Descripción |
|--------|----------|--------------|
| GET | `/api/libros` | Listar todos los libros |
| GET | `/api/libros/{id}` | Obtener libro por ID |
| POST | `/api/libros` | Crear nuevo libro |
| PUT | `/api/libros/{id}` | Actualizar libro |
| DELETE | `/api/libros/{id}` | Eliminar libro |

### Préstamos
| Método | Endpoint | Descripción |
|--------|----------|--------------|
| GET | `/api/prestamos` | Listar todos los préstamos |
| GET | `/api/prestamos/{id}` | Obtener préstamo por ID |
| POST | `/api/prestamos` | Crear nuevo préstamo |
| PUT | `/api/prestamos/{id}` | Actualizar préstamo |
| DELETE | `/api/prestamos/{id}` | Eliminar préstamo |

---

## 🚀 Cómo ejecutar el proyecto

### Requisitos previos
- IntelliJ IDEA
- JDK 21 o superior

### Pasos

1. Cloná o descargá este repositorio
2. Abrí IntelliJ IDEA → `File → Open` → seleccioná la carpeta `biblioteca-api`
3. Esperá que Maven descargue las dependencias automáticamente
4. Ejecutá la clase `BibliotecaApplication.java` (botón ▶️ o `Shift + F10`)
5. Abrí el navegador en:

```
http://localhost:8080
```
---
## 👤 Autor

Proyecto desarrollado por **Ignacio Damonte**
Tecnicatura en Programación — Teclab
