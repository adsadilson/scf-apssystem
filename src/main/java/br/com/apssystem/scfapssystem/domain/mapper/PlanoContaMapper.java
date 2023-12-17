package br.com.apssystem.scfapssystem.domain.mapper;

import br.com.apssystem.scfapssystem.domain.dtos.PlanoContaDTO;
import br.com.apssystem.scfapssystem.domain.entity.PlanoConta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanoContaMapper {

    ModelMapper modelMapper = new ModelMapper();

    public PlanoConta toEntity(PlanoContaDTO dto) {
        return modelMapper.map(dto, PlanoConta.class);
    }

    public List<PlanoContaDTO> toCollectionDTO(List<PlanoConta> dtos) {
        return dtos.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PlanoContaDTO toDTO(PlanoConta obj) {
        return modelMapper.map(obj, PlanoContaDTO.class);
    }

}
