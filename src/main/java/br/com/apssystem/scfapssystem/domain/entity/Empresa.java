package br.com.apssystem.scfapssystem.domain.entity;


import br.com.apssystem.scfapssystem.domain.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empresa")
@SequenceGenerator(name = "EMPRESA_ID", sequenceName = "EMPRESA_SEQ", allocationSize = 1)
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(name = "cpf_cnpj", length = 18, nullable = false)
    private String cnpjCpf;
    @Column(length = 25, nullable = false)
    private String contato;
    @Column(length = 150)
    private String email;
    @Column(length = 25)
    private String celular;
    @Column(length = 25)
    private String telefone;
    @Column(length = 80, nullable = false)
    private String endereco;
    @Column(length = 12, nullable = false)
    private String cep;
    @Column(length = 25)
    private String num;
    @Column(length = 80)
    private String complemento;
    @Column(length = 80)
    private String bairro;
    @Column(length = 150)
    private String cidade;
    @Enumerated(EnumType.STRING)
    @Column(length = 2, nullable = false)
    private Estado estado;
    @Column(length = 1)
    private Boolean status = true;
    @Column(columnDefinition = "text")
    private String obs;
    @Column(columnDefinition = "text")
    private String logo;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersiste() {
        setDataCadastro(LocalDate.now());
        setStatus(true);
    }
}
