package com.agnjr.Web.util;

import java.util.HashMap;
import java.util.Map;

public class DicionarioAlarmes {

    private static final Map<String, String> alarmes = new HashMap<>();

    static {

        alarmes.put("W1_Bit8", "CAN - ALARME DE COMUNICAÇÃO CAN");
        alarmes.put("W1_Bit9", "R_106");
        alarmes.put("W1_Bit10", "R(3)");
        alarmes.put("W1_Bit11", "R(4)");
        alarmes.put("W1_Bit12", "R(5)");
        alarmes.put("W1_Bit13", "R(7)");
        alarmes.put("W1_Bit14", "R(8)");
        alarmes.put("W1_Bit15", "ALARME BATERIA COM BAIXA CAPACIDADE DE ARRANQUE");
        alarmes.put("W1_Bit0", "ALARME SENSOR EMBREAGEM");
        alarmes.put("W1_Bit1", "ALARME NIVEL COMBUSTIVEL BAIXO IHM");
        alarmes.put("W1_Bit2", "FALHA ALTERNADOR IHM");
        alarmes.put("W1_Bit3", "FALHA PRESSAO DO OLEO IHM");
        alarmes.put("W1_Bit4", "FALHA TEMPERATURA DO MOTOR IHM");
        alarmes.put("W1_Bit5", "ALARME TEMPERATURA DO MOTOR EXCEDIDA");
        alarmes.put("W1_Bit6", "ALARME DE FALHA");
        alarmes.put("W1_Bit7", "ALGUM ALARME ACIONADO");


        alarmes.put("W2_Bit8", "FALHA LINHA DE EMERGÊNCIA");
        alarmes.put("W2_Bit9", "FALHA EMERGENCIA CONT IHM");
        alarmes.put("W2_Bit10", "ALARME DETECTOR DE METAL");
        alarmes.put("W2_Bit11", "CAN - FALHA SENSOR NIVEL AGUA");
        alarmes.put("W2_Bit12", "CAN - ALARME TEMPERATURA ADMISSÃO");
        alarmes.put("W2_Bit13", "CAN - FALHA.NIVEL.BAIXO.AGUA MENOR QUE 50%");
        alarmes.put("W2_Bit14", "FALHA BATERIA INVERTIDA");
        alarmes.put("W2_Bit15", "ALARME NIVEL COMBUSTIVEL BAIXO");
        alarmes.put("W2_Bit0", "ALARME TEMPERATURA ALTA ÓLEO HIDRAÚLICO");
        alarmes.put("W2_Bit1", "FALHA EMBREAGEM PTTECH");
        alarmes.put("W2_Bit2", "R(44)");
        alarmes.put("W2_Bit3", "R");
        alarmes.put("W2_Bit4", "ALARME ROTAÇÃO DO VENTILAODR DO RADIADOR DE ÁGUA SSL60.2");
        alarmes.put("W2_Bit5", "R_6");
        alarmes.put("W2_Bit6", "R_7");
        alarmes.put("W2_Bit7", " R_8");



        alarmes.put("W3_Bit8", "ALARME_F_DISPOSITIVO_SEGURANÇA_70.1");
        alarmes.put("W3_Bit9", "ALARME_F_DISPOSITIVO_SEGURANÇA_70.5");
        alarmes.put("W3_Bit10", "ALARME_F_DISPOSITIVO_SEGURANÇA_71.1 - EMERGÊNCIA_PAINEL");
        alarmes.put("W3_Bit11", "ALARME_F_DISPOSITIVO_SEGURANÇA_71.5 - EMERGÊNCIA_CONTROLE_REMOTO");
        alarmes.put("W3_Bit12", "ALARME_F_DISPOSITIVO_SEGURANÇA_72.1");
        alarmes.put("W3_Bit13", "ALARME_F_DISPOSITIVO_SEGURANÇA_72.5");
        alarmes.put("W3_Bit14", "ALARME_F_DISPOSITIVO_SEGURANÇA_73.1");
        alarmes.put("W3_Bit15", "ALARME_F_DISPOSITIVO_SEGURANÇA_73.5");
        alarmes.put("W3_Bit0", "ALARME_F_DISPOSITIVO_SEGURANÇA_74.1");
        alarmes.put("W3_Bit1", "ALARME_F_DISPOSITIVO_SEGURANÇA_74.5");
        alarmes.put("W3_Bit2", "ALARME_F_DISPOSITIVO_SEGURANÇA_75.1");
        alarmes.put("W3_Bit3", "ALARME_F_DISPOSITIVO_SEGURANÇA_75.5");
        alarmes.put("W3_Bit4", "ALARME_F_DISPOSITIVO_SEGURANÇA_76.1");
        alarmes.put("W3_Bit5", "ALARME_F_DISPOSITIVO_SEGURANÇA_76.5");
        alarmes.put("W3_Bit6", "R(33)");
        alarmes.put("W3_Bit7", "R(38)");


        alarmes.put("W4_Bit8", "R(39)");
        alarmes.put("W4_Bit9", "R(40)");
        alarmes.put("W4_Bit10", "ALARME_STATUS_ROTOR");
        alarmes.put("W4_Bit11", "ALARME RELÉ RL85.3");
        alarmes.put("W4_Bit12", "ALARME RELÉ RL85.1");
        alarmes.put("W4_Bit13", "R(2)");
        alarmes.put("W4_Bit14", "r(11)");
        alarmes.put("W4_Bit15", "ALARME ROTAÇÃO BAIXA");
        alarmes.put("W4_Bit0", "ALARME EMBREAGEM DESACOPLADA");
        alarmes.put("W4_Bit1", "ALARME CALHA SAÍDA PARADA");
        alarmes.put("W4_Bit2", "ALARME TEMPERATURA UNIDADE HIDRAÚLICA - TSH60.2");
        alarmes.put("W4_Bit3", "ALARME NÍVEL BAIXO ÓLEO UNIDADE HIDRAÚLICA - LSL60.3");
        alarmes.put("W4_Bit4", "ALARME VERIFICAR FÚSIVEIS");
        alarmes.put("W4_Bit5", "ALARME DEFEITO FÚSIVEL F10.4");
        alarmes.put("W4_Bit6", "ALARME DEFEITO FÚSIVEL F10.7");
        alarmes.put("W4_Bit7", "ALARME DEFEITO FÚSIVEL F10.8");


        alarmes.put("W5_Bit8", "EMBREAGEM PPTECH - BLOQUEIO TEMPORIZADO");
        alarmes.put("W5_Bit9", "EMBREAGEM PPTECH - SOBRECARGA NA EMBREAGEM");
        alarmes.put("W5_Bit10", "EMBREAGEM PPTECH - FALHA TEMPERATURA DE ÓLEO");
        alarmes.put("W5_Bit11", "EMBREAGEM PPTECH - FILTRO ENTUPIDO");
        alarmes.put("W5_Bit12", "EMBREAGEM PPTECH - FALHA RPM ALTA");
        alarmes.put("W5_Bit13", "EMBREAGEM PPTECH - FALHA BOBINA");
        alarmes.put("W5_Bit14", "EMBREAGEM PPTECH - FALHA SAFETY");
        alarmes.put("W5_Bit15", "EMBREAGEM PPTECH - FALHA PRESSÃO DE ÓLEO");
        alarmes.put("W5_Bit0", "EMBREAGEM PPTECH - FALHA DE COMUNICAÇÃO CAN");
        alarmes.put("W5_Bit1", "R_50");
        alarmes.put("W5_Bit2", "R_51");
        alarmes.put("W5_Bit3", "R_52");
        alarmes.put("W5_Bit4", "R_53");
        alarmes.put("W5_Bit5", "R_54");
        alarmes.put("W5_Bit6", "ALARME CAN ATIVO CODIGO -");
        alarmes.put("W5_Bit7", "ALARME CAN BACKUP CODIGO -");



        alarmes.put("W6_Bit8", "CAN - TEMPERATURA ALTA REFRIGERAÇÃO MOTOR");
        alarmes.put("W6_Bit9", "CAN - NÍVEL BAIXO ÓLEO MOTOR");
        alarmes.put("W6_Bit10", "CAN - NÍVEL ALTO ÓLEO MOTOR");
        alarmes.put("W6_Bit11", "CAN - PRESSÃO BAIXA ÓLEO MOTOR");
        alarmes.put("W6_Bit12", "CAN - FORÇA PERDIDA DEVIDO ALTA TEMPERATURA");
        alarmes.put("W6_Bit13", "CAN - LIMITE DE TEMPERATURA EXCEDIDO");
        alarmes.put("W6_Bit14", "CAN - NÍVEL BAIXO UREA");
        alarmes.put("W6_Bit15", "CAN - DESLIGAMENTO DO MOTOR INICIADO PELO DRIVER INCORRETO");
        alarmes.put("W6_Bit0", "CAN - STATUS DE MEDIÇÃO DO NÍVEL DO ÓLEO DO MOTOR = RESULTADO DE MEDIÇÃO PENDENTE");
        alarmes.put("W6_Bit1", "CAN - STATUS DE MEDIÇÃO DO NÍVEL DO ÓLEO DO MOTOR = CONDIÇÃO NÃO CUMPRIDAS");
        alarmes.put("W6_Bit2", "CAN - STATUS DE MEDIÇÃO DO NÍVEL DO ÓLEO DO MOTOR = ERRO NO SENSOR");
        alarmes.put("W6_Bit3", "CAN - FUGA DE GÁS");
        alarmes.put("W6_Bit4", "CAN - FILTRO DE AR DO MOTOR ENTUPIDO");
        alarmes.put("W6_Bit5", "FALHA MANUTENÇÃO - CONSULTAR ROSSETI");
        alarmes.put("W6_Bit6", "ALARME MANUTENÇÃO PREVENTIVA - HORIMETRO ACIONADO");
        alarmes.put("W6_Bit7", "CAN - ALARME SENSOR DE ÓLEO DO MOTOR");



        alarmes.put("W7_Bit8", "ALARME_BOTÃO AVANCO_EXTRATOR_CONTRAFACA");
        alarmes.put("W7_Bit9", "ALARME_BOTÃO  RETORNO_EXTRATOR_CONTRAFACA");
        alarmes.put("W7_Bit10", "ALARME_BOTÃO  SOBE_PRE_FILTRO_AR TRAVADO/DEFEITO");
        alarmes.put("W7_Bit11", "ALARME_BOTÃO  DESCE_PRE_FILTRO_AR TRAVADO/DEFEITO");
        alarmes.put("W7_Bit12", "ALARME_BOTÃO  ACIONA_EMBREAGEM TRAVADO/DEFEITO");
        alarmes.put("W7_Bit13", "ALARME_BOTÃO  LIGA_SAIDA_CAVACO TRAVADO/DEFEITO");
        alarmes.put("W7_Bit14", "ALARME_BOTÃO  PAINEL_DESLIGA_MOTOR_DIESEL TRAVADO/DEFEITO");
        alarmes.put("W7_Bit15", "ALARME_BOTÃO  DESCE_FLAP_SAIDA TRAVADO/DEFEITO");
        alarmes.put("W7_Bit0", "ALARME_BOTÃO  SOBE_FLAP_SAIDA TRAVADO/DEFEITO");
        alarmes.put("W7_Bit1", "ALARME_BOTÃO  SOBE_BASCULANTE TRAVADO/DEFEITO");
        alarmes.put("W7_Bit2", "ALARME_BOTÃO  DESCE_BASCULANTE TRAVADO/DEFEITO");
        alarmes.put("W7_Bit3", "ALARME_BOTÃO  AVANÇA_CALHA_ENTRADA TRAVADO/DEFEITO");
        alarmes.put("W7_Bit4", "ALARME_BOTÃO  RETORNA_CALHA_ENTRADA TRAVADO/DEFEITO");
        alarmes.put("W7_Bit5", "ALARME_BOTÃO  GIRO_CALHA_SAIDA_P/ESQUERDA TRAVADO/DEFEITO");
        alarmes.put("W7_Bit6", "ALARME_BOTÃO  GIRO_CALHA_SAIDA_P/DIREITA TRAVADO/DEFEITO");
        alarmes.put("W7_Bit7", "ALARME_BOTÃO  CONTROLE_DESL_MOTOR_DIESEL TRAVADO/DEFEITO");



        alarmes.put("W8_Bit8", "ALARME_BOTÃO  LIGA_MOTOR_DIESEL TRAVADO/DEFEITO");
        alarmes.put("W8_Bit9", "ALARME_BOTÃO  SEGUNDA_FUNÇÃO_CONTROLE TRAVADO/DEFEITO");
        alarmes.put("W8_Bit10", "ALARME_BOTÃO  LIGA_BUZINA TRAVADO/DEFEITO");
        alarmes.put("W8_Bit11", "ALARME_BOTÃO  ABRE_CALHA_SAIDA TRAVADO/DEFEITO");
        alarmes.put("W8_Bit12", "ALARME_BOTÃO  FECHA_CALHA_SAIDA TRAVADO/DEFEITO");
        alarmes.put("W8_Bit13", "ALARME_BOTÃO  SOBE_PATOLA_1 TRAVADO/DEFEITO");
        alarmes.put("W8_Bit14", "ALARME_BOTÃO  DESCE_PATOLA_1 TRAVADO/DEFEITO");
        alarmes.put("W8_Bit15", "ALARME_BOTÃO  HABILITA_VELOCIDADE_TRABALHO_1 TRAVADO/DEFEITO");
        alarmes.put("W8_Bit0", "ALARME_BOTÃO  SOBE_PATOLA_2 TRAVADO/DEFEITO");
        alarmes.put("W8_Bit1", "ALARME_BOTÃO  DESCE_PATOLA_2 TRAVADO/DEFEITO");
        alarmes.put("W8_Bit2", "ALARME_BOTÃO  HABILITA_VELOCIDADE_TRABALHO_2 TRAVADO/DEFEITO");
        alarmes.put("W8_Bit3", "ALARME_BOTÃO  HABILITA_CONTROLE_REMOTO_HBSL91.1 TRAVADO/DEFEITO");
        alarmes.put("W8_Bit4", "ALARME_BOTÃO  RESET_SEGURANÇA_HBSL93.1 TRAVADO/DEFEITO");
        alarmes.put("W8_Bit5", "ALARME_BOTÃO  SELEC_VELOC_ALTA_CALHA TRAVADO/DEFEITO");
        alarmes.put("W8_Bit6", "ALARME_BOTÃO  SELEC_VELOC_BAIXA_CALHA TRAVADO/DEFEITO");
        alarmes.put("W8_Bit7", "R(35)");


        alarmes.put("W9_Bit8", "FALHA SENSOR ROTOR - SI70.25");
        alarmes.put("W9_Bit9", "FALHA SENSOR ROTOR - SI70.26");
        alarmes.put("W9_Bit10", "R_107");
        alarmes.put("W9_Bit11", "ALARME 100% CICLOS DO FILTRO DE AR CLEANFIX");
        alarmes.put("W9_Bit12", "ALARME 90% CICLOS DO FILTRO DE AR CLEANFIX");
        alarmes.put("W9_Bit13", "R_110");
        alarmes.put("W9_Bit14", "R_111");
        alarmes.put("W9_Bit15", "R_112");
        alarmes.put("W9_Bit0", "R_113");
        alarmes.put("W9_Bit1", "CAN - STATUS DE WARNING ATIVO - DM1, VERIFICA CÓDIGO SPN E FMI");
        alarmes.put("W9_Bit2", "CAN - STATUS DE STOP ATIVO, DESLIGUE O MOTOR IMEDIATAMENTE - DM1");
        alarmes.put("W9_Bit3", "CAN - ALARME DE COMUNICAÇÃO CAN COM BACKBONE 1 - BB1");
        alarmes.put("W9_Bit4", "R_117");
        alarmes.put("W9_Bit5", "R_118");
        alarmes.put("W9_Bit6", "R_119");
        alarmes.put("W9_Bit7", "R_120");

    }

    public static String getDescricao(String chave) {
        return alarmes.getOrDefault(chave, "Alarme desconhecido");
    }
}
