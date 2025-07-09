package com.agnjr.Web.service.impl;

import com.agnjr.Web.dto.HorimetroGrafDTO;
import com.agnjr.Web.model.Alarme;
import com.agnjr.Web.model.Dado;
import com.agnjr.Web.model.Picador;
import com.agnjr.Web.repository.AlarmeRepository;
import com.agnjr.Web.repository.DadoRepository;
import com.agnjr.Web.service.AlarmeService;
import com.agnjr.Web.service.DadoService;
import com.agnjr.Web.service.PicadorService;
import com.agnjr.Web.util.DicionarioAlarmes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DadoServiceImpl implements DadoService {

    private final DadoRepository dadoRepository;
    private final AlarmeService alarmeService;
    private final PicadorService picadorService;

    @Override
    public List<Dado> getAll(){
        return dadoRepository.findAll();
    }

    /*
    @Override
    public List<Dado> getAllByCodigoPicador(long codigo) {
        return dadoRepository.findAllByCodigoPicador(codigo);
    }*/

    @Override
    public List<Dado> getAllByCodigoPicadorPaginado(long codigoPicador, Pageable pageable) {
        return dadoRepository.findAllByCodigoPicador(codigoPicador, pageable);
    }

    @Override
    public Dado getFindTopByCodigoPicadorOrderByDataHoraDesc(long codigoPicador) {
        return dadoRepository.findTopByCodigoPicadorOrderByDataHoraDesc(codigoPicador);
    }

    @Override
    public Optional<Dado> getById(Long id){
        return dadoRepository.findById(id);
    }

    @Override
    public List<HorimetroGrafDTO> getHorimetrosPorDia(Long codigoPicador) {
        return dadoRepository.buscarHorimetrosPorDia(codigoPicador);
    }




    @Override
    public Dado salvar(Dado dado) {



            Dado ultimo = getFindTopByCodigoPicadorOrderByDataHoraDesc(dado.getCodigoPicador());

            if (ultimo != null) {

                for (int i = 1; i <= 9; i++) {
                    compararBits(
                            getValorPorIndice(ultimo, i),
                            getValorPorIndice(dado, i),
                            i,
                            dado.getCodigoPicador(),
                            dado.getDataHora()
                    );
                }

            }

            return dadoRepository.save(dado);


    }

    /**
     * Método que retorna o valor correto conforme o índice de 1 a 9
     */
    private int getValorPorIndice(Dado dado, int indice) {
        switch (indice) {
            case 1: return dado.getVar37_listaFalhasAlarmesW1();
            case 2: return dado.getVar38_listaFalhasAlarmesW2();
            case 3: return dado.getVar39_listaFalhasAlarmesW3();
            case 4: return dado.getVar40_listaFalhasAlarmesW4();
            case 5: return dado.getVar41_listaFalhasAlarmesW5();
            case 6: return dado.getVar42_listaFalhasAlarmesW6();
            case 7: return dado.getVar43_listaFalhasAlarmesW7();
            case 8: return dado.getVar44_listaFalhasAlarmesW8();
            case 9: return dado.getVar45_listaFalhasAlarmesW9();
            default: throw new IllegalArgumentException("Índice inválido: " + indice);
        }
    }

    /**
     * Método que compara dois valores e imprime as diferenças bit a bit
     */
    private void compararBits(int valorAntigo, int valorNovo, int wordIndex, long codigoPicador, LocalDateTime dataHoraEvento) {

        String identificador = "";

        if (valorAntigo != valorNovo) {
            for (int i = 0; i < 16; i++) {
                int bitAntigo = (valorAntigo >> i) & 1;
                int bitNovo = (valorNovo >> i) & 1;

                if (bitAntigo != bitNovo) {

                    identificador = "W" + wordIndex + "_Bit" + i;

                    //System.out.println("Word W" + wordIndex + " - Bit " + i + " mudou de " + bitAntigo + " para " + bitNovo);

                    Alarme alarme = new Alarme();
                    alarme.setDescricao(DicionarioAlarmes.getDescricao(identificador));
                    alarme.setValor(bitNovo == 1);
                    alarme.setDataHora(LocalDateTime.now());
                    alarme.setCodigoPicador(codigoPicador);
                    alarme.setDataHoraEvento(dataHoraEvento);
                    alarme.setIdentificador(identificador);
                    alarmeService.salvar(alarme);

                    System.out.println("Alarme gravado: " + alarme.getDescricao() + " | Picador: " + codigoPicador);

                }
            }
        }
    }























}
