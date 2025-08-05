package com.agnjr.Web.controller;


import com.agnjr.Web.exception.RecursoNaoEncontradoException;
import com.agnjr.Web.model.Alarme;
import com.agnjr.Web.model.Manutencao;
import com.agnjr.Web.model.Picador;
import com.agnjr.Web.payload.ManutencaoRequest;
import com.agnjr.Web.payload.PicadorRequest;
import com.agnjr.Web.service.AlarmeService;
import com.agnjr.Web.service.ManutencaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/picadores/manutencao/")
@RequiredArgsConstructor
@Slf4j
public class ManutencaoController {

    private final ManutencaoService manutencaoService;

    @GetMapping("/")
    public ResponseEntity<Page<Manutencao>> findAllManutencaoByCodigoPicador(
            @RequestParam Long codigoPicador,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dataHora").descending());
        Page<Manutencao> pageResult = manutencaoService.getAllByCodigoPicadorPaginado(codigoPicador, pageable);
        return ResponseEntity.ok(pageResult);
    }


    @PostMapping
    public ResponseEntity<Manutencao> salvar(@RequestBody ManutencaoRequest manutencaoRequest) {

        Manutencao manutencaoSalvo = manutencaoService.salvar(manutencaoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(manutencaoSalvo);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            manutencaoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> atualizar(@PathVariable Long id, @RequestBody Manutencao manutencaoAtualizado) {
        try {
            Manutencao manutencao = manutencaoService.atualizar(id, manutencaoAtualizado);
            return ResponseEntity.ok(manutencao);
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }




}
