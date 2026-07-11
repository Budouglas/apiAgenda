package com.agenda.apiagenda.controller;

import com.agenda.apiagenda.dto.ContatoRequestDTO;
import com.agenda.apiagenda.dto.ContatoResponseDTO;
import com.agenda.apiagenda.service.ContatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
    private final ContatoService contatoService;

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> save(@RequestBody @Valid ContatoRequestDTO requestDTO) {
        ContatoResponseDTO responseDTO = contatoService.save(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> findById(@PathVariable Long id) {
        ContatoResponseDTO responseDTO = contatoService.findById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ContatoResponseDTO>> findAll() {
        List<ContatoResponseDTO> contatos = contatoService.findAll();
        return ResponseEntity.ok(contatos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        contatoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> updateById(@PathVariable Long id, @RequestBody @Valid ContatoRequestDTO requestDTO) {
        ContatoResponseDTO responseDTO = contatoService.updateById(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}


