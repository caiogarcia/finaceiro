package com.github.caiogarcia.financeiro.bank.core;

import java.util.Optional;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;

public interface IRetrieveBankUseCase {
	Optional<Bank> execute(Integer idBank);
}
