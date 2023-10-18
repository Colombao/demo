package br.org.catolicasc.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.catolicasc.demo.dto.AgendaDTO;
import br.org.catolicasc.demo.entity.AgendaEntity;
import br.org.catolicasc.demo.repository.AgendaRepository;


@Controller
@RequestMapping("home")
public class HomeController {


    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping
    public ResponseEntity<Resource> getHome() throws IOException {
        Resource resource = new ClassPathResource("templates/home.html");
        return ResponseEntity.ok()
                .contentLength(resource.contentLength())
                .body(resource);
    }

    @PostMapping
    public void postMethodName(@RequestBody AgendaDTO agendaDTO) {

      agendaRepository.save(new AgendaEntity(null, agendaDTO.titulo(), agendaDTO.local(), null));
    }

}
