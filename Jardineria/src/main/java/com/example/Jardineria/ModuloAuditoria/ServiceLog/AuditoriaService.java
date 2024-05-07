package com.example.Jardineria.ModuloAuditoria.ServiceLog;


import org.springframework.stereotype.Service;

@Service
public class AuditoriaService {
    private static AuditoriaService instancia;

    // Constructor privado para evitar la instanciación directa
    private AuditoriaService() {}

    // Método estático para obtener la instancia única del servicio
    public static synchronized AuditoriaService getInstance() {
        if (instancia == null) {
            instancia = new AuditoriaService();
        }
        return instancia;
    }

    // Método para registrar errores
    public void registrarError(String mensaje) {
        // Lógica para registrar el error (p. ej., escribir en un archivo de registro)
        System.out.println("Error registrado: " + mensaje);
    }
}

