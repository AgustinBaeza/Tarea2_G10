# Tarea 2: Sistema de Gestión de Reuniones - Desarrollo Orientado a Objetos

## Integrantes - Grupo 10

- Agustín Andrés Baeza Mansilla
- Alan Ignacio Flores Yerey
- Ignacio Esteban Placencia Palma

---

## Descripción del Proyecto

Este proyecto corresponde a la Tarea 2 de la asignatura Desarrollo Orientado a Objetos. Consiste en la implementación en Java de un sistema orientado a objetos para gestionar reuniones dentro de una empresa.

El sistema permite simular el funcionamiento de una reunión considerando distintas posibilidades: creación de reuniones virtuales o presenciales, registro de invitaciones, control de asistencia, registro de ausentes, retrasos, notas, cálculo de duración real y generación de un informe en formato `.txt`.

Además, el sistema permite trabajar con empleados, departamentos completos e invitados externos, incorporando validaciones mediante excepciones personalizadas para evitar datos incorrectos o estados inconsistentes dentro de la aplicación.

El objetivo principal del proyecto es aplicar conceptos de Programación Orientada a Objetos como clases abstractas, herencia, interfaces, composición, asociación, encapsulamiento, manejo de colecciones, excepciones personalizadas y documentación mediante JavaDoc.

---

## UML del Proyecto

El siguiente diagrama representa el modelo UML actualizado del sistema.

![Diagrama UML actualizado](UML.png)

El UML fue actualizado a partir del modelo base entregado en la tarea, incorporando las nuevas funcionalidades solicitadas en el enunciado: generación de informe en archivo `.txt`, invitación y asistencia de invitados externos, registro de asistencia, ausentes, retrasos, notas y manejo de excepciones personalizadas.

Para mantener la legibilidad del diagrama, el UML muestra las clases principales, sus atributos más relevantes, métodos principales, getters, setters importantes, `toString()` cuando corresponde y las relaciones más importantes entre clases. Las excepciones personalizadas no se muestran como clases separadas dentro del diagrama principal para evitar que el modelo sea demasiado extenso, pero sí forman parte del código implementado y se explican en este README.

---

## Resumen del Modelo Implementado

El sistema se construyó a partir de la clase abstracta `Reunion`, que representa los atributos y comportamientos comunes de cualquier reunión. Desde esta clase heredan `ReunionVirtual` y `ReunionPresencial`, permitiendo reutilizar la lógica general y diferenciar cada tipo de reunión mediante un atributo específico: `enlace` para reuniones virtuales y `sala` para reuniones presenciales.

El modelo también considera empleados y departamentos. Los empleados representan a los trabajadores de la empresa, mientras que los departamentos permiten agrupar empleados e invitar a un conjunto completo de personas a una reunión.

Para manejar los distintos tipos de invitados se utiliza la interfaz `Invitable`. Esta interfaz es implementada por `Empleado`, `Departamento` e `InvitadoExterno`, permitiendo que el sistema pueda tratar de forma uniforme a empleados individuales, departamentos completos y personas externas a la empresa.

La clase `InvitadoExterno` fue agregada para permitir la participación de personas que no pertenecen a la empresa. Esta clase almacena nombre, apellidos y correo electrónico, permitiendo identificar correctamente a estos participantes.

La asistencia de una reunión se administra mediante la clase `Asistencia`, que contiene listas de asistentes, ausentes y retrasos. Las listas de asistentes y ausentes trabajan con objetos de tipo `Invitable`, ya que no solo pueden participar empleados, sino también invitados externos. Por coherencia con este diseño, los métodos de asistencia utilizan el parámetro `invitado` en vez de `empleado`.

Los retrasos se representan mediante la clase `Retraso`, que asocia a un empleado con su hora de llegada. Las notas se representan mediante la clase `Nota`, permitiendo registrar comentarios asociados a una reunión junto con su autor y fecha/hora de creación.

Finalmente, la clase `TxtReunion` se encarga de generar el informe de la reunión en formato `.txt`. Esta clase utiliza la información almacenada en `Reunion` para construir un archivo con los datos principales de la reunión, asistencia, retrasos y notas.

---

## Cambios Respecto al Modelo UML Original

Durante el desarrollo se realizaron modificaciones al modelo UML original para cumplir con los nuevos requerimientos de la tarea y mejorar la organización del sistema.

La primera modificación importante fue la incorporación de `InvitadoExterno`, ya que el enunciado solicita permitir la invitación y asistencia de personas que no pertenecen a la empresa. Para integrar esta clase sin duplicar lógica, se utilizó la interfaz `Invitable`, implementada por `Empleado`, `Departamento` e `InvitadoExterno`.

También se modificó la clase `Asistencia` para trabajar con objetos de tipo `Invitable` en las listas de asistentes y ausentes. Esto permite registrar tanto empleados como invitados externos. Además, se cambió el nombre del parámetro en los métodos de asistencia desde `empleado` a `invitado`, debido a que no todos los participantes son empleados.

Otra modificación relevante fue la incorporación de `TxtReunion`, clase encargada de generar el informe de la reunión en formato `.txt`. Esta clase utiliza la información almacenada en `Reunion`, incluyendo fecha, hora prevista, hora de inicio, hora de fin, duración real, tipo de reunión, modalidad, asistentes, ausentes, retrasos y notas.

Se agregaron excepciones personalizadas para validar casos incorrectos o inconsistentes dentro del sistema. Estas excepciones permiten controlar registros duplicados, contradicciones entre asistentes y ausentes, reuniones iniciadas o finalizadas en estados inválidos, notas vacías, autores inválidos, retrasos incompletos, invitados con datos incorrectos y operaciones inválidas con departamentos o empleados.

