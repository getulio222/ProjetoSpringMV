package com.tarefas_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarefas_service.domain.Tarefa;
import com.tarefas_service.repositories.TarefaRepository;
import com.usuarios_service.domain.Usuario;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository TarefaRepository;
	

	public Tarefa criaTarefas(Tarefa Tarefa) {
		return TarefaRepository.save(Tarefa);
	}
	

	public List<Tarefa> listaTarefas() {
		return TarefaRepository.findAll();
	}
	
	
	
	public Tarefa atualizaTarefas(Long id, Tarefa dscTarefa) {
		
		Tarefa Tarefa = TarefaRepository.findById(id)
			   .orElseThrow(() -> new IllegalArgumentException("Tarefa não foi encontrada"));
		
	
		
		if (!Tarefa.getStatus().equals("Pendente") 
				&& !Tarefa.getStatus().equals("Em Andamento")) 
		{
			throw new IllegalArgumentException("Apenas Tarefas com o status 'Pendente' ou 'Em Andamento' não pode ser Editado");
		}
		
		
		Tarefa.setTitulo(dscTarefa.getTitulo());
		Tarefa.setDescricao(dscTarefa.getDescricao());
		Tarefa.setStatus(dscTarefa.getStatus());
		return TarefaRepository.save(Tarefa);
	}
	
	
	public void deleteTarefa(Long id) {
		TarefaRepository.deleteById(id);
	}
	
	
	public List<Tarefa> listaTarefasPorStatus(String status) {
		return TarefaRepository.buscarPorStatus(status);
	}
	
	
	public List<Tarefa> listaTarefasPorUsuario(Usuario usuario) {
		return TarefaRepository.buscarPorUsuario(usuario);
}

}
