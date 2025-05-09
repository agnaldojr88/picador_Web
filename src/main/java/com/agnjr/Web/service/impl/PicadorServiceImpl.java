package com.agnjr.Web.service.impl;

import com.agnjr.Web.exception.ObjectNotFoundException;
import com.agnjr.Web.exception.RecursoNaoEncontradoException;
import com.agnjr.Web.model.Dado;
import com.agnjr.Web.model.Picador;
import com.agnjr.Web.model.User;
import com.agnjr.Web.payload.PicadorRequest;
import com.agnjr.Web.repository.DadoRepository;
import com.agnjr.Web.repository.PicadorRepository;
import com.agnjr.Web.repository.UserRepository;
import com.agnjr.Web.service.DadoService;
import com.agnjr.Web.service.PicadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PicadorServiceImpl implements PicadorService {


    private  final PicadorRepository picadorRepository;
    private  final UserRepository userRepository;

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

        System.out.println(picador.users());


        List<User> users = picador.users().stream()
                .map(userDTO -> userRepository.findById(userDTO.getId()) // Recupera o User completo
                        .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado")))
                .collect(Collectors.toList());


        obj.setUsers(users);



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



    @Override
    public List<Picador> getPicadoresDoUsuario(String username) {
        return picadorRepository.findAllByUsersEmail(username);
    }


}
