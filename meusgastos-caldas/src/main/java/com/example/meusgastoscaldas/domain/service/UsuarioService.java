package com.example.meusgastoscaldas.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meusgastoscaldas.domain.dto.usuario.UsuarioRequestDTO;
import com.example.meusgastoscaldas.domain.dto.usuario.UsuarioResponseDTO;
import com.example.meusgastoscaldas.domain.exception.ResourceNotFoundException;
import com.example.meusgastoscaldas.domain.model.Usuario;
import com.example.meusgastoscaldas.domain.repository.UsuarioRepository;

@Service
public class UsuarioService implements ICRUDService<UsuarioRequestDTO, UsuarioResponseDTO>{

@Autowired
private UsuarioRepository usuarioRepository;
@Autowired
private ModelMapper mapper;

    @Override
    public List<UsuarioResponseDTO> obterTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> mapper.map(usuario, UsuarioResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO obterPorId(Long id) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isEmpty()){
            throw new ResourceNotFoundException("não foi possível encontrar o usuário com o id: " + id);
        }
        return mapper.map(optUsuario.get(), UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO cadastrar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = mapper.map(dto, Usuario.class);
        //encriptar a senha
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario, UsuarioResponseDTO.class);
    }

    @Override
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        obterPorId(id);
        Usuario usuario = mapper.map(dto, Usuario.class);
        usuario.setId(id);
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario, UsuarioResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
        usuarioRepository.deleteById(id);
    }
    
}
