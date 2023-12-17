package br.com.apssystem.scfapssystem.domain.mapper;

import br.com.apssystem.scfapssystem.domain.dtos.GrupoUsuarioDTO;
import br.com.apssystem.scfapssystem.domain.entity.GrupoUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GrupoUsuarioMapper {

    ModelMapper modelMapper = new ModelMapper();

    public GrupoUsuarioDTO toDTO(GrupoUsuario grupo) {
        return modelMapper.map(grupo, GrupoUsuarioDTO.class);
    }

    public GrupoUsuario toEntity(GrupoUsuarioDTO dto) {
        return modelMapper.map(dto, GrupoUsuario.class);
    }

    public List<GrupoUsuarioDTO> toCollectionDTO(List<GrupoUsuario> grupos) {
        return grupos.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
