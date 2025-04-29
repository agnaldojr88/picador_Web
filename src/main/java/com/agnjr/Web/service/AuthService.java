package com.agnjr.Web.service;

import com.agnjr.Web.exception.InvalidAuthException;
import com.agnjr.Web.model.User;
import com.agnjr.Web.payload.LoginRequest;
import com.agnjr.Web.payload.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d).+$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";


    public User register(RegisterRequest registerRequest){

        validateRegisterRequest(registerRequest);

        User user = User.builder()
                .name(registerRequest.username())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(registerRequest.role()).build();
        return userService.save(user);
    }
    public String authenticate(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        Authentication authenticate = authenticationManager.authenticate(userAuth);
        User usuarioAutenticado = (User) authenticate.getPrincipal();
        return jwtService.generateToken(usuarioAutenticado, getRoles(authenticate.getAuthorities()));

    }
    public List<String> getRoles(Collection<? extends GrantedAuthority> authorities){
        return authorities.stream().map(GrantedAuthority::getAuthority).toList();
    }


    private void validateRegisterRequest(RegisterRequest request) {
        if (request.password().length() <= 6) {
            throw new InvalidAuthException("A senha deve conter mais de 6 caracteres.");
        }

        if (!Pattern.matches(PASSWORD_REGEX, request.password())) {
            throw new InvalidAuthException("A senha deve conter letras e números.");
        }

        if (!Pattern.matches(EMAIL_REGEX, request.email())) {
            throw new InvalidAuthException("Formato do e-mail inválido.");
        }

        if(userService.findByUsernameOrEmail(request.username(), request.email()).isPresent()){
            throw new InvalidAuthException("E-mail ou Username já cadastrado.");
        }

    }



}
