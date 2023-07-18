package com.example.meusgastoscaldas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meusgastoscaldas.domain.model.CentroDeCusto;
import com.example.meusgastoscaldas.domain.model.Usuario;

public interface CentroDeCustoRepository extends JpaRepository<CentroDeCusto, Long>{
    List<CentroDeCusto> findByUsuario(Usuario usuario);
        
}
