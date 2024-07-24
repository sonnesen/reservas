package br.com.fiap.aluno.reservas.reservas.service;


// service classe logica onde vai ter a regra de negocio onde vai receber os dados da controller e vai inserir atraves da repository
//
// controller apenas para receber os dados e retornar ao client
// service: toda logica nas operaçoes de negócio na arquitetura de camadas
// repository: faz abstracao do banco de dados para salvar e persistir os dados

import br.com.fiap.aluno.reservas.reservas.dto.MesaDTO;
import br.com.fiap.aluno.reservas.reservas.entities.Mesa;
import br.com.fiap.aluno.reservas.reservas.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


// @service faz com que o spring coloque esta classe no pull de injeção de dependencia
@Service
public class MesaService {

    //fazendo a injeção da repository. declarando o atributo final
    private final MesaRepository mesaRepository;

    //escrevendo o construtor, recebera o repository como parametro, nova forma de fazer injecao de dep.
    // autowired colocara no pull de injecao de dependencia, fazendo com o que o spring tome conta
    @Autowired
    public MesaService(MesaRepository mesaRepository){
        this.mesaRepository = mesaRepository;
    }

    public Page<MesaDTO> findAll(Pageable pageable){
        Page<Mesa> mesas = mesaRepository.findAll(pageable);
        return mesas.map(this::toDTO);
    }

    //public MesaDTO findById(Long id){
    //    Mesa mesa = mesaRepository.findById(id);

    //}

    private MesaDTO toDTO(Mesa mesa) {
        return new MesaDTO(
                mesa.getId(),
                mesa.getNumero(),
                mesa.getQuantidadeDeLugares(),
                mesa.getEstaOcupado(),
                mesa.getInicioDaReserva(),
                mesa.getReservadoAte()
        );
    }

    private Mesa toEntity(MesaDTO mesaDTO){
        return new Mesa(
                mesaDTO.id(),
                mesaDTO.numero(),
                mesaDTO.quantidadeDeLugares(),
                mesaDTO.estaOcupado(),
                mesaDTO.inicioDaReserva(),
                mesaDTO.reservadoAte()
        );
    }


}
