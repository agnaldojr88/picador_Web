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

    private double codigoPicador;
    private String nome;
    private LocalDateTime data;
    private String cliente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;



}
