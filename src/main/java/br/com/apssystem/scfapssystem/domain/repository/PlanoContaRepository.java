package br.com.apssystem.scfapssystem.domain.repository;

import br.com.apssystem.scfapssystem.domain.entity.PlanoConta;
import br.com.apssystem.scfapssystem.domain.entity.PlanoContaFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlanoContaRepository extends JpaRepository<PlanoConta, UUID> {

    @Query("from PlanoConta where classificacao='S' order by mascara")
    List<PlanoConta> findAllSintetico();

    List<PlanoConta> pesquisar(PlanoContaFilter filter);
}
