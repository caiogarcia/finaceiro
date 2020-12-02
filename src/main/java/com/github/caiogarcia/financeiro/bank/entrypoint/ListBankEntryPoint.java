package com.github.caiogarcia.financeiro.bank.entrypoint;

import java.util.List;

import com.github.caiogarcia.financeiro.bank.core.IListBankUseCase;
import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.entrypoint.entity.BankEntity;
import com.github.caiogarcia.financeiro.bank.entrypoint.mapper.BankEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bank")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Validated
public class ListBankEntryPoint {

    private IListBankUseCase useCase;

    @GetMapping
    public ResponseEntity<List<BankEntity>> get() {

        List<Bank> bank = useCase.execute();

        if (bank.isEmpty()) {
            return new ResponseEntity<List<BankEntity>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<BankEntity>>(BankEntityMapper.toEntityList(bank), HttpStatus.OK);
    }

}
