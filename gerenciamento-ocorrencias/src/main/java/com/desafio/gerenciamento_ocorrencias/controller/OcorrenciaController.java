package com.desafio.gerenciamento_ocorrencias.controller;

import com.desafio.gerenciamento_ocorrencias.dto.OcorrenciaDTO;
import com.desafio.gerenciamento_ocorrencias.service.OcorrenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ocorrencias")
@RequiredArgsConstructor
public class OcorrenciaController {

    private final OcorrenciaService ocorrenciaService;

    @PostMapping
    public ResponseEntity<OcorrenciaDTO> criar(@RequestBody OcorrenciaDTO ocorrenciaDTO) {
        return ResponseEntity.ok(ocorrenciaService.criar(ocorrenciaDTO));
    }

    @GetMapping
    public ResponseEntity<List<OcorrenciaDTO>> listarTodas() {
        return ResponseEntity.ok(ocorrenciaService.listarTodas());
    }
} 