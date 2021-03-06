package com.github.caiogarcia.financeiro.bank.core;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;

public interface IUpdateBankUseCase {
	Bank execute(Bank bank);
}
