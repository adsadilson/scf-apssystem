package br.com.apssystem.scfapssystem.domain.entity;

import br.com.apssystem.scfapssystem.domain.enums.TipoConta;
import br.com.apssystem.scfapssystem.domain.enums.TipoRelatorio;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@ToString
public class PlanoConta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TipoConta tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao", length = 50, nullable = false)
    private TipoRelatorio classificacao;

    @Column(name = "status")
    private boolean status;

    @Column(name = "mascara", length = 30, nullable = false, unique = true)
    private String mascara;

    @ManyToOne
    @JoinColumn(name = "conta_pai_id")
    private PlanoConta contaPai;


}
