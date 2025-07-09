package com.agnjr.Web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Dado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private float var01_nivelCombustivel;
    private float var02_pressaoOleo;
    private float var03_rpm;
    private float var04_tempAguaAref;

    private int var05_horimetroGeralH;
    private int var06_horimetroGeralProducaoH;

    private int var07_horimetroDiarioH;
    private int var08_horimetroGeralM;
    private int var09_horimetroGeralProducaoM;
    private int var10_horimetroDiarioM;

    private float var11_totDiarioConsumoLenta;
    private float var12_totDiarioConsumoProducao;

    private long  codigoPicador;
    private int  var14_horimetroDiarioProducaoH;
    private int  var15_horimetroDiarioProducaoM;
    private long  var16_;
    private long  var17_;
    private long  var18_;

    private int var19_posicaoPedalAcelerador;
    private int var20_;
    private int var21_;
    private int var22_;
    private int var23_;

    private float var24_temperaturaAdmissao;
    private float var25_bateria;
    private float var26_porcentagemTorqueMotor;
    private float var27_pressaoCombustivelMotor;
    private float var28_nivelLiqResfriamento;
    private byte  var29_;
    private byte  var30_;
    private byte  var31_;
    private byte  var32_;
    private byte  var33_;
    private float var34_pressaoAdmissaoArMotor;
    private float var35_temperaturaGasesEscapeMotor;
    private long var36_;
    private int var37_listaFalhasAlarmesW1;
    private int var38_listaFalhasAlarmesW2;
    private int var39_listaFalhasAlarmesW3;
    private int var40_listaFalhasAlarmesW4;
    private int var41_listaFalhasAlarmesW5;
    private int var42_listaFalhasAlarmesW6;
    private int var43_listaFalhasAlarmesW7;
    private int var44_listaFalhasAlarmesW8;
    private int var45_listaFalhasAlarmesW9;
    private long  var46_;
    private long  var47_;
    private long  var48_;
    private long  var49_;
    private long  var50_;

}
