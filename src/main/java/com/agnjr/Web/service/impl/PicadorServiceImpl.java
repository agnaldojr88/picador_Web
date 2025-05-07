package com.agnjr.Web.service.impl;

import com.agnjr.Web.exception.RecursoNaoEncontradoException;
import com.agnjr.Web.model.Dado;
import com.agnjr.Web.model.Picador;
import com.agnjr.Web.payload.PicadorRequest;
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
    public Picador salvar(PicadorRequest picador){


        Picador obj = new Picador();

        obj.setCodigoPicador(picador.codigoPicador());
        obj.setNome(picador.nome());
        obj.setData(picador.data());
        obj.setCliente(picador.cliente());

        obj.setCidade(picador.cidade());
        obj.setEstado(picador.estado());
        obj.setPais(picador.pais());

        obj.setCep(picador.cep());

        obj.setUsers(picador.users());



        return picadorRepository.save(obj);
    }

    @Override
    public Picador getById(Long id) {
        return picadorRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Picador não encontrado com id: " + id));
    }

    @Override
    public Picador getByCodigoPicador(Long codigoPicador) {
        return picadorRepository.getByCodigoPicador(codigoPicador);
    }



    @Override
    public Picador atualizar(Long id, Picador picadorAtualizado) {
        if (!picadorRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Carro não encontrado com id: " + id);
        }
        picadorAtualizado.setId(id);
        return picadorRepository.save(picadorAtualizado);
    }


    @Override
    public void deletar(Long id) {
        picadorRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Carro não encontrado com id: " + id));
        picadorRepository.deleteById(id);
    }



}
