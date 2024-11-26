package com.usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuarios.domain.Usuario;
import com.usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new EmailJaCadastradoException();
        }
        return usuarioRepository.save(usuario);
    }

	public Object listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
}