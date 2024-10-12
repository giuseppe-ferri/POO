package docManage;

public class SistemaPrincipal {
  public static void main(String[] args){
	Pessoa p1 = new Pessoa();
	Pessoa p2 = new Pessoa();
    Pessoa p = new Pessoa();
    
    p.setDataNascimento(25, 12, 2024);
    p1.setDataNascimento(5, 12, 2024);
    p2.setDataNascimento(25, 12, 2024);
    
    System.out.println(p.info());
    System.out.println(p1.info());
    System.out.println(p2.info());
  }
}
