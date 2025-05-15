package com.agnjr.Web.repository;

import com.agnjr.Web.dto.HorimetroGrafDTO;
import com.agnjr.Web.dto.UserDTO;
import com.agnjr.Web.model.Dado;
import feign.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DadoRepository extends JpaRepository<Dado, Long> {

    //@Query(value = "SELECT * FROM `dado` WHERE `var13_codigo_picador` >= :codigoPicador", nativeQuery = true)
    //List<Dado> findAllByVar13_codigoPicador(@Param("var13_codigo_picador") long codigoPicador);

    //List<Dado> findAllByCodigoPicador(long codigo);


    List<Dado> findAllByCodigoPicador(long codigo, Pageable pageable);


    Dado findTopByCodigoPicadorOrderByDataHoraDesc(Long codigoPicador);


    @Query(value = """
        SELECT 
            DATE(data_hora) AS dia,
            ((MAX(var05_horimetro_geralh) * 60) + MAX(var08_horimetro_geralm)) - 
            ((MIN(var05_horimetro_geralh) * 60) + MIN(var08_horimetro_geralm)) AS horimetroGeral,
            
            ((MAX(var06_horimetro_producaoh) * 60) + MAX(var09_horimetro_producaom)) - 
            ((MIN(var06_horimetro_producaoh) * 60) + MIN(var09_horimetro_producaom)) AS horimetroProducao

        FROM dado
        WHERE codigo_picador = :id
        GROUP BY DATE(data_hora)
        ORDER BY dia
        LIMIT 0,6
        """, nativeQuery = true)
    List<HorimetroGrafDTO> buscarHorimetrosPorDia(@Param("id") Long id);

    /*
    SELECT
      DATE(`data_hora`) AS dia,

      ((MAX(`var05_horimetro_geralh`)*60) + MAX(`var08_horimetro_geralm`)) - ((MIN(`var05_horimetro_geralh`)*60) + MIN(`var08_horimetro_geralm`)) as horimetroGeral,
      ((MAX(`var06_horimetro_producaoh`)*60) + MAX(`var09_horimetro_producaom`)) - ((MIN(`var06_horimetro_producaoh`)*60) + MIN(`var09_horimetro_producaom`)) as horimetroProducao

    FROM dado
    WHERE codigo_picador = {id}
    GROUP BY DATE(`data_hora`)
    ORDER BY dia;

     */



}
