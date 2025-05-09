package com.agnjr.Web.service;

import com.agnjr.Web.dto.UserDTO;
import com.agnjr.Web.exception.RecursoNaoEncontradoException;
import com.agnjr.Web.model.User;
import com.agnjr.Web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {



    private final UserRepository userRepository;



    public List<UserDTO> getAll(){
        return userRepository.getAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional<User> findByUsernameOrEmail(String username, String email){
        return userRepository.findByUsernameOrEmail(username, email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByEmail(username).orElseThrow(()
                -> new UsernameNotFoundException("User not found with username: " + username));
    }


    public void deletar(Long id) {
        userRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com id: " + id));
        userRepository.deleteById(id);
    }

    /*
    public User atualizar(Long id, User userAtualizado) {
        if (!userRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("User não encontrado com id: " + id);
        }

        User user = User.builder()
                .id(userAtualizado.getId())
                .name(userAtualizado.getName())
                .lastName(userAtualizado.getLastName())
                .email(userAtualizado.getEmail())
                .password(passwordEncoder.encode(userAtualizado.getPassword()))
                .role(userAtualizado.getRole())
                .build();


        return userRepository.save(user);
    }
    */


    /*

    if(validateRegisterRequest(registerRequest)) {

            User user = User.builder()
                    .name(registerRequest.name())
                    .lastName(registerRequest.lastName())
                    .email(registerRequest.email())
                    .password(passwordEncoder.encode(registerRequest.password()))
                    .role(registerRequest.role()).build();
            userService.save(user);
            return true;
        }else{
            return false;
        }

     */


}
