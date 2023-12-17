package br.com.apssystem.scfapssystem.domain.service;

import br.com.apssystem.scfapssystem.api.exceptions.NegocioException;
import br.com.apssystem.scfapssystem.domain.dtos.PlanoContaDTO;
import br.com.apssystem.scfapssystem.domain.entity.PlanoConta;
import br.com.apssystem.scfapssystem.domain.entity.PlanoContaFilter;
import br.com.apssystem.scfapssystem.domain.mapper.PlanoContaMapper;
import br.com.apssystem.scfapssystem.domain.repository.PlanoContaRepository;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class PlanoContaService {

    private PlanoContaRepository repository;
    private PlanoContaMapper mapper;

    public void salvar(PlanoContaDTO dto) {
        try {
            repository.save(mapper.toEntity(dto));
        } catch (Exception ex) {
            if (ex.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex
                        .getCause();
                if (constraintViolationException.getCause().getMessage().contains("duplicate"))
                    throw new NegocioException("Registro já cadastrado.");
            }
            throw new NegocioException(ex.getMessage());
        }
    }

    public PlanoContaDTO buscarPorIdDTO(UUID id) {
        return mapper.toDTO(buscarPorUuid(id));
    }

    public PlanoConta buscarPorUuid(UUID id) {
        var obj = repository.findById(id);
        if (obj.isPresent())
            return obj.get();

        throw new NegocioException(format("Registro [%s] não encontrado.", id));
    }

    public List<PlanoContaDTO> listarTodos() {
        return mapper.toCollectionDTO(repository.findAll(orderByMascaraAsc()));
    }

    public List<PlanoContaDTO> pesquisar(PlanoContaFilter filter) {
        return mapper.toCollectionDTO(repository.pesquisar(filter));
    }


    public List<PlanoContaDTO> listarSinteticos() {
        return mapper.toCollectionDTO(repository.findAllSintetico());
    }

    public void excluir(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            if (ex.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex
                        .getCause();
                if (constraintViolationException.getCause().getMessage().contains("ERROR: update or delete on table"))
                    throw new NegocioException("Registro não pode ser editado ou excluído, pois possui vínculo com outras tabelas.");
            }
        }
    }

    private Sort orderByMascaraAsc() {
        return Sort.by(Sort.Direction.ASC, "mascara");
    }

}
