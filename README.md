[GitHub](https://github.com/angelhr28)

# Informe Técnico: Desarrollo de Aplicación Android

## Introducción

Este informe proporciona una visión integral del desarrollo de la aplicación Android, destacando la implementación de tecnologías y prácticas actuales recomendadas por Google. El proyecto se enfocó en la creación de una app modularizada, empleando Jetpack Compose, MVVM + MVI y Clean Architecture. Estas decisiones aseguran la escalabilidad, la inyección de dependencias y la realización de pruebas unitarias.

## Arquitectura y Patrones de Diseño

### Arquitectura en Capas

- **Capa de Presentación:** Se implementó Jetpack Compose en conjunción con los patrones MVVM y MVI. Esto facilita la separación de la lógica de la interfaz de usuario, manteniendo una clara división de responsabilidades.

- **Capa de Dominio:** En esta capa residen las reglas de negocio, los Use Cases y las Entities. Este enfoque permite mantener la independencia entre las capas superior e inferior.

- **Capa de Datos:** La gestión de acceso a datos se realizó mediante Repositories y Data Sources, proporcionando flexibilidad al cambiar las fuentes de datos, ya sea una API o una base de datos local.

### Patrones Utilizados

- **MVVM (Model-View-ViewModel):** Este patrón facilita la separación de la lógica de la interfaz de usuario de los datos subyacentes, mejorando la mantenibilidad del código.

- **MVI (Model-View-Intent):** Con un flujo unidireccional de datos, los eventos y acciones del usuario siguen un camino predecible, desde la Vista hasta el ViewModel, simplificando las pruebas unitarias y la gestión del estado de la aplicación.

## Funcionalidades Destacadas

La aplicación se destaca por:

- **Almacenamiento Local con Room:** Utilización de Room para almacenar localmente las recetas. Esta estrategia minimiza las llamadas al servidor, optimizando la experiencia del usuario y reduciendo el consumo de datos móviles.

## Seguridad

Se implementaron medidas de seguridad como:

- **Ofuscación de Código:** Configurada para la compilación en modo release, dificultando la comprensión del código descompilado.

## Librerías Utilizadas

La aplicación se basa en las siguientes librerías:

- **Jetpack Compose:** Framework moderno para el desarrollo de interfaces de usuario.
- **Compose Navigation:** Gestión eficiente de la navegación entre Composables, permitiendo el desarrollo de aplicaciones con una sola Activity.
- **Hilt:** Librería de inyección de dependencias que reduce el trabajo manual de inserción de dependencias.
- **Retrofit:** Facilita las peticiones HTTP de manera simplificada.
- **Room:** Abstracción que simplifica la administración de bases de datos SQLite en Android.
- **JUnit y Mockk:** Herramientas esenciales para el desarrollo de pruebas unitarias.
- **Gradle Version Catalogs:** Estandariza y facilita la gestión de dependencias en diferentes módulos.

## Conclusiones

El proyecto se desarrolló con un enfoque en las mejores prácticas actuales, priorizando la modularización, seguridad y eficiencia. La implementación de una arquitectura limpia, patrones de diseño claros y medidas de seguridad robustas ha fortalecido la aplicación en términos de mantenibilidad y estabilidad.
