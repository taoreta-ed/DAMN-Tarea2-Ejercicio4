# DAMN Tarea 2 - Ejercicio 4: Aplicación Explorador Mundial

## Descripción

Esta aplicación de Android, **Explorador Mundial**, está diseñada para permitir a los usuarios explorar diferentes partes del mundo de forma jerárquica. La aplicación está estructurada de la siguiente manera:

1.  **Continentes:** La aplicación comienza mostrando una lista de continentes.
2.  **Países:** Cuando un usuario selecciona un continente, se le lleva a una lista de países dentro de ese continente.
3.  **Estados:** Cuando un usuario selecciona un país, se le lleva a una lista de estados dentro de ese país.
4.  **Puntos de Interés:** Tanto en las vistas de países como de estados, los usuarios pueden agregar y ver puntos de interés.

La aplicación utiliza un diseño limpio y consistente, con botones e títulos en blanco y negro. Cada pantalla tiene una imagen de fondo que corresponde al continente o país seleccionado.

## Transiciones entre Actividades

Las transiciones entre actividades se gestionan utilizando objetos `Intent`. Aquí hay un desglose de cómo se gestiona cada transición:

1.  **Continentes a Países:**
    *   En `ContinentsActivity.kt`, cuando se hace clic en un botón de continente, se crea un `Intent` para iniciar `CountriesActivity`.
    *   El nombre del continente seleccionado se pasa como un extra usando `intent.putExtra("continent", continentName)`.
    *   Se llama a `startActivity(intent)` para iniciar la transición.
2.  **Países a Estados:**
    *   En `CountriesActivity.kt`, cuando se hace clic en un botón de país, se crea un `Intent` para iniciar `StatesActivity`.
    *   El nombre del país seleccionado se pasa como un extra usando `intent.putExtra("country", countryName)`.
    *   Se llama a `startActivity(intent)` para iniciar la transición.
3.  **Navegación hacia Atrás:**
    *   Tanto en `CountriesActivity.kt` como en `StatesActivity.kt`, se proporciona un botón "Atrás".
    *   Cuando se hace clic en el botón "Atrás", se llama a `finish()`. Esto cierra la actividad actual y devuelve al usuario a la actividad anterior en la pila.

**Paso de Datos:**

*   El método `Intent.putExtra()` se utiliza para pasar datos entre actividades.
*   El método `Intent.getStringExtra()` se utiliza para recuperar los datos en la actividad receptora.

**Almacenamiento de Datos:**

*   La clase `DataStorage` se utiliza para guardar y recuperar puntos de interés.
*   La clase `PointOfInterest` se utiliza para representar un punto de interés.

**Contenido Dinámico:**

*   Los objetos `CountryData` y `StateData` se utilizan para almacenar la lista de países y estados para cada continente y país, respectivamente.
*   Los textos de los botones se establecen dinámicamente en función del continente o país seleccionado.

## Ejecutar y Probar la Aplicación

Siga estos pasos para ejecutar y probar la aplicación **Explorador Mundial**:

1.  **Requisitos Previos:**
    *   **Android Studio:** Asegúrese de tener Android Studio instalado en su computadora.
    *   **Android SDK:** Asegúrese de tener el Android SDK instalado y configurado en Android Studio.
    *   **Emulador o Dispositivo Físico:** Necesitará un emulador de Android o un dispositivo Android físico para ejecutar la aplicación.
2.  **Clonar el Repositorio:**
    *   Si tiene el código en un repositorio de Git, clónelo en su máquina local usando `git clone <url_del_repositorio>`.
3.  **Abrir el Proyecto en Android Studio:**
    *   Inicie Android Studio.
    *   Haga clic en "Open" y seleccione el directorio del proyecto.
4.  **Construir el Proyecto:**
    *   Vaya a `Build > Make Project` o haga clic en el botón "Make Project" (icono de martillo) en la barra de herramientas.
    *   Esto compilará el código y generará los archivos necesarios.
5.  **Ejecutar la Aplicación:**
    *   Seleccione su emulador o dispositivo físico en el menú desplegable de dispositivos en la barra de herramientas.
    *   Haga clic en el botón "Run" (icono de reproducción verde) en la barra de herramientas.
    *   Android Studio construirá la aplicación y la instalará en su dispositivo seleccionado.
6.  **Probar la Aplicación:**
    *   Una vez que la aplicación esté instalada, se iniciará automáticamente.
    *   Pruebe lo siguiente:
        *   **Navegación:** Haga clic en diferentes continentes, países y estados para asegurarse de que las transiciones funcionen correctamente.
        *   **Botón Atrás:** Use el botón "Atrás" para navegar hacia atrás a través de las actividades.
        *   **Puntos de Interés:** Intente agregar y ver puntos de interés en las vistas de países y estados.
        *   **Fondos:** Compruebe que las imágenes de fondo cambien correctamente para cada continente y país.
        * **Botones:** Compruebe que los botones se muestran correctamente.
        * **Títulos:** Compruebe que los títulos se muestran correctamente.
7. **Solución de Problemas**
    * Si tiene algún problema, consulte los mensajes anteriores.
    * Compruebe las importaciones.
    * Compruebe los nombres de los recursos.
    * Limpie y reconstruya el proyecto.
    * Invalide las cachés y reinicie.
    * Elimine las carpetas .idea y build.
    * Sincronice el proyecto con los archivos de gradle.

## Estructura del Proyecto

*   **`app/src/main/java/com/example/damn_tarea2_ejercicio4`:** Contiene el código fuente de Kotlin para la aplicación.
    *   `ContinentsActivity.kt`: Maneja la visualización de continentes.
    *   `CountriesActivity.kt`: Maneja la visualización de países.
    *   `StatesActivity.kt`: Maneja la visualización de estados.
    *   `CountryData.kt`: Contiene los datos para los países.
    *   `StateData.kt`: Contiene los datos para los estados.
    * `DataStorage.kt`: Contiene los datos para los puntos de interés.
    * `PointOfInterest.kt`: Contiene los datos para un punto de interés.
*   **`app/src/main/res/layout`:** Contiene los archivos de diseño XML para las actividades.
    *   `activity_continents.xml`: Diseño para la pantalla de continentes.
    *   `activity_countries.xml`: Diseño para la pantalla de países.
    *   `activity_states.xml`: Diseño para la pantalla de estados.
*   **`app/src/main/res/drawable`:** Contiene los recursos de imagen utilizados en la aplicación.
*   **`app/src/main/res/values`:** Contiene los archivos de recursos para colores y estilos.
    * `colors.xml`: Contiene los colores.
    * `styles.xml`: Contiene los estilos.
* **`app/src/main/AndroidManifest.xml`:** Contiene el manifiesto.

## Conclusión

Esta aplicación **Explorador Mundial** es un gran ejemplo de una aplicación de Android de múltiples actividades con contenido dinámico y almacenamiento de datos. Demuestra cómo usar objetos `Intent` para navegar entre actividades y cómo pasar datos entre ellas.