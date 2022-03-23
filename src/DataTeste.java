import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
