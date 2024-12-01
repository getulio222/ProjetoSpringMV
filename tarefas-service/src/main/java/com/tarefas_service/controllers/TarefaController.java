package com.tarefas_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tarefas_service.services.*;
import com.usuarios_service.domain.Usuario;
import com.tarefas_service.domain.Tarefa;

@RestController
@RequestMapping(value = "/api/v1/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService TarefaService;
	

	@PostMapping
	public Tarefa criaTarefas(@RequestBody Tarefa Tarefa) {
		return TarefaService.criaTarefas(Tarefa);
	}

	@GetMapping
	public List<Tarefa> listaTodasTarefas() {
		return TarefaService.listaTarefas();
	}

	@PutMapping("/tarefas/{id}")
	public Tarefa atualizaTarefas(@PathVariable Long id, @RequestBody Tarefa dscTarefas) {
		return TarefaService.atualizaTarefas(id, dscTarefas);
	}

	@DeleteMapping("/tarefas/{id}")
	public void ExcluiTarefa(@PathVariable Long id) {
		TarefaService.deleteTarefa(id);
	}

	@GetMapping("/tarefas/fitros")
	public List<Tarefa> buscaTarefasPorStatusUsuario(@RequestParam(required = false) String status,
			@RequestParam(required = false) Long cdUsuario) {
		
		if (status != null) {
			return TarefaService.listaTarefasPorStatus(status);
			
		} else if (cdUsuario != null) {
			Usuario Usuario = new Usuario();
			Usuario.setId(cdUsuario);
			return TarefaService.listaTarefasPorUsuario(Usuario);			
			
		} else {			
			return TarefaService.listaTarefas();
		}
	}
	

}
