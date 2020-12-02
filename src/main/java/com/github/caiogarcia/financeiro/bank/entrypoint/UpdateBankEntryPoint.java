package com.github.caiogarcia.financeiro.bank.entrypoint;

import javax.validation.Valid;

import com.github.caiogarcia.financeiro.bank.core.IUpdateBankUseCase;
import com.github.caiogarcia.financeiro.bank.entrypoint.entity.BankEntity;
import com.github.caiogarcia.financeiro.bank.entrypoint.mapper.BankEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bank/{idBank}")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Validated
public class UpdateBankEntryPoint {

    private IUpdateBankUseCase useCase;

    @PutMapping
    public ResponseEntity<Void> put(@Valid @RequestBody BankEntity bankEntity,
            @PathVariable(name = "idBank") Integer idBank) {

        bankEntity.setIdBank(idBank);
        useCase.execute(BankEntityMapper.toModel(bankEntity));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
