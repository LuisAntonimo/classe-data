public class Data {

  private int dia, mes, ano;

  public Data(int ano, int mes, int dia) {
    this.ano = ano;
    if (mes >= 1 && mes <= 12) {
      this.mes = mes;
    } else {
      System.out.println("ERRO: MÊS INVÁLIDO");
    }
    if (dia >= 1 && dia <= this.diasNoMes()) {
      this.dia = dia;
    } else {
      System.out.println("ERRO: DIA INVÁLIDO");
    }
  }

  public int getDia() {
    return this.dia;
  }

  public int getMes() {
    return this.mes;
  }

  public int getAno() {
    return this.ano;
  }

  public void adicionaDias(int dias) {
    this.dia += dias;
    
    if (this.dia > this.diasNoMes()) {
      int diasExcedentes = this.dia - this.diasNoMes();
      this.dia = 0;
      this.mes += 1;
      if (this.getMes() > 12) {
        this.mes = 1;
        this.ano += 1;
      }
      this.adicionaDias( diasExcedentes);
    }
  }

  private int diasNoMes() {
    int response = 31;

    switch (this.getMes()) {
      case 4:
      case 6:
      case 9:
      case 11:
        response = 30;
        break;
      case 2:
        if (this.eAnoBissexto()) {
          response = 29;
        } else {
          response = 28;
        }
        break;
    
      default:
        System.out.println("ERRO: MÊS INVÁLIDO");
        break;
    }
    
    return response;
  }

  public Boolean eAnoBissexto() {
    Boolean response = false;
    if (this.getAno() % 4 == 0 && !(this.getAno() % 100 == 0)|| (this.getAno() % 400 == 0)) {
      response = true;
    };

    return response;
  }
  
}
