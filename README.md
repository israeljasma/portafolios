# CV Portafolios

CV Portafolios es un prototipo de plataforma personalizada diseñada para destacar tus habilidades, experiencia y proyectos. Presenta tu currículum de una manera atractiva y profesional, combinando elementos de un currículum tradicional con un portafolio visualmente impactante. Muestra tu trayectoria laboral, tus logros destacados y tus habilidades clave en secciones dedicadas. Además, exhibe tus proyectos más relevantes en un portafolio interactivo, donde los visitantes pueden explorar tus creaciones en detalle. Con un diseño moderno y limpio, esta web te permite presentar tu perfil de manera efectiva y cautivadora, impresionando a posibles empleadores o clientes potenciales."

## Requisitos previos

Asegúrese de tener instalado lo siguiente:

- Java 20 o superior
- Maven
- Spring Boot
- XAMPP

## Configuración

Siga estos pasos para configurar y ejecutar el proyecto:

1. Clonar el repositorio:
> git clone https://github.com/israeljasma/portafolios.git
2. Inicia los módulos de Apache y MySQL haciendo clic en los botones "Start" junto a cada uno situados en el panel de control de XAMPP
3. Abre tu navegador web y ve a "localhost/phpmyadmin".
4. Dirigete a la seccion de ejecucion de sentencias SQL.
5. Copia y pega las sentencias SQL en el archibo BD.sql que estan situadas en el directorio
> portafolios/src/main/java/cl/israeljasma/portafolios/models
6. Ejecuta las sentencias para que se genere la base de datos con sus datos de prueba
7. Navegar al directorio del proyecto:
8. Compilar y empaquetar el proyecto usando Maven:
> mvn clean package
9. Ejecutar la aplicación
10. Abre tu navegador web y ve a
> http://localhost:8080/
11. El proyecto de debiese estar ejecutando correctamente
12. Para ingresar a la zona de administrador dirigete a 
> http://localhost:8080/dashboard
13. Utilice las credenciales usuario: testuser, password: 1234

## Contacto

Si tienes alguna pregunta o comentario sobre este proyecto, puedes contactarme a través de [correo electrónico](israel.jasma@gmail.com).
