package br.com.apssystem.scfapssystem.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class GrupoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(length = 80, nullable = false, unique = true)
    private String nome;
   
    @Builder.Default
    private boolean ativo = true;

    @OneToMany(mappedBy = "grupoUsuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Permissao> permissoes = new ArrayList<>();


    public boolean isInclusao() {
		return this.getId() == null;
	}


}
