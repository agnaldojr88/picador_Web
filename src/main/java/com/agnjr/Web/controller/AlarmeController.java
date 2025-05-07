package com.agnjr.Web.controller;


import com.agnjr.Web.model.Alarme;
import com.agnjr.Web.service.AlarmeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/picadores/alarmes/")
@RequiredArgsConstructor
@Slf4j
public class AlarmeController {

    private final AlarmeService alarmeService;

    @GetMapping("/")
    public ResponseEntity<Page<Alarme>> findAllAlarmesByCodigoPicador(
            @RequestParam Long codigoPicador,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dataHora").descending());
        Page<Alarme> pageResult = alarmeService.getAllByCodigoPicadorPaginado(codigoPicador, pageable);
        return ResponseEntity.ok(pageResult);
    }



}
