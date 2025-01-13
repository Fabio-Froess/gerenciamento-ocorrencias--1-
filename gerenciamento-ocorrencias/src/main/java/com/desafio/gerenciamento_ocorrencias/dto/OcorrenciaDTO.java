package com.desafio.gerenciamento_ocorrencias.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OcorrenciaDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHora;
    private String status;
    private Long usuarioId;
    private Long tipoOcorrenciaId;
    private String tipoOcorrenciaDescricao;
} 