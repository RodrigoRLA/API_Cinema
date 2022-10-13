package br.com.serratec.trabalho1.cinema.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.trabalho1.cinema.Entity.Genero;

public interface generoRepository extends JpaRepository<Genero, Integer> {

}