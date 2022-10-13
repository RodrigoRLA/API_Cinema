package br.com.serratec.trabalho1.cinema.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trabalho1.cinema.Entity.Filme;
import br.com.serratec.trabalho1.cinema.Service.filmeService;

@RestController
@RequestMapping("/filme")
public class filmeController {

	
	

	@Autowired
	filmeService service;
	
	
	@GetMapping
	public ResponseEntity<List<Filme>> getAll(){ 
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/debug")
	public String getDebug(){ 
		return "O link esta funcionando";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Filme> getById(@PathVariable Integer id) {
		Filme obj = service.getById(id);
		
		if (obj != null) {
			return new ResponseEntity<>(obj,HttpStatus.OK);			
		}
		else {
			return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PostMapping
	public ResponseEntity<Filme> save (@RequestBody Filme obj) {
		return new ResponseEntity<>(service.save(obj),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Filme> update (@RequestBody Filme obj, @PathVariable Integer id) {
		return new ResponseEntity<>(service.update(obj,id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Filme> delete (@PathVariable Integer id) {
		
		Filme obj = service.getById(id);
		
		if (obj == null) {
			return new ResponseEntity<>(service.delete(id),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
	}
	
	
}
