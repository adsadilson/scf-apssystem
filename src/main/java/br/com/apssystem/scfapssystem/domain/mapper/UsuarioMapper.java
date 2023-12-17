package br.com.apssystem.scfapssystem.domain.mapper;


import br.com.apssystem.scfapssystem.domain.dtos.UsuarioDTO;
import br.com.apssystem.scfapssystem.domain.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    ModelMapper modelMapper = new ModelMapper();

    public Usuario toEntity(UsuarioDTO dto) {
        return modelMapper.map(dto, Usuario.class);
    }

    public List<UsuarioDTO> toCollectionDTO(List<Usuario> usuarios) {
        return usuarios.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UsuarioDTO toDTO(Usuario obj) {
        return modelMapper.map(obj, UsuarioDTO.class);
    }
}


