package com.github.caiogarcia.financeiro.bank.entrypoint;

import javax.validation.Valid;

import com.github.caiogarcia.financeiro.bank.core.ICreateBankUseCase;
import com.github.caiogarcia.financeiro.bank.entrypoint.entity.BankEntity;
import com.github.caiogarcia.financeiro.bank.entrypoint.mapper.BankEntityMapper;

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
@RequestMapping("/bank")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Validated
public class CreateBankEntryPoint {

    private ICreateBankUseCase useCase;

    @PostMapping
    public ResponseEntity<Integer> post(@Valid @RequestBody BankEntity bankEntity) {
        Integer newId = useCase.execute(BankEntityMapper.toModel(bankEntity));

        return new ResponseEntity<Integer>(newId, HttpStatus.CREATED);
    }

}
