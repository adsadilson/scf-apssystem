package br.com.apssystem.scfapssystem.domain.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class GrupoUsuarioDTO {

    @EqualsAndHashCode.Exclude
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 80)
    private String nome;

    @Builder.Default
    private boolean ativo = true;

    private List<PermissaoDTO> permissaos = new ArrayList<>();

    public boolean isInclusao() {
        return this.getId() == null;
    }

}
