package com.agnjr.Web.controller;

import com.agnjr.Web.exception.RecursoNaoEncontradoException;
import com.agnjr.Web.model.User;
import com.agnjr.Web.payload.LoginRequest;
import com.agnjr.Web.payload.RegisterUserRequest;
import com.agnjr.Web.payload.ResponsePayload;
import com.agnjr.Web.payload.UpdateUserRequest;
import com.agnjr.Web.service.AuthService;
import com.agnjr.Web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    private final PasswordEncoder passwordEncoder;

    
    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody LoginRequest loginRequest){

        return ResponseEntity.ok(new ResponsePayload( authService.authenticate(loginRequest)));

    }


    @PostMapping("/users/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest){

        if(authService.register(registerUserRequest)) {
            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Campos inválidos!");
        }
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            userService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/users/update/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) {

        if(authService.update(updateUserRequest)) {
            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Campos inválidos!");
        }
    }


    @GetMapping("/users")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(userService.getAll());
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }


}