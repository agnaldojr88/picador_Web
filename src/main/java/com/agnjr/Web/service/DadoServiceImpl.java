package com.agnjr.Web.service;

import com.agnjr.Web.model.Dado;
import com.agnjr.Web.repository.DadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DadoServiceImpl implements DadoService {


    private  final DadoRepository dadoRepository;


    @Override
    public List<Dado> getAll(){
        return dadoRepository.findAll();
    }

    @Override
    public Optional<Dado> getById(Long id){
        return dadoRepository.findById(id);
    }

    @Override
    public Dado salvar(Dado dado){
        return dadoRepository.save(dado);
    }
}
