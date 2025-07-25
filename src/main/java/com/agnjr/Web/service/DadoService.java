
package com.agnjr.Web.service;

import com.agnjr.Web.dto.ConsumoGrafDTO;
import com.agnjr.Web.dto.DadoDTO;
import com.agnjr.Web.dto.HorimetroGrafDTO;
import com.agnjr.Web.model.Dado;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DadoService {

    List<Dado> getAll();

    //List<Dado> getAllByCodigoPicador(long codigo);

    List<Dado> getAllByCodigoPicadorPaginado(long codigoPicador, Pageable pageable);

    Dado getFindTopByCodigoPicadorOrderByDataHoraDesc(long codigoPicador);

    Optional<Dado> getById(Long id);

    Dado salvar(Dado dado);

    List<HorimetroGrafDTO> getHorimetrosPorDia(Long codigoPicador);

    List<ConsumoGrafDTO> getConsumoPorDia(Long codigoPicador);

    List<DadoDTO> buscarHistorico(Long codigoPicador, LocalDateTime inicio, LocalDateTime fim);

}
