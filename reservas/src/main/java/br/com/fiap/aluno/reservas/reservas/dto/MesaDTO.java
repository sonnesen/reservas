package br.com.fiap.aluno.reservas.reservas.dto;

import java.time.LocalDate;

public record MesaDTO(
        Long id,
        int numero,
        int quantidadeDeLugares,
        boolean estaOcupado,
        LocalDate inicioDaReserva,
        LocalDate reservadoAte
) {
}
