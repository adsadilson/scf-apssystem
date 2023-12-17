package br.com.apssystem.scfapssystem.domain.service;

import br.com.apssystem.scfapssystem.api.dto.EmpresaDTO;
import br.com.apssystem.scfapssystem.api.exceptions.NegocioException;
import br.com.apssystem.scfapssystem.domain.entity.Empresa;
import br.com.apssystem.scfapssystem.domain.mapper.EmpresaMapper;
import br.com.apssystem.scfapssystem.domain.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository repository;


    public Empresa create(EmpresaDTO dto) {
        validaSeAEmpresaJaEstaCadastrada(dto);
        Empresa empresa = EmpresaMapper.toEntity(dto);
        Empresa empresaSave = repository.save(empresa);
        log.info("Registro cadastrado com sucesso!");
        return empresaSave;
    }

    private void validaSeAEmpresaJaEstaCadastrada(EmpresaDTO obj) {
        Optional<Empresa> existingEmpresa = repository.findByCnpjCpf(obj.getCnpjCpf())
                .stream()
                .filter(empresa -> !empresa.getId().equals(obj.getId()))
                .findFirst();
        if (existingEmpresa.isPresent()) {
            log.info("Registro já cadastrado com esse [cnpj/cpf]!");
            throw new NegocioException(
                    String.format("Registro já cadastrado com esse [cnpj/cpf] %s!", obj.getCnpjCpf()));
        }
    }

    public Empresa buscarPorId(UUID id) {
        var empresa = repository.findById(id);
        if (empresa.isPresent()) {
            return empresa.get();
        }
        throw new NegocioException("Empresa não encontrado.");
    }


}
