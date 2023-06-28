package cl.israeljasma.portafolios.logs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateLog {

    /**
     * Registra un mensaje de error en un archivo de registro.
     *
     * @param errorMensaje El mensaje de error a registrar.
     */
    public static void errorLog(String errorMensaje) {
        doRutaMkdir(); // metodo que verifica ruta donde se creará log, sino existe crear la ruta con los directorios respectivos
        createFileLog(errorMensaje); // metodo que crea el archivo de log
    }


    /**
     * Crea un archivo de registro y escribe el mensaje de error.
     *
     * @param errorMensaje El mensaje de error a escribir en el archivo de registro.
     */
    public static void createFileLog(String errorMensaje) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateFormatHora = new SimpleDateFormat("HH:mm:ss");
        Date dateNow = new Date();
        String nombreArchivo = dateFormat.format(dateNow) + ".txt"; // Aqui se le asigna el nombre y
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("/opt/tomcat/bin/proyectoWeb/Log/"+ nombreArchivo, true));
            out.write("ERROR: " + dateFormatHora.format(dateNow) + " " + errorMensaje);
            out.write("\n");
        } catch (IOException e) {
            System.out.println("[Error][CrearLog][crearArchivoLog][IOException]: " + e.getMessage());
            CreateLog.errorLog("[CrearLog][crearArchivoLog][IOException]: " + e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("[Error][CrearLog][crearArchivoLog][IOException]: " + e.getMessage());
                    CreateLog.errorLog("[CrearLog][crearArchivoLog][IOException]: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Verifica la existencia de una ruta de directorio para el archivo de registro. Si no existe, crea la ruta y los directorios necesarios.
     */
    public static void doRutaMkdir() {
        if (!(new File("/opt/tomcat/bin/proyectoWeb/Log/").exists())) {
            (new File("/opt/tomcat/bin/proyectoWeb/Log/")).mkdirs();
        }
    }
}
