package br.com.apssystem.scfapssystem.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Estado {

    AC("Acre", "AC"),
    AL("Alagoas", "AL"),
    AP("Amapá", "AP"),
    AM("Amazonas", "AM"),
    BA("Bahia", "BA"),
    CE("Ceará", "CE"),
    DF("Distrito Federal", "DF"),
    ES("Espírito Santo", "ES"),
    GO("Goiás", "GO"),
    MA("Maranh�o", "MA"),
    MT("Mato Grosso", "MT"),
    MS("Mato Grosso do Sul", "MS"),
    MG("Minas Gerais", "MG"),
    PA("Pará", "PA"),
    PB("Paraíba", "PB"),
    PR("Paraná", "PR"),
    PE("Pernambuco", "PE"),
    PI("Piauí", "PI"),
    RR("Roraima", "RR"),
    RO("Rondônia", "RO"),
    RJ("Rio de Janeiro", "RJ"),
    RN("Rio Grande do Norte", "RN"),
    RS("Rio Grande do Sul", "RS"),
    SC("Santa Catarina", "SC"),
    SP("São Paulo", "SP"),
    SE("Sergipe", "SE"),
    TO("Tocantins", "TO");

    private String label;
    private String sigla;

}
