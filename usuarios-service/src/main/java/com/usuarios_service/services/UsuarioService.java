package com.usuarios_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usuarios_service.domain.Usuario;
import com.usuarios_service.repositores.*;

@Service
public class UsuarioService {
	
	 @Autowired
	 private UsuarioRepository UsuarioRepository;

	    public Usuario criaUsuarios(Usuario Usuario) {
	        if (UsuarioRepository.localizaEmail(Usuario.getEmail()).isPresent()) {
	            throw new IllegalArgumentException("O E-mail digitado já Existe ");
	        }
	        return UsuarioRepository.save(Usuario);
	    }
	    

	    public List<Usuario> listaUsuarios() {
	        return UsuarioRepository.findAll();
	    }
	    

	    public Usuario atualizaUsuarios(Long id, Usuario dscUsuario) {
	        Usuario Usuario = UsuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não enontrado"));
	        Usuario.setNome(dscUsuario.getNome());
	        Usuario.setEmail(dscUsuario.getEmail());
	        return UsuarioRepository.save(Usuario);

	    }
	    
	    @Transactional
	    public void excluiUsuarios(Long id) {
	        Usuario Usuario = UsuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario não foi encontrado"));
	        if (!Usuario.getTarefas().isEmpty()) {
	            throw new IllegalArgumentException("Não é possível excluir o usuário com tarefas associadas");
	        }
	        UsuarioRepository.delete(Usuario);
	    }
}