package docManage;

import java.util.Scanner;
import java.util.Set;

public class CriarConta {
    public Scanner sc;
    private String crm;
    private String senha;
    private String confirmarSenha;
    private Set<String> crmsCadastrados;

    public CriarConta(Scanner sc, Set<String> crmsCadastrados) {
        this.sc = sc;
        this.crmsCadastrados = crmsCadastrados;
    }

    public void criarContaInterface() {
        System.out.print("Digite seu CRM: ");
        crm = sc.nextLine();

        if (verificarDuplicidadeCrm(crm)) {
            System.out.println("CRM já cadastrado. Tente outro.");
            return;
        }

        System.out.print("Crie uma senha: ");
        senha = sc.nextLine();
        verificarSenha();
    }

    private void verificarSenha() {
        while (true) {
            System.out.print("Confirme sua senha: ");
            confirmarSenha = sc.nextLine();

            if (senha.equals(confirmarSenha)) {
                System.out.println("A senha é válida.");
                crmsCadastrados.add(crm);
                break;
            } else {
                System.out.println("As senhas não são iguais. Tente novamente.");
            }
        }
    }

    private boolean verificarDuplicidadeCrm(String crm) {
        return crmsCadastrados.contains(crm);
    }
}