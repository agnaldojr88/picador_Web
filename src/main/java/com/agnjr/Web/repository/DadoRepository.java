package com.agnjr.Web.repository;

import com.agnjr.Web.dto.ConsumoGrafDTO;
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
            ((MAX(var07_horimetro_diarioh) * 60) + MAX(var10_horimetro_diariom)) - 
            ((MIN(var07_horimetro_diarioh) * 60) + MIN(var10_horimetro_diariom)) AS horimetroGeral,
            
            ((MAX(var14_horimetro_diario_producaoh) * 60) + MAX(var15_horimetro_diario_producaom)) - 
            ((MIN(var14_horimetro_diario_producaoh) * 60) + MIN(var15_horimetro_diario_producaom)) AS horimetroProducao

        FROM dado
        WHERE codigo_picador = :id
        GROUP BY DATE(data_hora)
        ORDER BY dia DESC
        LIMIT 0,6
        """, nativeQuery = true)
    List<HorimetroGrafDTO> buscarHorimetrosPorDia(@Param("id") Long id);




    @Query(value = """
        SELECT 
            DATE(data_hora) AS dia,
                    
            MAX(var11_tot_diario_consumo_lenta) as totDiarioConsumoLenta,
            MAX(var12_tot_diario_consumo_producao) as totDiarioConsumoProducao,
            MAX(var11_tot_diario_consumo_lenta) + MAX(var12_tot_diario_consumo_producao) as totConsumoTotal
           
        FROM dado
        WHERE codigo_picador = :id
        GROUP BY DATE(data_hora)
        ORDER BY dia DESC
        LIMIT 0,6
        """, nativeQuery = true)
    List<ConsumoGrafDTO> buscaConsumoPorDia(@Param("id") Long id);







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
