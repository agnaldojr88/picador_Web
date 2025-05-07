
package com.agnjr.Web.service;

import com.agnjr.Web.model.Dado;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DadoService {

    List<Dado> getAll();

    //List<Dado> getAllByCodigoPicador(long codigo);

    List<Dado> getAllByCodigoPicadorPaginado(long codigoPicador, Pageable pageable);

    Dado getFindTopByCodigoPicadorOrderByDataHoraDesc(long codigoPicador);

    Optional<Dado> getById(Long id);

    Dado salvar(Dado dado);


}
