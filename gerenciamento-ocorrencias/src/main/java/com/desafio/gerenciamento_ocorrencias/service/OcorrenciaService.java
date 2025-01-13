package com.desafio.gerenciamento_ocorrencias.service;

import com.desafio.gerenciamento_ocorrencias.domain.Ocorrencia;
import com.desafio.gerenciamento_ocorrencias.domain.Usuario;
import com.desafio.gerenciamento_ocorrencias.domain.TipoOcorrencia;
import com.desafio.gerenciamento_ocorrencias.dto.OcorrenciaDTO;
import com.desafio.gerenciamento_ocorrencias.repository.OcorrenciaRepository;
import com.desafio.gerenciamento_ocorrencias.repository.UsuarioRepository;
import com.desafio.gerenciamento_ocorrencias.repository.TipoOcorrenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OcorrenciaService {
    
    private final OcorrenciaRepository ocorrenciaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TipoOcorrenciaRepository tipoOcorrenciaRepository;

    @Transactional
    public OcorrenciaDTO criar(OcorrenciaDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            
        TipoOcorrencia tipoOcorrencia = tipoOcorrenciaRepository.findById(dto.getTipoOcorrenciaId())
            .orElseThrow(() -> new RuntimeException("Tipo de ocorrência não encontrado"));

        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setTitulo(dto.getTitulo());
        ocorrencia.setDescricao(dto.getDescricao());
        ocorrencia.setDataHora(LocalDateTime.now());
        ocorrencia.setStatus("ABERTO");
        ocorrencia.setUsuario(usuario);
        ocorrencia.setTipoOcorrencia(tipoOcorrencia);

        ocorrencia = ocorrenciaRepository.save(ocorrencia);
        return converterParaDTO(ocorrencia);
    }

    public List<OcorrenciaDTO> listarTodas() {
        return ocorrenciaRepository.findAll().stream()
            .map(this::converterParaDTO)
            .toList();
    }

    private OcorrenciaDTO converterParaDTO(Ocorrencia ocorrencia) {
        OcorrenciaDTO dto = new OcorrenciaDTO();
        dto.setId(ocorrencia.getId());
        dto.setTitulo(ocorrencia.getTitulo());
        dto.setDescricao(ocorrencia.getDescricao());
        dto.setDataHora(ocorrencia.getDataHora());
        dto.setStatus(ocorrencia.getStatus());
        dto.setUsuarioId(ocorrencia.getUsuario().getId());
        dto.setTipoOcorrenciaId(ocorrencia.getTipoOcorrencia().getId());
        dto.setTipoOcorrenciaDescricao(ocorrencia.getTipoOcorrencia().getDescricao());
        return dto;
    }
} 