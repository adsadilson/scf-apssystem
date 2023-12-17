package br.com.apssystem.scfapssystem.domain.dtos;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsuarioDTO {

    @EqualsAndHashCode.Exclude
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 250)
    private String nome;

    @NotBlank
    @Size(min = 3, max = 12)
    private String senha;

    private String novaSenha;

    @NotNull
    private UUID empresaId;

    @NotNull
    @Valid
    private GrupoUsuarioDTO grupoUsuario;

    private boolean ativo = true;

    public boolean isInclusao() {
        return this.getId() == null;
    }

}
