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


import br.com.serratec.trabalho1.cinema.Entity.Genero;
import br.com.serratec.trabalho1.cinema.Service.generoService;

@RestController
@RequestMapping("/genero")
public class generoController {

	@Autowired
	generoService service;
	
	@GetMapping("/debug")
	public String getDebug(){ 
		return "O link esta funcionando";
	}
	
	
	@GetMapping
	public ResponseEntity<List<Genero>> getAll(){ 
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genero> getById(@PathVariable Integer id) {
		Genero obj = service.getById(id);
		
		if (obj != null) {
			return new ResponseEntity<>(obj,HttpStatus.OK);			
		}
		else {
			return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PostMapping
	public ResponseEntity<Genero> save (@RequestBody Genero obj) {
		return new ResponseEntity<>(service.save(obj),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Genero> update (@RequestBody Genero obj, @PathVariable Integer id) {
		return new ResponseEntity<>(service.update(obj,id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Genero> delete (@PathVariable Integer id) {
		
		Genero obj = service.getById(id);
		
		if (obj == null) {
			return new ResponseEntity<>(service.delete(id),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
	}
	
	
}