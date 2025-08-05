
package com.agnjr.Web.service;

import com.agnjr.Web.model.Manutencao;
import com.agnjr.Web.model.Picador;
import com.agnjr.Web.payload.ManutencaoRequest;
import com.agnjr.Web.payload.PicadorRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ManutencaoService {

    List<Manutencao> getAll();

    Optional<Manutencao> getById(Long id);

    Manutencao salvar(ManutencaoRequest alarme);

    Page<Manutencao> getAllByCodigoPicadorPaginado(Long codigoPicador, Pageable pageable);

    void deletar(Long id);

    Manutencao atualizar(Long id, Manutencao manutencaoAtualizado);


}
