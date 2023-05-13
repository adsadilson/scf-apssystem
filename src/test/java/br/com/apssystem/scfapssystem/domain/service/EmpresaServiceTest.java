package br.com.apssystem.scfapssystem.domain.service;

import br.com.apssystem.scfapssystem.api.dto.EmpresaDTO;
import br.com.apssystem.scfapssystem.domain.entity.Empresa;
import br.com.apssystem.scfapssystem.domain.mapper.EmpresaMapper;
import br.com.apssystem.scfapssystem.domain.repository.EmpresaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class EmpresaServiceTest {
    @Mock
    EmpresaRepository empresaRepository;
    @Mock
    EmpresaMapper empresaMapper;

    @InjectMocks
    EmpresaService empresaService;


    @BeforeEach
    void setUp() {
    }

    @Test
    public void Dado_uma_empresa_valido_Quando_cadastrar_entao_deve_retornar_id() {
        // Given
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setNome("Empresa Teste");
        empresaDTO.setCnpjCpf("123456789");

        Empresa empresaSalva = new Empresa();
        empresaSalva.setId(UUID.randomUUID());
        empresaSalva.setNome("Empresa Teste");
        empresaSalva.setCnpjCpf("123456789");

        when(empresaMapper.toEntity(empresaDTO)).thenReturn(empresaSalva);
        when(empresaRepository.save(empresaSalva)).thenReturn(empresaSalva);
        when(empresaMapper.toDto(empresaSalva)).thenReturn(empresaDTO);

        // When
        EmpresaDTO result = empresaService.create(empresaDTO);

        // Then
        assertNotNull(result);
        assertEquals("Empresa Teste", result.getNome());
        assertEquals("123456789", result.getCnpjCpf());

        verify(empresaMapper, times(1)).toEntity(empresaDTO);
        verify(empresaRepository, times(1)).save(empresaSalva);
        verify(empresaMapper, times(1)).toDto(empresaSalva);
    }

    @Test
    void Dado_uma_empresa_valido_Quando_cadastrar_entao_deve_verificar_se_ja_existe_cnpj_ou_cpf_cadastrado() {
        EmpresaDTO empDto = EmpresaDTO.builder().cnpjCpf("01.770.349/0001-75").build();
        EmpresaDTO spied = Mockito.spy(empDto);
        empresaService.create(empDto);
        Mockito.verify(spied, Mockito.atLeast(1)).getCnpjCpf();
    }

}