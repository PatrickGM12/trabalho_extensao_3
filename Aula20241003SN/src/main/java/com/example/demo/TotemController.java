package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/totem")
@CrossOrigin(origins = "*")
public class TotemController {

    @Autowired
    TotemDAO tdao;

    @PostMapping
    public void incluir(@RequestBody Totem t) {
        tdao.save(t);
    }

    @GetMapping
    public List<Totem> obterTodos() {
        return tdao.findAll();
    }

    @GetMapping("{cd_totem}")
    public Totem Consultar(@PathVariable("cd_totem") Integer cd_totem, HttpServletResponse resp) {
        Optional<Totem> t = tdao.findByCodigo(cd_totem);
        if (t.isPresent()) {
            return t.get(); 
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }
}
