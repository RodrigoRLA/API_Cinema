package br.com.serratec.trabalho1.cinema.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "diretor")
public class Diretor {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_diretor")
	private Integer id_diretor;
	
	@Column(name = "nome")
	private String nome;
	
	@JsonManagedReference(value="diretorMap")
	@OneToMany(mappedBy = "diretor")
	private Set<Filme> filme;

	public Integer getId_diretor() {
		return id_diretor;
	}

	public void setId_diretor(Integer id_diretor) {
		this.id_diretor = id_diretor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Filme> getFilme() {
		return filme;
	}

	public void setFilme(Set<Filme> filme) {
		this.filme = filme;
	}
	
	
}