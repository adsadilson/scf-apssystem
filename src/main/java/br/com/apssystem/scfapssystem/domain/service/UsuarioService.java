package br.com.apssystem.scfapssystem.domain.service;


import br.com.apssystem.scfapssystem.api.exceptions.NegocioException;
import br.com.apssystem.scfapssystem.domain.dtos.UsuarioDTO;
import br.com.apssystem.scfapssystem.domain.entity.Usuario;
import br.com.apssystem.scfapssystem.domain.mapper.UsuarioMapper;
import br.com.apssystem.scfapssystem.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioService {

    UsuarioRepository repository;
    EmpresaService empresaService;
    GrupoUsuarioService grupoUsuarioService;
    UsuarioMapper mapper;

    public void salvar(UsuarioDTO dto) throws Exception {
        repository.save(validarEmpresaGrupoUser(dto));
    }

    private Usuario validarEmpresaGrupoUser(UsuarioDTO dto) {
        var empresa = empresaService.buscarPorId(dto.getEmpresaId());
        var grupoUsuario = grupoUsuarioService.buscarPorId(dto.getGrupoUsuario().getId());
        var usuario = mapper.toEntity(dto);
        usuario.setEmpresa(empresa);
        usuario.setGrupoUsuario(grupoUsuario);
       // if (dto.getId() == null) usuario.setSenha(encode.encode(dto.getSenha()));
        return usuario;
    }

    public void redefinirSenha(UsuarioDTO dto) throws Exception {
      //  dto.setSenha(encode.encode(dto.getNovaSenha()));
        salvar(dto);
    }

    public UsuarioDTO buscarPorId(UUID id) {
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isPresent()) {
            return mapper.toDTO(usuario.get());
        }
        throw new NegocioException("Usuário não encontrado.");
    }



    public void excluir(UUID id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    public List<UsuarioDTO> listarTodos() {
        return mapper.toCollectionDTO(repository.findAll());
    }

}
