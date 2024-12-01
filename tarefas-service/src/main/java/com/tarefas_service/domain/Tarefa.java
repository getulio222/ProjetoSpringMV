package com.tarefas_service.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.usuarios_service.domain.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tarefa {
	
	//OBS:. Colocar no ReadMeMD o Requisito Funcional - INSTALAR O LOMBOK .JAR PARA USO DO ECLIPSE
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name = "Cd_tarefa")
	    private Long id;
	 	
	 	@Column(name = "Ds_titulo")
	    private String titulo;
	    
	 	@Column(name = "Ds_descricao")
	    private String descricao;
	    
	 	@Column(name = "Status")
	    private String status;
	    
	 	@Column(name = "dt_criacao")
	    private LocalDateTime dt_criacao;
	    

	    @ManyToOne
	    @JoinColumn(name = "cd_usuario")
	    private Usuario usuario;

	    @PrePersist
	    protected void geraDataAuto() {
	        this.dt_criacao = LocalDateTime.now();
	    }

		@Override
		public String toString() {
			return "Tarefa [titulo=" + titulo + ", descricao=" + descricao + ", status=" + status + ", usuario="
					+ usuario + "]";
		}
		
	    
	    
	}
	


