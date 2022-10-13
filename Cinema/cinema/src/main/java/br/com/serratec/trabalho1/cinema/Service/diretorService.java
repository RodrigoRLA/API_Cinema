package br.com.serratec.trabalho1.cinema.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.serratec.trabalho1.cinema.Entity.Diretor;
import br.com.serratec.trabalho1.cinema.Repository.diretorRepository;

@Service
public class diretorService {

	
	@Autowired
	diretorRepository diretorRepository;
	
	
	
	public List<Diretor> getAll(){
		return diretorRepository.findAll();
	}
	
	public Diretor getById (Integer idDiretor) {
		return diretorRepository.findById(idDiretor).orElse(null);
	}
	
	public Diretor save (Diretor diretor) {
		return diretorRepository.save(diretor);
	}
	
	public Diretor update(Diretor diretor, Integer id) {
		Diretor diretorExistenteNoBanco = diretorRepository.findById(id).get();
		
		diretorExistenteNoBanco.setNome(diretor.getNome());
			
		return diretorRepository.save(diretorExistenteNoBanco);
	}
	
	public Diretor delete (Integer id) {
		diretorRepository.deleteById(id);
		return getById(id);
	}
}
