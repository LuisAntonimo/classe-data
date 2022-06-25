public class Main {
  public static void main(String[] args) {
    System.out.println("Gerando uma nova data...");
    
    
    Data data = new Data();
    
    
    System.out.println(data.porExtenso());
    
    
    System.out.println("Alterando os dados...");
    
    
    data = new Data(2022, 3, 23);
    
    
    System.out.println(data.porExtenso());
    
    
    System.out.println("Verificando ano bissexto...");
    System.out.println("É um ano bissexto: " + data.eAnoBissexto());

    System.out.println("Avançando dias...");
    data.adicionaDias(15);

    System.out.println(data.porExtenso());

    }
}
