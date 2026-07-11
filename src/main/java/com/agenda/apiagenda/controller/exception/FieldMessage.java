package com.agenda.apiagenda.controller.exception;

public record FieldMessage(
        String fieldname,
        String message
)
{}
