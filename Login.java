package docManage;

import java.util.Scanner;
import java.util.Set;

public class Login extends CriarConta {
    private String option;
    private String txtSwitch;

    public Login(Scanner sc, Set<String> crmsCadastrados) {
        super(sc, crmsCadastrados);
    }

    private void userOption(String option) {
        switch (option) {
            case "1":
                entrarNaConta();
                break;
            case "2":
                criarContaInterface();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                txtSwitch = "Nenhuma opção acima selecionada!!";
                System.out.println(txtSwitch);
                break;
        }
    }

    private void entrarNaConta() {
        System.out.println("Entrando na conta...");

    }

    public void menu() {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Entrar na conta");
            System.out.println("2. Criar uma nova conta");
            System.out.println("3. Sair");
            option = sc.nextLine();
            userOption(option);

        }
    }
}