package br.com.fiap.aluno.reservas.reservas.dto;

import java.time.LocalDateTime;

public record ReservaDTO(
        Long id,
        String responsavel,
        String email,
        String telefone,
        LocalDateTime inicioDaReserva,
        String status,
        int quantidadeDeLugares
) {
}
