package com.agnjr.Web.dto;

public record DadoDTO(
        String dataHora,
        float nivelCombustivel,
        float pressaoOleo,
        float rpm,
        float tempAguaAref,

        float totDiarioConsumoLenta,
        float totDiarioConsumoProducao,

        int posicaoPedalAcelerador,

        float temperaturaAdmissao,
        float bateria,
        float porcentagemTorqueMotor,
        float pressaoCombustivelMotor,
        float nivelLiqResfriamento,

        float pressaoAdmissaoArMotor,
        float temperaturaGasesEscapeMotor

) {}