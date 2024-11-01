package com.example.demo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {
	
	@Autowired
	PessoaDAO dao;
	
	@PostMapping
	public void incluir(@RequestBody Pessoa p) {
		dao.save(p);
	}
	
	@GetMapping
	public List<Pessoa> obterTodos(){
		return dao.findAll();
	}
	
	@GetMapping("{codigo}")
	public Pessoa obter(@PathVariable("codigo") Integer codigo, HttpServletResponse resp){
		Optional<Pessoa> p = dao.findById(codigo);
		if(p.isPresent())
			return p.get();
		else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	@DeleteMapping("{codigo}")
	public void excluir(@PathVariable Integer codigo, HttpServletResponse resp){
		Optional<Pessoa> p = dao.findById(codigo);
		if(p.isPresent())
			dao.delete(p.get());
		else
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
	
	@PutMapping("{codigo}")
	public void alterar(@PathVariable Integer codigo,@RequestBody Pessoa p, 
			            HttpServletResponse resp) {
		if(Objects.equals(p.codigo, codigo))
			dao.save(p);
		else
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}

}
