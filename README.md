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

## Funcionalidades Implementadas

El sistema permite:

- Crear reuniones virtuales y presenciales.
- Registrar un organizador.
- Invitar empleados.
- Invitar departamentos completos.
- Invitar personas externas.
- Registrar asistentes.
- Registrar ausentes.
- Registrar retrasos.
- Registrar notas.
- Iniciar una reunión.
- Finalizar una reunión.
- Calcular la duración real.
- Calcular el total de asistentes.
- Calcular el porcentaje de asistencia.
- Generar un informe en archivo `.txt`.
- Validar errores mediante excepciones personalizadas.

---

## Informe de Reunión

La generación del informe se realiza mediante la clase `TxtReunion`.

El informe generado resume la información principal de la reunión y la almacena en un archivo de texto. Este archivo incluye datos generales de la reunión, información de asistencia, retrasos, estadísticas y notas registradas.

Esta funcionalidad permite dejar un registro persistente de la reunión fuera de la ejecución del programa, cumpliendo con el requerimiento de generar un informe en formato `.txt`.

---

## Validación y Pruebas

El proyecto se encuentra configurado como proyecto Maven e incluye dependencia de JUnit Jupiter.

Además, se utilizó `Main.java` como apoyo para realizar una prueba manual de integración del sistema. En esta prueba se valida un flujo general que incluye creación de empleados, creación de un departamento, creación de un invitado externo, creación de una reunión, registro de invitaciones, asistencia, ausencias, retrasos, notas, inicio y finalización de reunión, generación de informe `.txt` y ejecución de excepciones personalizadas.

El `Main` no reemplaza las pruebas unitarias, pero permite observar rápidamente el comportamiento general del sistema durante la ejecución.

---

## Documentación

El código fue documentado utilizando comentarios en formato JavaDoc en las clases y métodos principales.

La documentación del código incluye el propósito de las clases, parámetros, retornos y excepciones relevantes. Por esta razón, el README no documenta en detalle cada clase y método, sino que se enfoca en describir el funcionamiento general del sistema, las decisiones de diseño y las diferencias respecto al modelo UML original.

---

## Tecnologías Utilizadas

- Java
- Maven
- JUnit Jupiter
- IntelliJ IDEA
- Git
- GitHub

---

## Conceptos de Programación Orientada a Objetos Aplicados

En el proyecto se aplican los siguientes conceptos:

- Clases y objetos.
- Encapsulamiento.
- Herencia.
- Polimorfismo.
- Interfaces.
- Clases abstractas.
- Composición.
- Asociación.
- Enumeraciones.
- Excepciones personalizadas.
- Colecciones dinámicas.
- Separación de responsabilidades.
- Reutilización de código.

---

El proyecto implementa un sistema funcional de gestión de reuniones, incorporando los elementos principales solicitados en el enunciado de la tarea.

El sistema permite administrar reuniones virtuales y presenciales, registrar participantes internos y externos, controlar asistencia, registrar retrasos, agregar notas, iniciar y finalizar reuniones, calcular estadísticas de asistencia y generar informes en archivo `.txt`.

Las modificaciones realizadas al modelo original fueron incorporadas al UML actualizado y justificadas en este README.

---

