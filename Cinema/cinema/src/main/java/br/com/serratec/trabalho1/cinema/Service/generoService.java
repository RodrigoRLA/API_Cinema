package br.com.serratec.trabalho1.cinema.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.trabalho1.cinema.Entity.Genero;
import br.com.serratec.trabalho1.cinema.Repository.generoRepository;

@Service
public class generoService {
	
	@Autowired
	generoRepository generoRepository;
	
	
	
	public List<Genero> getAll(){
		return generoRepository.findAll();
	}
	
	

	public Genero getById (Integer idGenero) {
		return generoRepository.findById(idGenero).orElse(null);
	}
	
	public Genero save (Genero genero) {
		return generoRepository.save(genero);
	}
	
	public Genero update(Genero genero, Integer id) {
		Genero generoExistenteNoBanco = generoRepository.findById(id).get();
		
		generoExistenteNoBanco.setDescricao(genero.getDescricao());
			
		return generoRepository.save(generoExistenteNoBanco);
	}
	
	public Genero delete (Integer id) {
		generoRepository.deleteById(id);
		return getById(id);
	}
	
	
	
}