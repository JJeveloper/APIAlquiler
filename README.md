### Descripcion
Api rest basica para gestionar informacion sobre el alquiler de departamentos.

<img width="641" height="364" alt="Captura de pantalla 2025-08-08 171529" src="https://github.com/user-attachments/assets/2df6e1bf-96e0-4ae9-92e0-cf703d82efbd" />

### Tecnologias y Dependencias

| Tecnologias   | Descripcion               | 
| :---          | :---                      |    
| Java          |Lenguaje de programacion   |
| Spring Boot   | Framework                 |
| Intellj IDEA  | IDE                       |
| MapStruct     |   generador de código     |
| Maven         | Gestor de proyectos       |
| JPA-Hibernate | Framework para el mapeo de objetos y persistencia en la db |
| PostMan       | Puebas de la API          |
| Mysql         | Sistema de Gestión de Bases de Datos |
| Git           | Control de versiones      |

### Despliege
- Descargar el proyecto y abrir en **Intellj IDEA**, link de descarga
 ```bash
  https://github.com/JJeveloper/APIAlquiler.git
```
- Ejecutar en **MYSQL WORKBENCH** el siquiente script (se encuentra en la raiz del proyecto)
 ```bash
  alquiler.sql
```

## Metodos HTTP

**Get: mostrar datos**
 ```bash
 http://localhost:8092/propietario/mostarpropietarioporId/{id}
 http://localhost:8092/propietario/mostrartodoslospropietarios
 http://localhost:8092/inquilino/mostarinquilinoporId/{id}
 http://localhost:8092/inquilino/mostrartodoslosinquilinos
 http://localhost:8092/departamento/mostrardepartamentoporid/{id}
 http://localhost:8092/departamento/mostrartodoslosdepartamentos
 http://localhost:8092/contrato/mostrarcontratoporid/{id}
 http://localhost:8092/contrato/mostrartodosloscontratos
```

**Post: guardar datos**
 ```bash
  http://localhost:8092/propietario/crearpropietario
 ```
 ```bash
   {
      "nombres": "Susana Palacios",
      "telefono": "0985748594"
   }
 ```

 ```bash
  http://localhost:8092/inquilino/crearinquilino
 ```
 ```bash
   {
     "nombre": "Marcos Herrera",
     "telefono": "0925874110",
     "salario": "800"
   }
 ```

 ```bash
  http://localhost:8092/departamento/creardepartamento
 ```
 ```bash
   {
     "descripcion": "departamento con un dormitorio un baño una cocina y una sala, en el tercer piso",
     "precio": "52",
     "direccion": "Av. America y Pedro Gomez",
     "idpropietario": "1"
   }
 ```

 ```bash
  http://localhost:8092/contrato/crearcontrato
 ```
 ```bash
   {
     "duracion": 6,
     "iddepartamentos": "1",
     "idinquilino": "1"
   }
 ```

**Put: actualizar datos**
 ```bash
  http://localhost:8092/propietario/actualizarpropietario/{id}
 ```
 ```bash
   {
      "nombres": "Susana Palacios",
      "telefono": "0985748594"
   }
 ```

 ```bash
  http://localhost:8092/inquilino/actualizarinquilino/{id}
 ```
 ```bash
   {
     "nombre": "Marcos Herrera",
     "telefono": "0925874110",
     "salario": "800"
   }
 ```

 ```bash
  http://localhost:8092/departamento/actualizardepartamento/{id}
 ```
 ```bash
   {
     "descripcion": "departamento con un dormitorio un baño una cocina y una sala, en el tercer piso",
     "precio": "52",
     "direccion": "Av. America y Pedro Gomez",
     "idpropietario": "1"
   }
 ```

 ```bash
  http://localhost:8092/contrato/crearcontrato
 ```
 ```bash
   {
     "duracion": 6,
     "iddepartamentos": "1",
     "idinquilino": "1"
   }
 ```

**Delete: eliminar datos**
 ```bash
 http://localhost:8092/propietario/eliminarpropietario/{id}
 http://localhost:8092/inquilino/eliminarinquilino/{id}
 http://localhost:8092/departamento/eliminardepartamento/{id}
 http://localhost:8092/contrato/eliminarcontrato/{id}
```


