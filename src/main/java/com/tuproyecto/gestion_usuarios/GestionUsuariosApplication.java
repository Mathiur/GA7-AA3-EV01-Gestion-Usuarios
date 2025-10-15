package com.tuproyecto.gestion_usuarios;


import com.tuproyecto.gestion_usuarios.model.Usuario;
import com.tuproyecto.gestion_usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner; // Interfaz para ejecutar código al inicio
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionUsuariosApplication implements CommandLineRunner { // Implementar esta interfaz

    @Autowired // Inyeccion automatica del servicio que creamos
    private UsuarioService usuarioService;

    public static void main(String[] args) {
        SpringApplication.run(GestionUsuariosApplication.class, args);
    }

    /**
     * Metodo principal de DEMOSTRACION del modulo.
     * Esto simula la ejecucion de las funcionalidades del modulo.
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n==============================================");
        System.out.println("DEMOSTRACION DEL MODULO DE GESTION DE USUARIOS");
        System.out.println("==============================================\n");

        // --- 1. CREAR NUEVO USUARIO (Historia de Usuario: Crear) ---
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre("Carlos Aprendiz SENA");
        nuevoUsuario.setEmail("carlos.sena@correo.com");
        
        System.out.println("1. Intentando crear usuario...");
        Usuario usuarioCreado = usuarioService.crearUsuario(nuevoUsuario);
        
        if (usuarioCreado != null) {
             System.out.println("✅ Usuario Creado con Éxito. ID: " + usuarioCreado.getId());

            // --- 2. BUSCAR TODOS LOS USUARIOS (Historia de Usuario: Listar) ---
            System.out.println("\n2. Listando todos los usuarios:");
            usuarioService.obtenerTodos().forEach(u -> 
                System.out.println("   - ID: " + u.getId() + ", Nombre: " + u.getNombre())
            );

            // --- 3. ELIMINAR USUARIO (Historia de Usuario: Eliminar) ---
            Long idAEliminar = usuarioCreado.getId();
            System.out.println("\n3. Eliminando usuario con ID: " + idAEliminar);
            usuarioService.eliminarUsuario(idAEliminar);
            System.out.println("🚫 Eliminación completada.");

            // --- 4. VERIFICAR ELIMINACION ---
            System.out.println("\n4. Verificando usuarios restantes:");
            if (usuarioService.obtenerTodos().isEmpty()) {
                System.out.println("   - La lista de usuarios está vacía. Prueba exitosa.");
            }
        }
        
        System.out.println("\n==============================================");
        System.out.println("DEMOSTRACION FINALIZADA. (App Stand-Alone)");
        System.out.println("==============================================");
    }
}
