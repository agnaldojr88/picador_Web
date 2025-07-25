
package com.agnjr.Web.service;

import com.agnjr.Web.model.Manutencao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ManutencaoService {

    List<Manutencao> getAll();

    Optional<Manutencao> getById(Long id);

    Manutencao salvar(Manutencao alarme);

    Page<Manutencao> getAllByCodigoPicadorPaginado(Long codigoPicador, Pageable pageable);

}
