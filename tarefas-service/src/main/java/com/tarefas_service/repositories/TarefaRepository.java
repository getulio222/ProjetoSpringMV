package com.tarefas_service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefas_service.domain.Tarefa;
import com.usuarios_service.domain.Usuario;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
    List<Tarefa> buscarPorStatus(String status);
    
    List<Tarefa> buscarPorUsuario(Usuario usuario);
	

}
