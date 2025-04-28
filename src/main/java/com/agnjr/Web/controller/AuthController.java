package com.agnjr.Web.controller;

import com.agnjr.Web.model.Role;
import com.agnjr.Web.model.User;
import com.agnjr.Web.payload.LoginRequest;
import com.agnjr.Web.payload.RegisterRequest;
import com.agnjr.Web.payload.ResponsePayload;
import com.agnjr.Web.service.AuthService;
import com.agnjr.Web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){

        //authService.register(registerRequest);

        //userService.saveRecord(registerRequest);

        return ResponseEntity.ok(authService.register(registerRequest));
    }


    @GetMapping("/save2")
    public void save2(){

        User user = new User();

        user.setId(null);
        user.setName("Agnaldo");
        user.setLastName("Junior");
        user.setEmail("agnaldo@gmail.com");
        user.setPassword(passwordEncoder.encode("5544690"));
        user.setRole(Role.ADMIN);
        user.setUsername("agnaldo88");


        userService.save(user);



        log.info("User saved");

    }


    @GetMapping("/save")
    public void save(){

        User user = new User();

        user.setId(null);
        user.setName("Agnaldo");
        user.setLastName("Junior");
        user.setEmail("agnaldo@gmail.com");
        user.setPassword(passwordEncoder.encode("5544690"));
        user.setRole(Role.ADMIN);
        user.setUsername("agnaldo88");


        userService.save(user);

        log.info("User saved");

    }
}