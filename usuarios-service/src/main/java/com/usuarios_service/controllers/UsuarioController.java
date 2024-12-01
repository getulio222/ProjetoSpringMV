package com.usuarios_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios_service.domain.Usuario;
import com.usuarios_service.services.UsuarioService;

@RestController
@RequestMapping(value = "api/v1/usuarios")
public class UsuarioController {
	
	@Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario criaUsuarios(@RequestBody Usuario Usuario) {
        return usuarioService.criaUsuarios(Usuario);
    }

    @GetMapping
    public List<Usuario> listaUsuarios() {
        return usuarioService.listaUsuarios();
    }

    @PutMapping("/usuarios/{id}")
    public Usuario atualizaUsuarios(@PathVariable Long id, @RequestBody Usuario dscUsuario) {
        return usuarioService.atualizaUsuarios(id, dscUsuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void excluiUsuarios(@PathVariable Long id) {
    	usuarioService.excluiUsuarios(id);
    }

}
