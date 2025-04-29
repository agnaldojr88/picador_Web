package com.agnjr.Web.payload;

import com.agnjr.Web.model.Role;
import com.agnjr.Web.model.User;

import java.time.LocalDateTime;
import java.util.List;

public record RegisterPicador(long codigoPicador, String nome, LocalDateTime data, String cliente, List<User> users) {

}
