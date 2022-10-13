package br.com.serratec.trabalho1.cinema.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.trabalho1.cinema.Entity.Filme;

public interface filmeRepository extends JpaRepository<Filme, Integer> {

}