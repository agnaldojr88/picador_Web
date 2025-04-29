package com.agnjr.Web.payload;

import com.agnjr.Web.model.User;

import java.time.LocalDateTime;
import java.util.List;

public record PicadorRequest(long codigoPicador, String nome, LocalDateTime data, String cliente, List<User> users, String cidade, String estado, String pais, String cep) {
}