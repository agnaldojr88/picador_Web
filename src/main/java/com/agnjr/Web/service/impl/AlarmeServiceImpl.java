package com.agnjr.Web.service.impl;

import com.agnjr.Web.model.Alarme;
import com.agnjr.Web.model.Dado;
import com.agnjr.Web.model.Picador;
import com.agnjr.Web.repository.AlarmeRepository;
import com.agnjr.Web.repository.DadoRepository;
import com.agnjr.Web.service.AlarmeService;
import com.agnjr.Web.service.DadoService;
import com.agnjr.Web.service.PicadorService;
import com.agnjr.Web.util.DicionarioAlarmes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlarmeServiceImpl implements AlarmeService {

    private final AlarmeRepository alarmeRepository;


    @Override
    public List<Alarme> getAll() {
        return alarmeRepository.findAll();
    }

    @Override
    public Optional<Alarme> getById(Long id) {
        return alarmeRepository.findById(id);
    }

    @Override
    public Alarme salvar(Alarme alarme) {
        return alarmeRepository.save(alarme);
    }


    @Override
    public Page<Alarme> getAllByCodigoPicadorPaginado(Long codigoPicador, Pageable pageable) {

        return alarmeRepository.findAllByCodigoPicador(codigoPicador, pageable);

    }
}
