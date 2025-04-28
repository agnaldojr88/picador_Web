package com.agnjr.Web.repository;

import com.agnjr.Web.model.Picador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PicadorRepository extends JpaRepository<Picador, Long> {
}