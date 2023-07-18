package com.example.meusgastoscaldas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meusgastoscaldas.domain.dto.centrodecusto.CentroDeCustoRequestDTO;
import com.example.meusgastoscaldas.domain.dto.centrodecusto.CentroDeCustoResponseDTO;
import com.example.meusgastoscaldas.domain.service.CentroDeCustoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/centrodecustos")
public class CentroDeCustoController {
    @Autowired
    private CentroDeCustoService centroDeCustoService;

    @GetMapping
    public ResponseEntity<List<CentroDeCustoResponseDTO>> obterTodos(){
        return ResponseEntity.ok(centroDeCustoService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CentroDeCustoResponseDTO>> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(centroDeCustoService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<CentroDeCustoResponseDTO> cadastrar(@RequestBody CentroDeCustoRequestDTO dto){
        CentroDeCustoResponseDTO responseDTO = centroDeCustoService.cadastrar(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    
}
