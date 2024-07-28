package br.com.fiap.aluno.reservas.reservas.controller;

import br.com.fiap.aluno.reservas.reservas.dto.ReservaDTO;
import br.com.fiap.aluno.reservas.reservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    //injecao de dependencia
    private final ReservaService reservaService;

    // Autowired. passando o controle desta dependencia para o sprin
    @Autowired
    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<Page<ReservaDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "inicioDaReserva")Pageable pageable
            ){
        Page<ReservaDTO> reservasDTO = reservaService.findAll(pageable);
        return ResponseEntity.ok(reservasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Long id){
        ReservaDTO reservaDTO = reservaService.findById(id);
        return ResponseEntity.ok(reservaDTO);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> save(@RequestBody ReservaDTO reservaDTO){
        ReservaDTO savedMesa = reservaService.save(reservaDTO);
        return new ResponseEntity<>(savedMesa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable Long id, @RequestBody ReservaDTO reservaDTO){
        ReservaDTO updatedMesa = reservaService.update(id, reservaDTO);
        return ResponseEntity.ok(updatedMesa);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }






}
