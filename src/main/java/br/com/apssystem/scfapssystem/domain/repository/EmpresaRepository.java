package br.com.apssystem.scfapssystem.domain.repository;

import br.com.apssystem.scfapssystem.domain.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, UUID> {
    Optional<Empresa> findByCnpjCpf(String cnpjCpf);

}
