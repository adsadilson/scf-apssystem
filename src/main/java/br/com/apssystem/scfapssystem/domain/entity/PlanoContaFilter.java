package br.com.apssystem.scfapssystem.domain.entity;

import br.com.apssystem.scfapssystem.domain.dtos.PlanoContaDTO;
import lombok.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanoContaFilter implements Specification<PlanoConta> {

    @Builder.Default
    String nome = "";
    private Boolean status;
    private PlanoContaDTO contaPai;

    @Override
    public Predicate toPredicate(Root<PlanoConta> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();

        if (contaPai != null) {
            predicates.add(builder.like(builder.lower(root.get("contaPai").get("mascara")),  contaPai.getMascara() + "%"));
        }

        if (status != null)
            predicates.add(builder.equal(root.get("status"), status));

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
