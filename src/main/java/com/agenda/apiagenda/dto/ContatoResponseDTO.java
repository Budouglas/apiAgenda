package com.agenda.apiagenda.dto;

import java.time.LocalDate;

public record ContatoResponseDTO (

        Long id,
        String nome,
        String email,
        String telefone,
        LocalDate dataNascimento
){}
