**Donealo**

Descripción

Donealo es una aplicación móvil que facilita el intercambio de artículos entre usuarios a través de donaciones. Esta plataforma fomenta el apoyo comunitario y la reutilización de recursos, permitiendo a las personas regalar artículos que ya no necesitan y encontrar lo que buscan en su área.

**Características Principales**

Publicación de artículos:

Los usuarios pueden subir artículos para regalar, acompañados de fotos, descripciones y categorías como ropa, muebles y comida.

Filtros avanzados:

Busca artículos fácilmente por categoría, ubicación o palabras clave para encontrar lo que necesitas más rápido.

Sistema de mensajería directa:

Una herramienta de chat integrada permite coordinar entregas de manera eficiente entre donantes y receptores.

Perfil de usuario:

Cada usuario tiene un perfil personalizado que incluye un historial de donaciones realizadas y recibidas.

Propósito

Donealo busca promover el intercambio solidario entre las personas, reducir el desperdicio y alentar prácticas más sostenibles mediante la reutilización de bienes.

**Versión v2.0**

En esta nueva versión de la APP encontramos sustanciales mejoras. 

- Se agregaron los Logs del Ciclo de Vida.

- Se agregaron el NavController y el NavHost.

- En la pantalla Main encontramos unos botones que nos servirán en futuras actualizaciones para acceder al contenido de cada sección.

- Se agregó un botón para volver al HomeScreen en cada sección.

- Se agregaron las dependencias Room en el build.gradle.kts(app).

Se realizaron modificaciones en el AndroidManifest.xml

- Modificamos el nombre de la app.
  
- Agregamos iconos nuevos de la app.
  
- Establecimos permisos para Internet y almacenamiento.
  
- Fijamos la orientación en Portrait para la MainActivity (esto será modificado para otras Activities en las próximas actualizaciones).


**Versión v3.0**

En esta nueva versión de la APP encontramos sustanciales mejoras. 

**Bugfixes**
- En esta versión se ha solucionado un error que no mostraba correctamente el log al girar la pantalla de vertical a horizontal y viceversa.

- Al entrar en cada sección ya no aparece la imagen y el titulo principal de la aplicación.

**Cambios**
- Se ha cambiado la disposición de las secciones en la pantalla con unos botones renovados.
  
- Se ha agregado una sección nueva para realizar donaciones a traves de SQLite.
  
- Dentro de cada sección ahora se muestran 5 ejemplos de donaciones.
  
- En cada sección existe un botón de "Volver al home" para volver a la pantalla principal.

