package br.com.apssystem.scfapssystem.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 250, nullable = false)
    private String senha;

    @Builder.Default
    private boolean ativo = true;

    @Builder.Default
    private LocalDate cadastro = LocalDate.now();

    @Transient
    private String novaSenha;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "grupo_usuario_id", nullable = false)
    private GrupoUsuario grupoUsuario;

    public boolean isInclusao() {
        return this.getId() == null;
    }



}
