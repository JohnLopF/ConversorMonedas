Descripción
Este proyecto es una aplicación de consola simple que permite convertir entre diferentes monedas. Utiliza una API externa (especificada en el código proporcionado) para obtener las tasas de cambio actualizadas. El historial de conversiones se almacena tanto en memoria como en un archivo de texto para su consulta posterior.

Funcionalidades principales:

Conversión de monedas: Permite al usuario ingresar la moneda inicial, la moneda final y el monto a convertir.
Historial de conversiones: Guarda un registro de todas las conversiones realizadas en una lista en memoria y en un archivo de texto llamado "Conversiones.txt".
Consulta del historial: Permite al usuario revisar el historial completo de las conversiones.

Estructura del proyecto:

Main.java: Contiene el punto de entrada de la aplicación, donde se gestiona la interacción con el usuario y se coordinan las diferentes clases.
Conversion.java: Representa una conversión individual, almacenando información como la moneda inicial, la moneda final, el monto, la tasa de cambio y el resultado.
HistorialConversiones.java: Gestiona el historial de conversiones, almacenándolas en una lista y permitiendo agregar nuevas conversiones y mostrar el historial completo.
APIRequest.java: Realiza la conexión y solicitud de datos a través del API.

Cómo ejecutar la aplicación:

Compilar: Compilar el código fuente utilizando un compilador de Java.
Ejecutar: Ejecutar el archivo .class generado (generalmente Main.class).

Requisitos:

Java Development Kit (JDK): Asegúrate de tener instalado el JDK en tu sistema.
Una API de tasas de cambio: El código actual asume que existe una clase APIRequest que se encarga de obtener las tasas de cambio de una API externa. Debes implementar esta clase o utilizar una librería existente para este propósito.
