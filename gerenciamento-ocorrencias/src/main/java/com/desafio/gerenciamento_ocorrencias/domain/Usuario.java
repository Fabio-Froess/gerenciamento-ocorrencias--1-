package com.desafio.gerenciamento_ocorrencias.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String login;
    private String senha;
    
    @OneToMany(mappedBy = "usuario")
    private List<Ocorrencia> ocorrencias;
} 