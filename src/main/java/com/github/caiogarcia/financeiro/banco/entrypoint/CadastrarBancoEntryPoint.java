package com.github.caiogarcia.financeiro.banco.entrypoint;

import javax.validation.Valid;

import com.github.caiogarcia.financeiro.banco.core.ICadastrarBancoUseCase;
import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.entrypoint.entity.BancoEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/banco")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Validated
public class CadastrarBancoEntryPoint {
    
    private ICadastrarBancoUseCase useCase;

    @PostMapping
    public ResponseEntity<Integer> post(@Valid @RequestBody BancoEntity bancoEntity) {
        Integer novoId = useCase.executar(Banco.builder()
            .idBanco(bancoEntity.getIdBanco())
            .codigo(bancoEntity.getCodigo())
            .nome(bancoEntity.getNome())
            .build());

        return new ResponseEntity<Integer>(novoId, HttpStatus.CREATED);
    }

}
