package br.com.serratec.trabalho1.cinema.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.trabalho1.cinema.Entity.Filme;
import br.com.serratec.trabalho1.cinema.Repository.filmeRepository;

@Service
public class filmeService {
	
	@Autowired
	filmeRepository filmeRepository;
	
	
	
	public List<Filme> getAll(){
		return filmeRepository.findAll();
	}
	
	

	public Filme getById (Integer idGenero) {
		return filmeRepository.findById(idGenero).orElse(null);
	}
	
	public Filme save (Filme diretor) {
		return filmeRepository.save(diretor);
	}
	
	public Filme update(Filme filme, Integer id) {
		Filme filmeExistenteNoBanco = filmeRepository.findById(id).get();
		
		filmeExistenteNoBanco.setNome_br(filme.getNome_br());
		filmeExistenteNoBanco.setNome_en(filme.getNome_en());
		filmeExistenteNoBanco.setAno_lancamento(filme.getAno_lancamento());
		filmeExistenteNoBanco.setSinopse(filme.getSinopse());
			
		
		
		return filmeRepository.save(filmeExistenteNoBanco);
	}
	
	public Filme delete (Integer id) {
		filmeRepository.deleteById(id);
		return getById(id);
	}
	
	
	
}