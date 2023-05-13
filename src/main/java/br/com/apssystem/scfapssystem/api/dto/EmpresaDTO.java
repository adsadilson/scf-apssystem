package br.com.apssystem.scfapssystem.api.dto;

import br.com.apssystem.scfapssystem.domain.enums.Estado;
import br.com.apssystem.scfapssystem.domain.utils.ValidationCpfCnpj;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {

    private UUID id;
    @NotBlank
    @Size(min = 3, max = 200)
    private String nome;
    @NotBlank
    @ValidationCpfCnpj
    private String cnpjCpf;
    @NotBlank
    @Size(min = 3, max = 25)
    private String contato;
    @Email
    private String email;
    @NotBlank
    @Size(max = 25)
    private String celular;
    private String telefone;
    @NotBlank
    @Size(min = 3, max = 80)
    private String endereco;
    @NotBlank
    @Size(max = 12)
    private String cep;
    @NotBlank
    private String num;
    private String complemento;
    @NotBlank
    @Size(max = 200)
    private String bairro;
    @NotBlank
    @Size(min = 3, max = 150)
    private String cidade;
    @NotNull
    private Estado estado;
    @NotNull
    private Boolean status;
    private String obs;
    private String logo;

}
