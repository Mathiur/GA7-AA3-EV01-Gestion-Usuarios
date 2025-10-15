package com.tuproyecto.gestion_usuarios.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; 
import lombok.NoArgsConstructor; // Necesario para la creacion automatica por Spring

/**
 * Clase de Entidad Usuario.
 * REPRESENTA UN REGISTRO en la base de datos (BD).
 * Se utiliza Lombok (@Data) para generar el codigo repetitivo (getters/setters).
 */
@Entity // Indica a Spring que esta clase es una entidad de BD
@Data   // Genera getters, setters, toString, equals y hashCode automaticamente
@NoArgsConstructor // Genera un constructor vacio, necesario para JPA
public class Usuario {

    // Comentario: El campo 'id' es la clave primaria (identificador unico).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se genera automaticamente
    private Long id;

    // Comentario: Nombre completo del usuario.
    private String nombre;

    // Comentario: Correo electronico unico.
    private String email;

    // Nota: Gracias a @Data de Lombok, no necesitamos escribir mas codigo.
}
