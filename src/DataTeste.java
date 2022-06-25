import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataTeste {

  Data teste;
  
  @BeforeEach
  public void startup() {
    teste = new Data(2000, 1, 1);
    
  }

  @Test
  public void retornarDia() {
    assertEquals(1, teste.getDia());
  }

  @Test
  public void retornarMes() {
    assertEquals(1, teste.getMes());
  }

  @Test
  public void retornarAno() {
    assertEquals(2000, teste.getAno());
  }

  @Test
  public void testeAdicionarDias() {
    teste.adicionaDias(2);

    assertEquals(3, teste.getDia());
  }

  @Test
  public void pularUmMes() {
    teste.adicionaDias(32);
    assertEquals(2, teste.getDia());
    assertEquals(2, teste.getMes());
  }

  @Test
  public void pularUmAno() {
    teste.adicionaDias(366);
    assertEquals(1, teste.getDia());
    assertEquals(1, teste.getMes());
    assertEquals(2001, teste.getAno());
  }

  @Test
  public void testarSeAnoBissexto() {
    assertEquals(true, teste.eAnoBissexto());
  }

  @Test
  public void testarConstrutorVazio() {
    teste = new Data();

    LocalDate data = LocalDate.now();
    int mes = data.getMonthValue();
    int dia = data.getDayOfMonth();
    int ano = data.getYear();

    assertEquals(dia, teste.getDia());
    assertEquals(mes, teste.getMes());
    assertEquals(ano, teste.getAno());
    
  }

  @Test
  public void testarPorExtenso() {
    assertEquals("01/01/2000", teste.porExtenso());
  }

  @Test
  public void testeDiaDaSemana() {
    teste = new Data(2022, 3, 23);

    assertEquals("Quarta-feira", teste.diaDaSemana());
  }
}
