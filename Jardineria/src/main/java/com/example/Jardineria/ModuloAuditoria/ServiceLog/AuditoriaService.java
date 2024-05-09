import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AuditoriaService {

    private static AuditoriaService instancia;

    // Constructor privado para evitar la instanciación directa
    private AuditoriaService() {
    }

    // Método estático para obtener la instancia única del servicio
    public static synchronized AuditoriaService getInstance() {
        if (instancia == null) {
            instancia = new AuditoriaService();
        }
        return instancia;
    }

    @Value("${log.error.filepath}")
    private String errorLogFilePath;

    // Método para registrar errores
    public void registrarError(Date timestamp, String errorType, String errorMessage) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = dateFormat.format(timestamp);
        String logMessage = "Timestamp: " + formattedTimestamp + ", Error Type: " + errorType + ", Error Message: " + errorMessage;

        try {
            FileWriter fileWriter = new FileWriter(errorLogFilePath, true); // true para agregar al archivo existente
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(logMessage);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar el error de escritura del archivo aquí
        }
    }
}
