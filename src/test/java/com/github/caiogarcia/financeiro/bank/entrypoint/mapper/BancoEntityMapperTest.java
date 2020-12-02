package com.github.caiogarcia.financeiro.bank.entrypoint.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import com.github.caiogarcia.financeiro.bank.core.model.Bank;
import com.github.caiogarcia.financeiro.bank.entrypoint.entity.BankEntity;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class BancoEntityMapperTest {

  @Test
  public void givenAValidBankWhenMapToEntityThenReturnABancoEntity() {
    Bank banco = Bank.builder().name("Foo").idBank(123).code("456").build();
    BankEntity expected = BankEntity.builder().name("Foo").idBank(123).code("456").build();

    BankEntity actual = BankEntityMapper.toEntity(banco);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullBancoWhenMapToEntityThenReturnANullBancoEntity() {
    Bank banco = null;

    BankEntity actual = BankEntityMapper.toEntity(banco);

    assertNull(actual);
  }

  @Test
  public void givenAValidListBancoWhenMapToEntityThenReturnAListBancoEntity() {
    List<Bank> bancos = Arrays.asList(Bank.builder().name("Foo").idBank(123).code("456").build(),
        Bank.builder().name("Bar").idBank(321).code("654").build());
    List<BankEntity> expected = Arrays.asList(BankEntity.builder().name("Foo").idBank(123).code("456").build(),
        BankEntity.builder().name("Bar").idBank(321).code("654").build());

    List<BankEntity> actual = BankEntityMapper.toEntityList(bancos);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullListBancoWhenMapToEntityThenReturnAEmptyListBancoEntity() {
    List<Bank> Bancos = null;

    List<BankEntity> actual = BankEntityMapper.toEntityList(Bancos);

    assertThat(actual).isEmpty();
  }

  @Test
  public void givenAValidBankEntityWhenMapToValueObjectThenReturnABanco() {
    BankEntity bancoEntity = BankEntity.builder().name("Foo").idBank(123).code("456").build();
    Bank expected = Bank.builder().name("Foo").idBank(123).code("456").build();

    Bank actual = BankEntityMapper.toModel(bancoEntity);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullBancoEntityWhenMapToValueObjectThenReturnNull() {
    BankEntity bancoEntity = null;

    Bank actual = BankEntityMapper.toModel(bancoEntity);

    assertNull(actual);
  }

  @Test
  public void givenAValidListBancoEntityWhenMapToModelThenReturnAListBanco() {
    List<BankEntity> bancos = Arrays.asList(BankEntity.builder().name("Foo").idBank(123).code("456").build(),
        BankEntity.builder().name("Bar").idBank(321).code("654").build());
    List<Bank> expected = Arrays.asList(Bank.builder().name("Foo").idBank(123).code("456").build(),
        Bank.builder().name("Bar").idBank(321).code("654").build());

    List<Bank> actual = BankEntityMapper.toModelList(bancos);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullListBancoEntityWhenMapToEntityThenReturnAEmptyListBanco() {
    List<BankEntity> bancos = null;

    List<Bank> actual = BankEntityMapper.toModelList(bancos);

    assertThat(actual).isEmpty();
  }
}
