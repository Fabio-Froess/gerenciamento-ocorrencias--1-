package com.desafio.gerenciamento_ocorrencias.service;

import com.desafio.gerenciamento_ocorrencias.domain.Usuario;
import com.desafio.gerenciamento_ocorrencias.dto.UsuarioDTO;
import com.desafio.gerenciamento_ocorrencias.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioDTO criar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setLogin(dto.getLogin());
        usuario.setSenha(dto.getSenha());

        usuario = usuarioRepository.save(usuario);
        return converterParaDTO(usuario);
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
            .map(this::converterParaDTO)
            .toList();
    }

    private UsuarioDTO converterParaDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setLogin(usuario.getLogin());
        // Não retornamos a senha no DTO por questões de segurança
        return dto;
    }
} 