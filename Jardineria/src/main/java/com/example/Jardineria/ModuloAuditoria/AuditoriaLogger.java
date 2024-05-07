package com.example.Jardineria.ModuloAuditoria;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AuditoriaLogger {
    private static final Logger logger = Logger.getLogger("AuditoriaLogger");
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler("auditoria.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logError(String mensaje, Throwable throwable) {
        logger.log(Level.SEVERE, mensaje, throwable);
    }

}
