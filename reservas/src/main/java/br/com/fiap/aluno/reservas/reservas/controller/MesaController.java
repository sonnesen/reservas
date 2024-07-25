package br.com.fiap.aluno.reservas.reservas.controller;

import br.com.fiap.aluno.reservas.reservas.dto.MesaDTO;
import br.com.fiap.aluno.reservas.reservas.entities.Mesa;
import br.com.fiap.aluno.reservas.reservas.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mesas")
public class MesaController {
    //injecao de dependencia
    private final MesaService mesaService;

    // Autowired. passando o controle desta dependencia para o sprin
    @Autowired
    public MesaController(MesaService mesaService){
        this.mesaService = mesaService;
    }

    @GetMapping
    public ResponseEntity<Page<MesaDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "numero")Pageable pageable
            ){
        Page<MesaDTO> mesasDTO = mesaService.findAll(pageable);
        return ResponseEntity.ok(mesasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDTO> findById(@PathVariable Long id){
        MesaDTO mesaDTO = mesaService.findById(id);
        return ResponseEntity.ok(mesaDTO);
    }

    @PostMapping
    public ResponseEntity<MesaDTO> save(@RequestBody MesaDTO mesaDTO){
        MesaDTO savedMesa = mesaService.save(mesaDTO);
        return new ResponseEntity<>(savedMesa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MesaDTO> update(@PathVariable Long id, @RequestBody MesaDTO mesaDTO){
        MesaDTO updatedMesa = mesaService.update(id, mesaDTO);
        return ResponseEntity.ok(updatedMesa);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        mesaService.delete(id);
        return ResponseEntity.noContent().build();
    }






}
