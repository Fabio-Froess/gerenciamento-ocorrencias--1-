package com.desafio.gerenciamento_ocorrencias.repository;

import com.desafio.gerenciamento_ocorrencias.domain.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    List<Ocorrencia> findByUsuarioId(Long usuarioId);
} 