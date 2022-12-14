package br.com.serratec.trabalho1.cinema.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "filme")
public class Filme {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_filme")
	private Integer id_filme;
	
	@Column(name = "nome_br")
	private String nome_br;
	
	@Column(name = "nome_en")
	private String nome_en;
	
	@Column(name = "ano_lancamento")
	private String ano_lancamento;
	
	@Column(name = "sinopse")
	private String sinopse;
	
	@JsonBackReference(value="diretorMap")
	@ManyToOne
	@JoinColumn(name = "id_diretor", referencedColumnName = "id_diretor")
	private Diretor diretor;
	
	@JsonBackReference(value="generoMap")
	@ManyToOne
	@JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
	private Genero genero;

	public Integer getId_filme() {
		return id_filme;
	}

	public void setId_filme(Integer id_filme) {
		this.id_filme = id_filme;
	}

	public String getNome_br() {
		return nome_br;
	}

	public void setNome_br(String nome_br) {
		this.nome_br = nome_br;
	}

	public String getNome_en() {
		return nome_en;
	}

	public void setNome_en(String nome_en) {
		this.nome_en = nome_en;
	}

	public String getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(String ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	

	
	
}