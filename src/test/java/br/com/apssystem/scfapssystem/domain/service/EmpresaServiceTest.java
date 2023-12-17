package br.com.apssystem.scfapssystem.domain.service;

import br.com.apssystem.scfapssystem.api.dto.EmpresaDTO;
import br.com.apssystem.scfapssystem.domain.entity.Empresa;
import br.com.apssystem.scfapssystem.domain.repository.EmpresaRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.lenient;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class EmpresaServiceTest {

  @InjectMocks
  EmpresaService empresaService;
  @Mock
  EmpresaRepository repository;

  @BeforeEach
  void setUp() {
  }

  @Test
  public void Dado_uma_empresa_valido_Quando_cadastrar_entao_deve_retornar_id() {
    UUID ID = UUID.fromString("955f8056-f07c-45f7-8c08-c8d14e890635");

    Empresa empresaSaved = new Empresa();
    empresaSaved.setId(ID);
    empresaSaved.setNome("EMPRESA 1 ");
    empresaSaved.setCnpjCpf("01.770.349/0001-75");

    Empresa empresa = new Empresa();
    empresa.setNome("EMPRESA 1 ");
    empresa.setCnpjCpf("01.770.349/0001-75");

    EmpresaDTO dto = new EmpresaDTO();
    dto.setNome("EMPRESA 1 ");
    dto.setCnpjCpf("01.770.349/0001-75");



    lenient().when(repository.save(empresa)).thenReturn(empresaSaved);


    lenient().when(repository.findByCnpjCpf("01.770.349/0001-75")).thenReturn(Optional.empty());

    Empresa result = empresaService.create(dto);


    Assertions.assertEquals(ID, result.getId());

  }

  @Test
  void Dado_uma_empresa_valido_Quando_cadastrar_entao_deve_verificar_se_ja_existe_cnpj_ou_cpf_cadastrado() {
    EmpresaDTO empDto = EmpresaDTO.builder().cnpjCpf("01.770.349/0001-75").build();
    EmpresaDTO spied = Mockito.spy(empDto);
    empresaService.create(empDto);
    Mockito.verify(spied, Mockito.atLeast(1)).getCnpjCpf();
  }

}