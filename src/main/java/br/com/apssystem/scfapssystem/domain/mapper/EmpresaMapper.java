package br.com.apssystem.scfapssystem.domain.mapper;

import br.com.apssystem.scfapssystem.api.dto.EmpresaDTO;
import br.com.apssystem.scfapssystem.domain.entity.Empresa;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmpresaMapper {

    private final ModelMapper modelMapper;

    public EmpresaDTO toDto(Empresa obj) {
        return modelMapper.map(obj, EmpresaDTO.class);
    }

    public List<EmpresaDTO> toCollectionEntity(List<Empresa> objs) {
        return objs.stream().map(obj -> toDto(obj)).collect(Collectors.toList());
    }

    public Empresa toEntity(EmpresaDTO dto) {
        return modelMapper.map(dto, Empresa.class);
    }

    public void copyToDomainObject(EmpresaDTO dto, Empresa obj) {
        modelMapper.map(dto, obj);
    }

}
