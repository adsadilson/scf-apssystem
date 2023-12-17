package br.com.apssystem.scfapssystem.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PermissaoDTO {
    private UUID id;
    @Builder.Default
    private Boolean incluir = false;
    @Builder.Default
    private Boolean alterar = false;
    @Builder.Default
    private Boolean excluir = false;
    @Builder.Default
    private Boolean visualizar = false;
    @Builder.Default
    private Boolean relatorio = false;
    private GrupoUsuarioDTO grupoUsuario;

}
