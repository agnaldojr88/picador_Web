package com.agnjr.Web.service.impl;

import com.agnjr.Web.exception.RecursoNaoEncontradoException;
import com.agnjr.Web.model.Manutencao;
import com.agnjr.Web.model.Picador;
import com.agnjr.Web.payload.ManutencaoRequest;
import com.agnjr.Web.payload.PicadorRequest;
import com.agnjr.Web.repository.ManutencaoRepository;
import com.agnjr.Web.service.ManutencaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public Manutencao salvar(ManutencaoRequest request) {

        Manutencao manutencao = new Manutencao();
        manutencao.setHorimetroHora(request.horimetroHora());
        manutencao.setHorimetroMinuto(request.horimetroMinuto());
        manutencao.setCodigoPicador(request.codigoPicador());
        manutencao.setDescricao(request.descricao());
        manutencao.setDataHora(LocalDateTime.now());
        manutencaoRepository.save(manutencao);


        return manutencaoRepository.save(manutencao);
    }


    @Override
    public Page<Manutencao> getAllByCodigoPicadorPaginado(Long codigoPicador, Pageable pageable) {

        return manutencaoRepository.findAllByCodigoPicador(codigoPicador, pageable);

    }



    @Override
    public void deletar(Long id) {
        manutencaoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Registro de manutenção não encontrado com id: " + id));
        manutencaoRepository.deleteById(id);
    }


    @Override
    public Manutencao atualizar(Long id, Manutencao manutencaoAtualizado) {
        if (!manutencaoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Registro de manutenção não encontrado com id: " + id);
        }
        manutencaoAtualizado.setId(id);
        return manutencaoRepository.save(manutencaoAtualizado);
    }




}
