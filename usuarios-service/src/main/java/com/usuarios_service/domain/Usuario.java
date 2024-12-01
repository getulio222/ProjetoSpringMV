package com.usuarios_service.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import com.tarefas_service.domain.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Usuario {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "cd_usuario")
	 private Long id;
	 
	 @Column(name = "Nome")
	 private String nome;
	 
	 @Email	 
	 @Column(name = "Email")
	 private String email;
	 
	 @Column(name = "Dt_criacao")	 
	 private LocalDateTime dt_criacao;
	 
	   @OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Tarefa> tarefas;

	    @PrePersist
	    protected void criaDataAuto() {
	        this.dt_criacao = LocalDateTime.now();
	    }

		@Override
		public int hashCode() {
			return Objects.hash(tarefas);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Usuario other = (Usuario) obj;
			return Objects.equals(tarefas, other.tarefas);
		}
	 
	    

	

}
