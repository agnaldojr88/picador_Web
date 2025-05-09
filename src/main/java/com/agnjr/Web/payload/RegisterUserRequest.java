package com.agnjr.Web.payload;

import com.agnjr.Web.model.Role;

public record RegisterUserRequest(String name, String lastName, String email, String password, Role role) {

}
