package com.usuarios_service.repositores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios_service.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> localizaEmail(String email);

}
