package com.agnjr.Web.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Picador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long codigoPicador;
    private String nome;
    private LocalDateTime data;
    private String cliente;

    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    //@ManyToOne
    //@JoinColumn(name = "usuario_id")
    //private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "picador_user",
            joinColumns = @JoinColumn(name = "picador_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;


}
