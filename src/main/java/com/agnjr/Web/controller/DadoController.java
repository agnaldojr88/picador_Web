package com.agnjr.Web.controller;


import com.agnjr.Web.dto.ConsumoGrafDTO;
import com.agnjr.Web.dto.DadoDTO;
import com.agnjr.Web.dto.HorimetroGrafDTO;
import com.agnjr.Web.service.DadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/picadores/dados/")
@RequiredArgsConstructor
@Slf4j
public class DadoController {

    private final DadoService dadoService;


    /*
    URL: http://localhost:8082/dados/?codigo=452025
    @GetMapping("dados/")
    public ResponseEntity<?> findAllByCodigoPicador(@RequestParam Long codigo) {
        System.out.println(codigo);
        return ResponseEntity.ok(dadoService.getAllByCodigoPicador(codigo));
    }
    */

    //URL: http://localhost:8082/dados/?codigoPicador=452025&page=0&size=10
    @GetMapping("/")
    public ResponseEntity<?> findAllByCodigoPicador(
            @RequestParam long codigoPicador,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dataHora").descending());
        return ResponseEntity.ok(dadoService.getAllByCodigoPicadorPaginado(codigoPicador, pageable));
    }

    @GetMapping("/historico")
    public ResponseEntity<List<DadoDTO>> getHistoricoDados(
            @RequestParam Long codigoPicador,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim
    ) {
        List<DadoDTO> dados = dadoService.buscarHistorico(codigoPicador, dataInicio, dataFim);
        return ResponseEntity.ok(dados);
    }


    //URL: http://localhost:8082/picadores/dados/HorimetrosPorDia/452025
    @GetMapping("/HorimetrosPorDia/{codigoPicador}")
    public ResponseEntity<List<HorimetroGrafDTO>> listarHorimetrosPorDia(@PathVariable Long codigoPicador) {
        List<HorimetroGrafDTO> resultado = dadoService.getHorimetrosPorDia(codigoPicador);
        return ResponseEntity.ok(resultado);
    }


    //URL: http://localhost:8082/picadores/dados/ConsumoPorDia/452025
    @GetMapping("/ConsumoPorDia/{codigoPicador}")
    public ResponseEntity<List<ConsumoGrafDTO>> listarConsumoPorDia(@PathVariable Long codigoPicador) {
        List<ConsumoGrafDTO> resultado = dadoService.getConsumoPorDia(codigoPicador);
        return ResponseEntity.ok(resultado);
    }



    /*
    //http://localhost:8082/dados/findTop/?codigoPicador=452025
    @GetMapping("dados/findTop/")
    public ResponseEntity<?> findTopByCodigoPicadorOrderByDataHoraDesc(
            @RequestParam long codigoPicador,
            @RequestParam(defaultValue = "0") int page
    ) {
        return ResponseEntity.ok(dadoService.getFindTopByCodigoPicadorOrderByDataHoraDesc(codigoPicador));
    }
    */


}
