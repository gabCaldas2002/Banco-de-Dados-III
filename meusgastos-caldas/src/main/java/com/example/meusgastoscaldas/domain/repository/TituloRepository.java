package com.example.meusgastoscaldas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meusgastoscaldas.domain.model.Titulo;
import com.example.meusgastoscaldas.domain.model.Usuario;

public interface TituloRepository extends JpaRepository<Titulo, Long>{
    List<Titulo> findByUsuario(Usuario usuario);
    
}
