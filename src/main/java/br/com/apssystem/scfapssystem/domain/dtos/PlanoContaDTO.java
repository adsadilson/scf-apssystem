package br.com.apssystem.scfapssystem.domain.dtos;

import br.com.apssystem.scfapssystem.domain.enums.TipoConta;
import br.com.apssystem.scfapssystem.domain.enums.TipoRelatorio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlanoContaDTO {

    private UUID id;

    @NotBlank
    @Size(min = 3, max = 80)
    private String nome;

    @NotNull
    private TipoConta tipo;

    @NotNull
    private TipoRelatorio classificacao;

    @Builder.Default
    private boolean status = true;

    @NotBlank
    private String mascara;

    private PlanoContaDTO contaPai;

}
