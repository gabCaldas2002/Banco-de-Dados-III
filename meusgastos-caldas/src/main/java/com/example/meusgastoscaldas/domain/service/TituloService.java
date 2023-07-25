package com.example.meusgastoscaldas.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.meusgastoscaldas.domain.dto.titulos.TituloRequestDTO;
import com.example.meusgastoscaldas.domain.dto.titulos.TituloResponseDTO;
import com.example.meusgastoscaldas.domain.exception.ResourceNotFoundException;
import com.example.meusgastoscaldas.domain.model.Titulo;
import com.example.meusgastoscaldas.domain.model.Usuario;
import com.example.meusgastoscaldas.domain.repository.TituloRepository;

@Service
public class TituloService implements ICRUDService<TituloRequestDTO, TituloResponseDTO>{
    @Autowired
    private TituloRepository tituloRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<TituloResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Titulo> titulos = tituloRepository.findByUsuario(usuario);
        return titulos.stream().map(titulo -> mapper.map(titulo, TituloResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TituloResponseDTO obterPorId(Long id) {
        Optional<Titulo> optTitulo = tituloRepository.findById(id);
        if(optTitulo.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar o título com o id: " + id);
        }
        return mapper.map(optTitulo, TituloResponseDTO.class);
    }

    @Override
    public TituloResponseDTO cadastrar(TituloRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public TituloResponseDTO atualizar(Long id, TituloRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
    
}
