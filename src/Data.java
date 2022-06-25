import java.time.LocalDate;

public class Data {

  private int dia, mes, ano;

  public Data(int ano, int mes, int dia) {
    setAno(ano);
    if (validarMes(mes)) {
      setMes(mes);
    } else {
      System.out.println("ERRO: MÊS INVÁLIDO");
    }
    if (validarDia(dia)) {
      setDia(dia);
    } else {
      System.out.println("ERRO: DIA INVÁLIDO");
    }
  }

  public Data() {
    int[] dataAtual = getDataAtual();

    setDia(dataAtual[0]);
    setMes(dataAtual[1]);
    setAno(dataAtual[2]);
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

  public void setDia(int dia) {
    this.dia = dia;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public void adicionaDias(int dias) {
    this.dia += dias;
    validarData();
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
    }
    
    return response;
  }

  public Boolean eAnoBissexto() {
    return this.getAno() % 4 == 0 && !(this.getAno() % 100 == 0)|| (this.getAno() % 400 == 0);
  }

  private void validarData() {
    if (this.dia > this.diasNoMes()) {
      int diasExcedentes = this.dia - this.diasNoMes();
      this.dia = 0;
      this.mes += 1;
      if (this.getMes() > 12) {
        this.mes = 1;
        this.ano += 1;
      }
      this.adicionaDias(diasExcedentes);
    }
  }

  private Boolean validarDia(int dia) {
    return dia >= 1 && dia <= this.diasNoMes();
  }

  private Boolean validarMes(int mes) {
    return mes >= 1 && mes <= 12;
  }

  private int[] getDataAtual() {
    int[] response = new int[3];

    LocalDate data = LocalDate.now();
    int mes = data.getMonthValue();
    int dia = data.getDayOfMonth();
    int ano = data.getYear();

    response[0] = dia;
    response[1] = mes;
    response[2] = ano;
    

    return response;
  }

  public String porExtenso() {
    String dia = this.formatarDigito(this.getDia());
    String mes = this.formatarDigito(this.getMes());

    return dia + "/" + mes + "/" + this.getAno();
  }

  private String formatarDigito(int valor) {
    String response = Integer.toString(valor);
    if (valor < 10) {
      response = "0" + Integer.toString(valor);
    }

    return response;
  }

  public String diaDaSemana() { // Não consegui acabar antes do prazo de entrega
    return "Quarta-feira";
  }
  
}
