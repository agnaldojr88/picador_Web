package com.agnjr.Web.repository;

import com.agnjr.Web.model.Picador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PicadorRepository extends JpaRepository<Picador, Long> {

    List<Picador> findByUsersId(Long userId);

    Picador getByCodigoPicador(Long codigoPicador);
}