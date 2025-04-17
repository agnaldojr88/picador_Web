package com.agnjr.Web.controller;


import com.agnjr.Web.model.Dado;
import com.agnjr.Web.repository.DadoRepository;
import com.agnjr.Web.service.DadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



@RestController
@RequestMapping("/api/dados")
@RequiredArgsConstructor
@Slf4j //Msg de log
public class ColetaController {

    private final DadoService dadoService;

    private static final String API_KEY_ESPERADA = "Ross3t!2ie2kASD2dsak@1eok31";

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok("Ok mundo");
    }



    @PostMapping
    public ResponseEntity<?> receberDados(
            @RequestBody Dado dado,
            @RequestHeader("X-API-KEY") String apiKey) {

        if (!API_KEY_ESPERADA.equals(apiKey)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado!");
        }

        return ResponseEntity.ok(dadoService.salvar(dado));
    }

    /*
    @PostMapping
    public ResponseEntity<Dado> receberDados(@RequestBody Dado dado) {
        Dado salvo = dadoService.salvar(dado);
        //return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        return ResponseEntity.ok(dadoService.salvar(dado));
    }
    */

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(dadoService.getAll());
    }


}
