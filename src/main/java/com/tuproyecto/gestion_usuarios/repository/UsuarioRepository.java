package com.tuproyecto.gestion_usuarios.repository;


import com.tuproyecto.gestion_usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio del modulo de gestion. 
 * Esta interfaz es parte del framework Spring Data JPA.
 * * Extender de JpaRepository nos da de forma automatica todos los metodos 
 * basicos para manejar la entidad Usuario (CRUD: Crear, Leer, Actualizar, Eliminar).
 * * El primer parametro es la Clase de la Entidad (Usuario) y el segundo es el 
 * tipo de dato del ID de esa clase (Long).
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Comentario: Este es un ejemplo de un metodo que Spring crea por ti.
    // Al nombrar el metodo como findByEmail, Spring sabe que debe buscar 
    // un usuario por su columna 'email'.
    Usuario findByEmail(String email);
}
