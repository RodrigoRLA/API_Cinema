package br.com.serratec.trabalho1.cinema.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.trabalho1.cinema.Entity.Diretor;

public interface diretorRepository extends JpaRepository<Diretor, Integer> {

}