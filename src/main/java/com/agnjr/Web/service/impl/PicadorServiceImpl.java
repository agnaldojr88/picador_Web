package com.agnjr.Web.service.impl;

import com.agnjr.Web.model.Dado;
import com.agnjr.Web.model.Picador;
import com.agnjr.Web.repository.DadoRepository;
import com.agnjr.Web.repository.PicadorRepository;
import com.agnjr.Web.service.DadoService;
import com.agnjr.Web.service.PicadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PicadorServiceImpl implements PicadorService {


    private  final PicadorRepository picadorRepository;

    @Override
    public List<Picador> getAll(){
        return picadorRepository.findAll();
    }

    @Override
    public Optional<Picador> getById(Long id){
        return picadorRepository.findById(id);
    }

    @Override
    public Picador salvar(Picador picador){
        return picadorRepository.save(picador);
    }


}
