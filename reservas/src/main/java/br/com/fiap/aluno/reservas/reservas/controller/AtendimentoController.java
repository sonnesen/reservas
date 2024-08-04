package br.com.fiap.aluno.reservas.reservas.controller;

import br.com.fiap.aluno.reservas.reservas.dto.ReservaDTO;
import br.com.fiap.aluno.reservas.reservas.entities.AtendimentoFormulario;
import br.com.fiap.aluno.reservas.reservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    private final ReservaService reservaService;
    private Integer opa;

    @Autowired
    public AtendimentoController(ReservaService reservaService) {this.reservaService = reservaService;}

    @PostMapping
    public ResponseEntity<ReservaDTO> retornaReservaLiberada(@RequestBody Integer quantidadeLugaresMesaLiberada, @PageableDefault(size = 10, page = 0, sort = "inicioDaReserva") Pageable pageable){

        Page<ReservaDTO> reservasDTO = reservaService.findAll(pageable);
        Long opa = 0L;

        for (int i = 0; i < reservasDTO.getTotalElements(); i++){

            if (reservasDTO.getContent().get(i).status().equals("aguardando") && reservasDTO.getContent().get(i).quantidadeDeLugares() <= quantidadeLugaresMesaLiberada) {
                System.out.println(i);

                ResponseEntity.ok(reservaService.efetiva(reservasDTO.getContent().get(i).id()));
                opa = reservasDTO.getContent().get(i).id();

                break;
            }
        }

        ReservaDTO reservaDTO = reservaService.findById(opa);
        return ResponseEntity.ok(reservaDTO);
    }

}
