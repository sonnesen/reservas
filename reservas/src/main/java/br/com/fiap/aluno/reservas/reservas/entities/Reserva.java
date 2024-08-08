package br.com.fiap.aluno.reservas.reservas.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="tb_reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String responsavel;
    private String email;
    private int telefone;
    private LocalDateTime inicioDaReserva;
    private String status;
    private int quantidadedeLugares;

    public Reserva() {
    }

    public Reserva(Long id, String responsavel, String email, int telefone, LocalDateTime inicioDaReserva, String status, int quantidadedeLugares) {
        this.id = id;
        this.responsavel = responsavel;
        this.email = email;
        this.telefone = telefone;
        this.inicioDaReserva = LocalDateTime.now();
        this.status = "agendado";
        this.quantidadedeLugares = quantidadedeLugares;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone(){
        return telefone;
    }

    public void setTelefone(int telefone){
        this.telefone = telefone;
    }

    public LocalDateTime getInicioDaReserva(){
        return inicioDaReserva;
    }

    public void setInicioDaReserva(LocalDateTime inicioDaReserva){
        this.inicioDaReserva = inicioDaReserva;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public int getQuantidadedeLugares() { return quantidadedeLugares;}

    public void setQuantidadedeLugares(int quantidadedeLugares) {this.quantidadedeLugares = quantidadedeLugares;}


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Reserva{" +
                "id=" + id +
                ", responsavel='" + responsavel + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", inicioDaReserva='" + inicioDaReserva + '\'' +
                ", status=" + status +
                ", quantidadeDeLugares=" + quantidadedeLugares +
                '}';
    }
}



