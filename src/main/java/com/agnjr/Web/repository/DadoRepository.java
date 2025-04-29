package com.agnjr.Web.repository;

import com.agnjr.Web.model.Dado;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DadoRepository extends JpaRepository<Dado, Long> {

    //@Query(value = "SELECT * FROM `dado` WHERE `var13_codigo_picador` >= :codigoPicador", nativeQuery = true)
    //List<Dado> findAllByVar13_codigoPicador(@Param("var13_codigo_picador") long codigoPicador);

    //List<Dado> findAllByCodigoPicador(long codigo);


    List<Dado> findAllByCodigoPicador(long codigo, Pageable pageable);
}
