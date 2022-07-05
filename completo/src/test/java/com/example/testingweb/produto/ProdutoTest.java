package com.example.testingweb.produto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.testingweb.builders.ProdutoBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

  private static final double VALOR_NEGATIVO = -1d;

  @Test
  public void nao_deve_permitir_informar_valor_menor_que_zero()
    throws Exception {
    assertThrows(
      ValorInvalido.class,
      () -> {
        new Produto("Fogão 4 bocas", VALOR_NEGATIVO);
      }
    );
  }

  @Test
  public void deve_conter_valor_unitario_positivo() throws ValorInvalido {
    //Arrange
    double valorUnitarioEsperado = 10d;
    //ACT
    Produto produto = new ProdutoBuilder()
      .comValorUnitario(valorUnitarioEsperado)
      .construir();

    //Assert
    Assertions.assertEquals(valorUnitarioEsperado, produto.getValorUnitario());
  }

  @Test
  public void deve_conter_uma_descricao() throws ValorInvalido {
	//Arrange
	String descricaoEsperada = "Switch Oled";
	//ACT
	Produto produto = new ProdutoBuilder()
	.comDescricao(descricaoEsperada)
	.construir();
	//Assert
	Assertions.assertEquals(descricaoEsperada, produto.getDescricao());
	
  }
}
