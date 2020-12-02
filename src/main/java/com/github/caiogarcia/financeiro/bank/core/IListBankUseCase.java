package com.github.caiogarcia.financeiro.bank.core;

import java.util.List;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;

public interface IListBankUseCase {
	List<Bank> execute();
}