También se incorporaron métodos `toString()` en las clases principales, con el objetivo de entregar representaciones legibles de los objetos y facilitar la revisión de información durante pruebas, generación de informes o salidas por consola.

Estas modificaciones permiten que el modelo actualizado sea coherente con las nuevas funcionalidades solicitadas, manteniendo una estructura orientada a objetos clara, extensible y alineada con el código implementado.

---
## Decisiones de Diseño Adicionales

Respecto al requisito del enunciado de Getters y Setters, particularmente sobre los Setters de algunas clases, se tomo la decision de hacer descarte de estos mismos, por las malas prácticas que se pueden llegar a ejecutar con estos mismos, en particular, las clases sobre las que se considera esto son:

- Invitacion.java
  
Se descarta la idea de implementar setters a Invitación tales como setInvitado() o setHora() porque modificarlos posterior a su construcción generaría datos inconsistentes a la hora de registrar los datos de la invitación a la entidad, la hora registrada no correspondería al momento real de invitación y si se quiere hacer una invitación a otra entidad dentro de las disponibles, simplemente se crea una nueva Invitación, por lo que no es necesario setInvitado().

- Retraso.java
  
Se descartan los setters para Retraso.java, pues representa un hecho que ocurrió en específico en cierto momento a cierta hora, la modificación de estas no sería mas que para un mal uso de este recurso, pues si bien un empleado en la práctica podría justificar su retraso, debe quedar registro de este de igual forma.

- Asistencia.java
  
Se descarta la implementación de setters para las listas de asistentes, ausentes y retrasos, ya que esta clase funciona como el registro oficial y la bitácora de lo que ocurre en una reunión. Permitir un setter que reemplace una colección completa da lugar a la alteración del historial de asistencia de un momento a otro. Además, al sobreescribir las listas de golpe se evadirían por completo las validaciones esenciales del sistema, como el control que evita registrar a alguien dos veces mediante RegistroDuplicadoException. En la práctica, la asistencia se construye de manera incremental a medida que transcurre el evento, por lo que cualquier cambio debe pasar obligatoriamente por los métodos dedicados a ello, tal es el caso de agregarAsistente(), agregarAusente() y registrarRetraso().

- Empleado.java

Se descarta la implementación de setters a Empleado pues al representar a entidades reales cuyos datos no deberían poder modificarse una vez registrados en el historial del sistema, si bien atributos como el ID, Nombre y Apellidos son permanentes, está la posibilidad de cambiar el correo de un empleado, pero esto de igual forma se descarta pues es inconsistente que un empleado cambie su correo a media reunión y el sistema registre este cambio (en la práctica no sucede de esa forma si es que ocurre un cambio de correo dentro de una empresa), esto puede generar inconsistencias a la hora de registrar invitaciones/asistencia/atrasos que ya hacen referencia al objeto original, por lo cual únicamente se mantienen los getters.

- InvitadoExterno.java

Bajo el mismo argumento que Empleado.java, se descarta la posibilidad de modificar nombre, apellidos y correo mediante setters en el código, pues en una reunión esto se registra una única vez al momento de ingresar y cambios posteriores generarían inconsistencias en los registros.

- Nota.java

Si bien se descarta la implementacion setAutor() por las incoherencias similares a clases anteriores que puede dar lugar, se mantiene setContenido() pues es una correccion sobre notas que en la práctica si puede llegar a necesitarse, ya sea para corregir un error tipográfico o añadir detalles a lo anotado.

- Departamento.java

Se descarta la implementacion de setters a Departamento tales como setNombre() o setDepartamento() pues esto daria la posibilidad de que cualquier componente externo reemplace a todos los empleados de golpe saltándose el control de los métodos específicos (addEmpleado() y removeEmpleado()) y arriesgando la filtracion de datos nulos o inconsistentes, además que el cambio de nombre de un departamento (que en sí, corresponde a la identidad entera de este mismo) puede alterar la consistencia de informes impresos posteriores y a los datos registrados a mitad de la reunión realizada, lo que daría lugar a malas prácticas con su implementación.

---

## Excepciones Personalizadas

El proyecto incorpora excepciones personalizadas para controlar errores propios del sistema de reuniones.

Todas las excepciones se encuentran en el paquete:


- Reuniones.Excepciones


Las principales excepciones implementadas son:

- `RegistroDuplicadoException`: evita registrar dos veces a un mismo invitado como asistente o ausente.
- `ContradiccionException`: evita que una misma persona sea registrada al mismo tiempo como asistente y ausente.
- `EstadoReunionException`: controla acciones inválidas en el ciclo de vida de una reunión, como iniciar una reunión dos veces, finalizar una reunión no iniciada o finalizar una reunión ya finalizada.
- `NotaVaciaException`: evita crear notas con contenido nulo o vacío.
- `AutorVacioException`: evita crear notas sin un autor válido.
- `RetrasoInvalidoException`: evita registrar retrasos sin empleado o sin hora de llegada.
- `InvitadoInvalidoException`: valida datos incorrectos en empleados o invitados externos.
- `InvitacionInvalidaException`: evita crear invitaciones con un invitado nulo.
- `DepartamentoInvalidoException`: valida nombres incorrectos de departamentos.
- `DepartamentoVacioException`: evita invitar departamentos sin empleados.
- `EmpleadoInvalidoException`: controla operaciones inválidas con empleados dentro de un departamento.
- `ReunionInvalidaException`: valida datos incorrectos al crear una reunión, como fecha, duración, hora prevista o tipo de reunión nulos.

Estas excepciones permiten manejar casos normales y extremos de forma más clara, evitando que el sistema acepte datos inconsistentes.

---

