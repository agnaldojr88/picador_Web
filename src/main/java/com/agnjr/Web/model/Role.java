package com.agnjr.Web.model;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name(); // já vem com "ROLE_" no nome
    }
}

