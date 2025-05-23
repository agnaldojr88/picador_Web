package com.agnjr.Web.service;

import com.agnjr.Web.model.User;
import com.agnjr.Web.payload.LoginRequest;
import com.agnjr.Web.payload.RegisterUserRequest;
import com.agnjr.Web.payload.UpdateUserRequest;
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



    public boolean register(RegisterUserRequest registerUserRequest){

        if(validateRegisterRequest(registerUserRequest)) {

            User user = User.builder()
                    .name(registerUserRequest.name())
                    .lastName(registerUserRequest.lastName())
                    .email(registerUserRequest.email())
                    .password(passwordEncoder.encode(registerUserRequest.password()))
                    .role(registerUserRequest.role()).build();
            userService.save(user);
            return true;
        }else{
            return false;
        }
    }

    public boolean update(UpdateUserRequest updateUserRequest){

        if(validateUpdateRequest(updateUserRequest)) {

            User user = User.builder()
                    .id(updateUserRequest.id())
                    .name(updateUserRequest.name())
                    .lastName(updateUserRequest.lastName())
                    .email(updateUserRequest.email())
                    .password(passwordEncoder.encode(updateUserRequest.password()))
                    .role(updateUserRequest.role()).build();
            userService.save(user);
            return true;
        }else{
            return false;
        }
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


    private boolean validateRegisterRequest(RegisterUserRequest request) {

        boolean isValid=true;

        if (request.password().length() <= 6) {
            isValid=false;
            //throw new InvalidAuthException("A senha deve conter mais de 6 caracteres.");
        }

        if (!Pattern.matches(PASSWORD_REGEX, request.password())) {
            isValid=false;
            //throw new InvalidAuthException("A senha deve conter letras e números.");
        }

        if (!Pattern.matches(EMAIL_REGEX, request.email())) {
            isValid=false;
            //throw new InvalidAuthException("Formato do e-mail inválido.");
        }

        if(userService.findByUsernameOrEmail(request.email(), request.email()).isPresent()){
            isValid=false;
            //throw new InvalidAuthException("Já existe um usuário com esse e-mail.");
        }

        return isValid;
    }




    private boolean validateUpdateRequest(UpdateUserRequest request) {

        boolean isValid=true;


        if (request.password().length() <= 6) {
            isValid=false;
            //throw new InvalidAuthException("A senha deve conter mais de 6 caracteres.");
        }

        if (!Pattern.matches(PASSWORD_REGEX, request.password())) {
            isValid=false;
            //throw new InvalidAuthException("A senha deve conter letras e números.");
        }

        return isValid;
    }



}
