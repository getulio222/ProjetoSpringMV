package com.usuario_service.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api/v1/usuarios")
public class UsuarioController {
	
	@GetMapping
	@ApiOperation("Retorna os usuários via Rest")
	@ApiResponses( value = {
			
			@ApiResponse(code=200, message= "Sucess")
	})
	public String retornaUsuario() {
		return "Usuario encontrado com sucesso!";
	}

}
