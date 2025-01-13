package com.desafio.gerenciamento_ocorrencias.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String login;
    private String senha;
} 