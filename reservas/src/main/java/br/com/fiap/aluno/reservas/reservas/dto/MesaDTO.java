package br.com.fiap.aluno.reservas.reservas.dto;

import java.time.LocalDateTime;

public record MesaDTO(
        Long id,
        int numero,
        int quantidadeDeLugares,
        boolean estaOcupado,
        LocalDateTime inicioDaReserva,
        LocalDateTime reservadoAte
) {
}
