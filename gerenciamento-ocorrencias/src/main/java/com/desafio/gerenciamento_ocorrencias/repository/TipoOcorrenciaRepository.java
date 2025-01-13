package com.desafio.gerenciamento_ocorrencias.repository;

import com.desafio.gerenciamento_ocorrencias.domain.TipoOcorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoOcorrenciaRepository extends JpaRepository<TipoOcorrencia, Long> {
} 