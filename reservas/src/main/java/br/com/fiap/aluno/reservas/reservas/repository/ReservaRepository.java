package br.com.fiap.aluno.reservas.reservas.repository;

import br.com.fiap.aluno.reservas.reservas.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;


// abstrai a comunicacao com o banco de dados
//passa para o jpa a entidade mesa e o long para representar o Id
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
