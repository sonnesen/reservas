package br.com.fiap.aluno.reservas.reservas.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="tb_mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private int quantidadeDeLugares;
    private boolean estaOcupado;
    private LocalDateTime inicioDaReserva;
    private LocalDateTime reservadoAte;

    public Mesa() {
    }

    public Mesa(Long id, int numero, int quantidadeDeLugares, boolean estaOcupado, LocalDateTime inicioDaReserva, LocalDateTime reservadoAte) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantidadeDeLugares() {
        return quantidadeDeLugares;
    }

    public void setQuantidadeDeLugares(int quantidadeDeLugares) {
        this.quantidadeDeLugares = quantidadeDeLugares;
    }

    public boolean getEstaOcupado(){
        return estaOcupado;
    }

    public void setEstaOcupado(boolean estaOcupado){
        this.estaOcupado = estaOcupado;
    }

    public LocalDateTime getInicioDaReserva(){
        return inicioDaReserva;
    }

    public void setInicioDaReserva(LocalDateTime inicioDaReserva){
        this.inicioDaReserva = inicioDaReserva;
    }

    public LocalDateTime getReservadoAte(){
        return reservadoAte;
    }

    public void setReservadoAte(LocalDateTime reservadoAte){
        this.reservadoAte = reservadoAte;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return Objects.equals(id, mesa.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Mesa{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", quantidadeDeLugares='" + quantidadeDeLugares + '\'' +
                ", estaOcupado='" + estaOcupado + '\'' +
                ", inicioDaReserva='" + inicioDaReserva + '\'' +
                ", reservadoAte=" + reservadoAte +
                '}';
    }
}



