package br.com.apssystem.scfapssystem.domain.mapper;

import br.com.apssystem.scfapssystem.api.dto.EmpresaDTO;
import br.com.apssystem.scfapssystem.domain.entity.Empresa;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EmpresaMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static EmpresaDTO toDto(Empresa obj) {
        return modelMapper.map(obj, EmpresaDTO.class);
    }

    public static List<EmpresaDTO> toCollectionEntity(List<Empresa> objs) {
        return objs.stream().map(obj -> toDto(obj)).collect(Collectors.toList());
    }

    public static Empresa toEntity(EmpresaDTO dto) {
        return modelMapper.map(dto, Empresa.class);
    }

    public static void copyToDomainObject(EmpresaDTO dto, Empresa obj) {
        modelMapper.map(dto, obj);
    }

}
