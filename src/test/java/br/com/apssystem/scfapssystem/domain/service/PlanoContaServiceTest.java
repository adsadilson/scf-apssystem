package br.com.apssystem.scfapssystem.domain.service;

import br.com.apssystem.scfapssystem.api.exceptions.NegocioException;
import br.com.apssystem.scfapssystem.domain.dtos.PlanoContaDTO;
import br.com.apssystem.scfapssystem.domain.entity.PlanoConta;
import br.com.apssystem.scfapssystem.domain.mapper.PlanoContaMapper;
import br.com.apssystem.scfapssystem.domain.repository.PlanoContaRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlanoContaServiceTest {

    @Mock
    private PlanoContaRepository repository;

    @Mock
    private PlanoContaMapper mapper;

    @InjectMocks
    private PlanoContaService planoContaService;

    @Captor
    private ArgumentCaptor<PlanoContaDTO> dtoCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvar_DuplicateRecord() {
        UUID id = UUID.fromString("d6987408-9ceb-11ee-8c90-0242ac120002");
        PlanoContaDTO dto = PlanoContaDTO.builder().id(id).build();
        PlanoConta entity = PlanoConta.builder().id(id).build();

        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenThrow(ConstraintViolationException.class);

        try {
            planoContaService.salvar(dto);
            fail("NegocioException não foi lançada.");
        } catch (NegocioException e) {
            assertEquals("Registro já cadastrado.", e.getMessage());
        }

        // Verifica se os métodos mock foram chamados
        verify(mapper, times(1)).toEntity(dto);
        verify(repository, times(1)).save(entity);
    }

}