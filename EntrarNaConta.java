package docManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EntrarNaConta extends Menu {
    private Scanner sc;
    private Set<String> crmsCadastrados;
    private List<String> senhasCadastradas;

    public EntrarNaConta(Scanner sc, Set<String> crmsCadastrados, List<String> senhasCadastradas) {
        this.sc = sc;
        this.crmsCadastrados = crmsCadastrados;
        this.senhasCadastradas = senhasCadastradas;
    }

    public void entrarNaConta() {
        while (true) {
            System.out.print("Digite seu CRM: ");
            String crm = sc.nextLine();

            if (!crmsCadastrados.contains(crm)) {
                System.out.println("CRM nÃ£o cadastrado. Tente novamente.");
                continue;
            }

            System.out.print("Digite sua senha: ");
            String senha = sc.nextLine();

            if (validarLogin(crm, senha)) {
                System.out.println("Login bem-sucedido! Bem-vindo.");
                break;
            } else {
                System.out.println("Senha incorreta. Tente novamente.");
            }
        }
    }

    private boolean validarLogin(String crm, String senha) {
        int index = new ArrayList<>(crmsCadastrados).indexOf(crm);
        if (index != -1) {
            return this.senhasCadastradas.get(index).equals(senha);
        }
        return false;
    }
}