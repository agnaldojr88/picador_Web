package com.agnjr.Web.controller;


import com.agnjr.Web.exception.ObjectNotFoundException;
import com.agnjr.Web.exception.RecursoNaoEncontradoException;
import com.agnjr.Web.model.Picador;
import com.agnjr.Web.payload.LoginRequest;
import com.agnjr.Web.payload.PicadorRequest;
import com.agnjr.Web.payload.ResponsePayload;
import com.agnjr.Web.service.DadoService;
import com.agnjr.Web.service.PicadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/picadores/")
@RequiredArgsConstructor
@Slf4j
public class PicadorController {

    private final PicadorService picadorService;


    //http://localhost:8082/picador/
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(picadorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAll(@PathVariable Long id) {
        return ResponseEntity.ok(picadorService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Picador> salvar(@RequestBody PicadorRequest picadorRequest) {

        Picador picadorSalvo = picadorService.salvar(picadorRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(picadorSalvo);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Picador> atualizar(@PathVariable Long id, @RequestBody Picador picadorAtualizado) {
        try {
            Picador picador = picadorService.atualizar(id, picadorAtualizado);
            return ResponseEntity.ok(picador);
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            picadorService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




}
