package br.com.apssystem.scfapssystem.domain.service;


import br.com.apssystem.scfapssystem.api.exceptions.NegocioException;
import br.com.apssystem.scfapssystem.domain.dtos.GrupoUsuarioDTO;
import br.com.apssystem.scfapssystem.domain.entity.GrupoUsuario;
import br.com.apssystem.scfapssystem.domain.mapper.GrupoUsuarioMapper;
import br.com.apssystem.scfapssystem.domain.repository.GrupoUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GrupoUsuarioService {



    private GrupoUsuarioRepository repository;

    private GrupoUsuarioMapper mapper;

    @Transactional
    public void salvar(GrupoUsuarioDTO obj) throws Exception {
        repository.save(mapper.toEntity(obj));
    }

    public void excluir(UUID id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    public GrupoUsuarioDTO buscarPorIdDTO(UUID id) {
        return  mapper.toDTO(buscarPorId(id));
    }

    public GrupoUsuario buscarPorId(UUID id) {
        Optional<GrupoUsuario> grupoUsuario = repository.findById(id);
        if (grupoUsuario.isPresent()) {
            return grupoUsuario.get();
        }
        throw new NegocioException("Grupo de Usuário não encontrado.");
    }

    public GrupoUsuarioDTO buscarPorNome(String nome) {
        return mapper.toDTO(repository.findByNome(nome));
    }



    public List<GrupoUsuarioDTO> listarTodos() {
        return mapper.toCollectionDTO(repository.findAll());
    }
}
