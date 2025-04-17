
package com.agnjr.Web.service;

import com.agnjr.Web.model.Dado;

import java.util.List;
import java.util.Optional;

public interface DadoService {

    List<Dado> getAll();

    Optional<Dado> getById(Long id);

    Dado salvar(Dado dado);
}
