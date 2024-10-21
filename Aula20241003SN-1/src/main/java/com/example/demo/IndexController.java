package com.example.demo;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private PessoaNet pnet = new LojaCliente().getPessoaNet();
	
	@GetMapping("/")
	public String index(Model model) {
		
		return "index";
	}
	
	
	@GetMapping("/index2")
	public String index2(Model model) {
		try {
			model.addAttribute("pessoas", pnet.obterTodos().execute().body());
		} catch (IOException e) {
			System.out.println("Erro");
		}
		return "index2";
	}
	
	/*
	@GetMapping("/index2/{codigo}")
	public String index2(@PathVariable("codigo") Integer codigo, Model model) {
	    try {
	        model.addAttribute("pessoas", pnet.obter(codigo).execute().body());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "index2";
	}*/
	
	@GetMapping("/index2/{codigo}")
	public String index2(@PathVariable("codigo") Integer codigo, Model model) {
	    try {
	        Object pessoas = pnet.obter(codigo).execute().body();
	        if (pessoas == null) {
	            throw new RuntimeException("Nenhuma pessoa encontrada para o código: " + codigo);
	        }
	        model.addAttribute("pessoas", pessoas);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "erro"; 
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "erro"; 
	    }
	    return "index2";
	}



	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		try {
			model.addAttribute("pessoas", pnet.obterTodos().execute().body());
		} catch (IOException e) {
			System.out.println("Erro");
		}
		return "dashboard";
	}
	
	
	
	@RequestMapping("/erro")
	public String handleError() {
	    return "erro";
	}
	

	
	
}