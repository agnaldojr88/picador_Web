
package com.agnjr.Web.service;

import com.agnjr.Web.model.Dado;
import com.agnjr.Web.model.Picador;

import java.util.List;
import java.util.Optional;

public interface PicadorService {

    List<Picador> getAll();

    Optional<Picador> getById(Long id);

    Picador salvar(Picador picador);


}
