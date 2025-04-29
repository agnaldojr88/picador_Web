
package com.agnjr.Web.service;

import com.agnjr.Web.model.Dado;
import com.agnjr.Web.model.Picador;
import com.agnjr.Web.payload.PicadorRequest;

import java.util.List;
import java.util.Optional;

public interface PicadorService {

    List<Picador> getAll();

    Picador getById(Long id);

    Picador salvar(PicadorRequest picador);


}
