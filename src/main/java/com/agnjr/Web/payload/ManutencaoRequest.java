package com.agnjr.Web.payload;


import java.time.LocalDateTime;

public record ManutencaoRequest(String descricao, long codigoPicador, long horimetroHora, long horimetroMinuto) {
}