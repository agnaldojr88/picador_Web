package com.agnjr.Web.repository;

import com.agnjr.Web.model.Manutencao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

    Page<Manutencao> findAllByCodigoPicador(long codigo, Pageable pageable);

}