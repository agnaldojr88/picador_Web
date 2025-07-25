package com.agnjr.Web.service.impl;

import com.agnjr.Web.model.Manutencao;
import com.agnjr.Web.repository.ManutencaoRepository;
import com.agnjr.Web.service.ManutencaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManutencaoServiceImpl implements ManutencaoService {

    private final ManutencaoRepository manutencaoRepository;

    @Override
    public List<Manutencao> getAll() {
        return manutencaoRepository.findAll();
    }

    @Override
    public Optional<Manutencao> getById(Long id) {
        return manutencaoRepository.findById(id);
    }

    @Override
    public Manutencao salvar(Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }


    @Override
    public Page<Manutencao> getAllByCodigoPicadorPaginado(Long codigoPicador, Pageable pageable) {

        return manutencaoRepository.findAllByCodigoPicador(codigoPicador, pageable);

    }
}
