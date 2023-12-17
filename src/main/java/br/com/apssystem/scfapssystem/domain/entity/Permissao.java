package br.com.apssystem.scfapssystem.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@ToString
public class Permissao {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 1)
    private Boolean incluir;

    @Column(nullable = false, length = 1)
    private Boolean alterar;

    @Column(nullable = false, length = 1)
    private Boolean excluir;

    @Column(nullable = false, length = 1)
    private Boolean visualizar;

    @Column(nullable = false, length = 1)
    private Boolean relatorio ;

    @ManyToOne
    @JoinColumn(name = "grupo_usuario_id", nullable = false)
    private GrupoUsuario grupoUsuario;


}
