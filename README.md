Proyecto creado para la resolución del problema 2:
Utilice Java 8.
He utilizado intellij como ide:https://www.jetbrains.com/es-es/idea/. 
Maven para el manejo de dependencias: https://maven.apache.org/  Version: 4.0.0 
y Wildfly / JBoss para la creación de un rest API:https://docs.jboss.org/tools/3.3.0.Final/en/resful_web_services_user_guide/html_single/index.html Version: 16.0.0 Para la descarga: https://wildfly.org/downloads/ buscar la version: 16.0.0.Final

Para replicar las pruebas es necesario tener los componentes con las versiones arriba establecidos, excepto el intellij se puede usar otro IDE. 
En lo que se descargue todas las dependencias necesarios debes abrir el IDE escogido y seleccionar el JDK 1.8, en el caso de intellij Seleccionamos File -> Project Structure -> SDKs -> + -> JDK y buscas la ruta del JDK que hayas descargado.
Seguidamente seleccionar el JBoss descargado en intellij seleccionamos -> Add Configuration -> Templates -> JBoss Server -> Local -> Configure - > icono de la carpeta y buscamos donde descomprimimos la descarga de Wildfly 16, en URL debe decir: http://localhost:8070/Proyecto_war_exploded y en JRE: 1.8.
Ya se puede correr y simplemente se debe descargar postman o alguna herramienta de Request que permitar peticiones POST y usamos el siguiente URL: http://localhost:8080/Proyecto_war_exploded/api/server/date?hora=18:43:00&timezone=america/caracas
NOTA: para el desarrollo de este servicio se requiere la hora en formato HH:mm:ss y la Ubicación de la timezone en la que está esa hora: https://garygregory.wordpress.com/2013/06/18/what-are-the-java-timezone-ids/
se puede usar la version de Oracle Corporation’s version 1.8.0_60.