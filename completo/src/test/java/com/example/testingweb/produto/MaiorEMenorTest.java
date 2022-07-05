package com.example.testingweb.produto;

import com.example.testingweb.builders.CarrinhoDeCompraBuilder;
import com.example.testingweb.carrinho.CarrinhoDeCompra;
import com.example.testingweb.carrinho.ItemDoCarrinho;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaiorEMenorTest {

  private static final int UM_UNIDADE = 1;
  private Produto geladeira;
  private Produto liquidificador;
  private Produto pratos;

  @BeforeEach
  public void inicializar() throws Exception {
    geladeira = new Produto("Geladeira", 450.0);
    liquidificador = new Produto("Liquidificador", 250.0);
    pratos = new Produto("Jogo de pratos", 70.0);
  }

  private CarrinhoDeCompra carrinhoDecrescente() {
    CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
    carrinho.adicionar(new ItemDoCarrinho(geladeira, UM_UNIDADE));
    carrinho.adicionar(new ItemDoCarrinho(liquidificador, UM_UNIDADE));
    carrinho.adicionar(new ItemDoCarrinho(pratos, UM_UNIDADE));
    return carrinho;
  }

  @Test
  public void deve_verificar_em_ordem_decrescente()
    throws ValorInvalido, CarrinhoVazioException {
    CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompraBuilder()
      .comItemDoCarrinho(new ItemDoCarrinho(this.geladeira, UM_UNIDADE))
      .comItemDoCarrinho(new ItemDoCarrinho(this.liquidificador, UM_UNIDADE))
      .comItemDoCarrinho(new ItemDoCarrinho(this.pratos, UM_UNIDADE))
      .construir();

    MaiorEMenor algoritmo = new MaiorEMenor();
    algoritmo.encontrar(carrinhoDeCompra);

    Assertions.assertEquals(pratos, algoritmo.getMenor());
  }

  private void comItemDoCarrinho(ItemDoCarrinho itemDoCarrinho) {}

  @Test
  public void deve_verificar_o_maior_preco_unitario_em_ordem_crescente()
    throws ValorInvalido, CarrinhoVazioException {
    CarrinhoDeCompra carrinho = new CarrinhoDeCompraBuilder()
      .emOrdemCrescente()
      .emOrdemDecrescente()
      .construir();

    MaiorEMenor algoritmo = new MaiorEMenor();
    algoritmo.encontrar(carrinho);

    Assertions.assertEquals(geladeira, algoritmo.getMaior());
  }

  @Test
  public void deve_lancar_excecao_para_carrinho_sem_produtos()
    throws ValorInvalido {
    CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompraBuilder()
      .construir();

    MaiorEMenor maiorEMenor = new MaiorEMenor();

    Assertions.assertThrows(
      CarrinhoVazioException.class,
      () -> {
        maiorEMenor.encontrar(carrinhoDeCompra);
      }
    );
  }
  // apenas um produto
}
