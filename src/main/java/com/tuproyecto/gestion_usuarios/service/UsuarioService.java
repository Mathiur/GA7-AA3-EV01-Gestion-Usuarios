package com.tuproyecto.gestion_usuarios.service;


import com.tuproyecto.gestion_usuarios.model.Usuario;
import com.tuproyecto.gestion_usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Servicio central para el Modulo de Gestion de Usuarios.
 * Aqui se implementan las reglas y la logica de negocio.
 * @Service indica a Spring que esta clase contiene logica reutilizable.
 */
@Service
public class UsuarioService {

    // Comentario: Inyeccion de Dependencias (Estándar de Spring).
    // Spring crea la instancia de UsuarioRepository y la conecta automaticamente.
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Implementa la Historia de Usuario: "Crear Nuevo Usuario".
     * @param usuario El objeto Usuario a guardar.
     * @return El usuario guardado con su ID generado.
     */
    public Usuario crearUsuario(Usuario usuario) {
        // Logica de negocio: Evitar duplicados.
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            System.out.println("ADVERTENCIA: El email ya esta registrado y no se guardó.");
            return null;
        }
        // Llamada al repositorio para guardar en la BD
        return usuarioRepository.save(usuario);
    }

    /**
     * Implementa la Historia de Usuario: "Ver todos los Usuarios".
     * @return Una lista de todos los usuarios.
     */
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    /**
     * Implementa la Historia de Usuario: "Eliminar Usuario".
     * @param id El ID del usuario a eliminar.
     */
    public void eliminarUsuario(Long id) {
        System.out.println("Procesando eliminacion del usuario con ID: " + id);
        // Llamada al repositorio para eliminar.
        usuarioRepository.deleteById(id);
    }
}
