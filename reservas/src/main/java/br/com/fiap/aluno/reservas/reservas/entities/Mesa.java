package br.com.fiap.aluno.reservas.reservas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tb_mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private int quantidadeDeLugares;
    private boolean estaOcupado;
    private LocalDate inicioDaReserva;
    private LocalDate reservadoAte;

    public Mesa() {
    }

    public Mesa(Long id, int numero, int quantidadeDeLugares, boolean estaOcupado, LocalDate inicioDaReserva, LocalDate reservadoAte) {
        this.id = id;
        this.numero = numero;
        this.quantidadeDeLugares = quantidadeDeLugares;
        this.estaOcupado = estaOcupado;
        this.inicioDaReserva = inicioDaReserva;
        this.reservadoAte = reservadoAte;
    }

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero() {
        this.numero = numero;
    }

    public int getQuantidadeDeLugares() {
        return quantidadeDeLugares;
    }

    public void setQuantidadeDeLugares() {
        this.quantidadeDeLugares = quantidadeDeLugares;
    }

    public boolean getEstaOcupado(){
        return estaOcupado;
    }

    public void setEstaOcupado(){
        this.estaOcupado = estaOcupado;
    }

    public LocalDate getInicioDaReserva(){
        return inicioDaReserva;
    }

    public void setInicioDaReserva(){
        this.inicioDaReserva = inicioDaReserva;
    }

    public LocalDate getReservadoAte(){
        return reservadoAte;
    }

    public void setReservadoAte(){
        this.reservadoAte = reservadoAte;
    }

}
