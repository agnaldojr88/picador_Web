package com.agnjr.Web.repository;

import com.agnjr.Web.model.Alarme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlarmeRepository extends JpaRepository<Alarme, Long> {

    Page<Alarme> findAllByCodigoPicador(long codigo, Pageable pageable);

}