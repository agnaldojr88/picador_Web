package com.agnjr.Web.repository;

import com.agnjr.Web.model.Dado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadoRepository extends JpaRepository<Dado, Long> {


}
