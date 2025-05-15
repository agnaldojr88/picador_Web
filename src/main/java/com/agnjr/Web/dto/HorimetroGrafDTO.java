package com.agnjr.Web.dto;

import com.agnjr.Web.model.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface HorimetroGrafDTO {
    LocalDate getDia();
    int getHorimetroGeral();
    int getHorimetroProducao();
}