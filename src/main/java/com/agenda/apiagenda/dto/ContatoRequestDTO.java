package com.agenda.apiagenda.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record ContatoRequestDTO(

    @NotBlank(message = "O campo nome é obrigatório")
    @Size(max = 50, message = "O campo nome deve ter no máximo 50 caracteres")
    String nome,

    @NotBlank(message = "O campo email é obrigatório")
    @Email(message = "O campo email deve ser um endereço de email válido")
    @Size(max = 50, message = "O campo email deve ter no máximo 50 caracteres")
    String email,

    @NotBlank(message = "O campo telefone é obrigatório")
    @Size(max = 15, message = "O campo telefone deve ter no máximo 15 caracteres")
    String telefone,

    @NotNull(message = "O campo data de nascimento é obrigatório")
    LocalDate dataNascimento
) {}
