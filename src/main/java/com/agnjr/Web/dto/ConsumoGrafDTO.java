package com.agnjr.Web.dto;

import java.time.LocalDate;

public interface ConsumoGrafDTO {
    LocalDate getDia();
    float getTotDiarioConsumoLenta();
    float getTotDiarioConsumoProducao();
    float getTotConsumoTotal();
}