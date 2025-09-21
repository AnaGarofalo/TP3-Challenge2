# Challenge2 App

Esta es una aplicación Android desarrollada en **Kotlin** usando **Jetpack Compose**, modelada a partir de un diseño en Figma.

## 📸 Nota sobre imágenes

Se planificó usar **Coil** para cargar imágenes de manera remota, pero debido a problemas de integración, **las imágenes están actualmente hardcodeadas** en la app. Esto será mejorado en próximas versiones.

## 📱 Diseño

El diseño de la app se basó en este Figma:  
[Ver Figma](https://www.figma.com/design/xvOcnvgJGNODaDsEwUvEoU/2º-Challenge?node-id=24-3285&t=16xnBypBHtvEfgCR-0)

La interfaz incluye:

- **TopBar** con título dinámico y menú hamburguesa.
- **Bottom Navigation Bar** con íconos y botón central flotante.
- Listados de productos con detalle de favoritos y carrito.
- Pantallas de perfil, configuración y favoritos.

## ⚙️ Tecnologías usadas

- **Kotlin**
- **Jetpack Compose** para UI moderna y declarativa
- **Navigation Compose** para manejar la navegación entre pantallas
- **State Management** con `remember` y `mutableStateListOf`
- **Coroutines** para manejar interacciones asincrónicas
- **Material3** para componentes y theming

## 🚀 Funcionalidades principales

- Navegación entre **Home**, **Profile**, **Settings** y **Favorites**.
- **Carrito** con modal emergente.
- Botón **flotante central** en la Bottom Navigation Bar.
- Menú **hamburguesa** para acceder a las secciones de la app.
- Gestión de **favoritos** y **productos** con estados reactivos.
