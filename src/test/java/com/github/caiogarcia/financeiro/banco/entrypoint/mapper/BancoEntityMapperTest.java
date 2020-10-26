package com.github.caiogarcia.financeiro.banco.entrypoint.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import com.github.caiogarcia.financeiro.banco.core.model.Banco;
import com.github.caiogarcia.financeiro.banco.entrypoint.entity.BancoEntity;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("Unit")
public class BancoEntityMapperTest {

  @Test
  public void givenAValidBancoWhenMapToEntityThenReturnABancoEntity() {
    Banco banco = Banco.builder().nome("Foo").idBanco(123).codigo("456").build();
    BancoEntity expected = BancoEntity.builder().nome("Foo").idBanco(123).codigo("456").build();

    BancoEntity actual = BancoEntityMapper.toEntity(banco);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullBancoWhenMapToEntityThenReturnANullBancoEntity() {
    Banco banco = null;

    BancoEntity actual = BancoEntityMapper.toEntity(banco);

    assertNull(actual);
  }

  @Test
  public void givenAValidListBancoWhenMapToEntityThenReturnAListBancoEntity() {
    List<Banco> bancos = Arrays.asList(Banco.builder().nome("Foo").idBanco(123).codigo("456").build(),
        Banco.builder().nome("Bar").idBanco(321).codigo("654").build());
    List<BancoEntity> expected = Arrays.asList(BancoEntity.builder().nome("Foo").idBanco(123).codigo("456").build(),
        BancoEntity.builder().nome("Bar").idBanco(321).codigo("654").build());

    List<BancoEntity> actual = BancoEntityMapper.toEntityList(bancos);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullListBancoWhenMapToEntityThenReturnAEmptyListBancoEntity() {
    List<Banco> Bancos = null;

    List<BancoEntity> actual = BancoEntityMapper.toEntityList(Bancos);

    assertThat(actual).isEmpty();
  }

  @Test
  public void givenAValidBancoEntityWhenMapToValueObjectThenReturnABanco() {
    BancoEntity bancoEntity = BancoEntity.builder().nome("Foo").idBanco(123).codigo("456").build();
    Banco expected = Banco.builder().nome("Foo").idBanco(123).codigo("456").build();

    Banco actual = BancoEntityMapper.toModel(bancoEntity);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullBancoEntityWhenMapToValueObjectThenReturnNull() {
    BancoEntity bancoEntity = null;

    Banco actual = BancoEntityMapper.toModel(bancoEntity);

    assertNull(actual);
  }

  @Test
  public void givenAValidListBancoEntityWhenMapToModelThenReturnAListBanco() {
    List<BancoEntity> bancos = Arrays.asList(BancoEntity.builder().nome("Foo").idBanco(123).codigo("456").build(),
        BancoEntity.builder().nome("Bar").idBanco(321).codigo("654").build());
    List<Banco> expected = Arrays.asList(Banco.builder().nome("Foo").idBanco(123).codigo("456").build(),
        Banco.builder().nome("Bar").idBanco(321).codigo("654").build());

    List<Banco> actual = BancoEntityMapper.toModelList(bancos);

    assertEquals(expected, actual);
  }

  @Test
  public void givenANullListBancoEntityWhenMapToEntityThenReturnAEmptyListBanco() {
    List<BancoEntity> bancos = null;

    List<Banco> actual = BancoEntityMapper.toModelList(bancos);

    assertThat(actual).isEmpty();
  }
}
