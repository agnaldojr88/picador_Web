
package com.agnjr.Web.service;

import com.agnjr.Web.model.Alarme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AlarmeService {

    List<Alarme> getAll();

    Optional<Alarme> getById(Long id);

    Alarme salvar(Alarme alarme);

    Page<Alarme> getAllByCodigoPicadorPaginado(Long codigoPicador, Pageable pageable);

}
