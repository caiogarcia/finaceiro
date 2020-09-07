package com.github.caiogarcia.financeiro.banco.entrypoint;

import com.github.caiogarcia.financeiro.banco.core.usecase.CadastrarBancoUseCase;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
@Tag("Integration")
public class CadastrarBancoEntryPointIntegrationTest {
    @MockBean
    private CadastrarBancoUseCase useCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
	public void dadoUmBancoInvalidoQuandoSolicitarOCadastroDeveRetornarEstatus400() throws Exception {
	    String banco = "{\"nome\": \"Foo Bank\"}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/banco")
	      .content(banco)
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(MockMvcResultMatchers.status().isBadRequest())
          .andExpect(MockMvcResultMatchers.jsonPath("$.codigo", Is.is("Campo obrigatório.")))
	      .andExpect(MockMvcResultMatchers.content()
            .contentType(MediaType.APPLICATION_JSON));
	}
}
