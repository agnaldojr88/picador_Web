package com.agnjr.Web.dto;

import com.agnjr.Web.model.Role;

public record UserDTO(Long id, String name, String lastName, String email, Role role) {}

