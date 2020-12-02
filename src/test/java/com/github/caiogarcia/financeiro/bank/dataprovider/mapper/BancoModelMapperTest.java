package com.github.caiogarcia.financeiro.bank.dataprovider.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.dataprovider.repository.model.BankModel;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class BancoModelMapperTest {

  @Test
  public void givenAValidBankWhenMaptoModelThenReturnABanco() {
    Bank banco = Bank.builder().name("Foo Bar").idBank(123).code("456").build();
    BankModel expected = BankModel.builder().name("Foo Bar").idBank(123).code("456").build();

    BankModel actual = BankModelMapper.toModel(banco);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullBancoWhenMaptoModelThenReturnANullBanco() {
    Bank banco = null;

    BankModel actual = BankModelMapper.toModel(banco);

    assertNull(actual);
  }

  @Test
  public void givenAValidListBancoWhenMaptoModelThenReturnAListBanco() {
    List<Bank> Bancos = Arrays.asList(Bank.builder().name("Foo").idBank(123).code("456").build(),
        Bank.builder().name("Bar").idBank(321).code("654").build());
    List<BankModel> expected = Arrays.asList(BankModel.builder().name("Foo").idBank(123).code("456").build(),
        BankModel.builder().name("Bar").idBank(321).code("654").build());

    List<BankModel> actual = BankModelMapper.toModelList(Bancos);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullListBancoWhenMaptoModelThenReturnAEmptyListBancoModel() {
    List<Bank> bancos = null;

    List<BankModel> actual = BankModelMapper.toModelList(bancos);

    assertThat(actual).isEmpty();
  }

  @Test
  public void givenAValidBankModelWhenMaptoThenReturnABanco() {
    BankModel bancoModel = BankModel.builder().name("Foo").idBank(123).code("456").build();
    Bank expected = Bank.builder().name("Foo").idBank(123).code("456").build();

    Bank actual = BankModelMapper.toEntity(bancoModel);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullBancoModelWhenMaptoThenReturnANullBanco() {
    BankModel Banco = null;

    Bank actual = BankModelMapper.toEntity(Banco);

    assertNull(actual);
  }

  @Test
  public void givenAValidListBancoModelWhenMaptoThenReturnAListBanco() {
    List<BankModel> Bancos = Arrays.asList(BankModel.builder().name("Foo").idBank(123).code("456").build(),
        BankModel.builder().name("Bar").idBank(321).code("654").build());
    List<Bank> expected = Arrays.asList(Bank.builder().name("Foo").idBank(123).code("456").build(),
        Bank.builder().name("Bar").idBank(321).code("654").build());

    List<Bank> actual = BankModelMapper.toEntityList(Bancos);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullListBancoModelWhenMaptoThenReturnAEmptyListBanco() {
    List<BankModel> Bancos = null;

    List<Bank> actual = BankModelMapper.toEntityList(Bancos);

    assertThat(actual).isEmpty();
  }
}
