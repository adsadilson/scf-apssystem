package br.com.apssystem.scfapssystem.domain.repository;

import br.com.apssystem.scfapssystem.domain.entity.GrupoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, UUID> {

    GrupoUsuario findByNome(String nome);
}
