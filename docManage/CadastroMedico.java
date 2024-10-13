package docManage;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public final class CadastroMedico extends Menu {
    private Scanner sc = new Scanner(System.in);
    private List<String> crmsCadastrados;
    private List<String> senhasCadastradas;
    private String userOption;
    private String txtSwitch;
    private String crm;
    private String senha;

    public CadastroMedico() {
        crmsCadastrados = new ArrayList<>();
        senhasCadastradas = new ArrayList<>();
        initContaAdmin();
    }
    
    private void initContaAdmin() {
    	crmsCadastrados.add("admin");
        senhasCadastradas.add("admin");
    }

    private void option(String UserOption) {
        switch (userOption) {
            case "1":
                entrarNaConta();
                break;
            case "2":
                criarConta();
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

    public void initPrograma() {
        while (true) {
            System.out.println("PORTAL DO MÉDICO\nSelecione uma opção: ");
            System.out.println("1. Entrar na conta");
            System.out.println("2. Criar uma nova conta");
            System.out.print("3. Sair \nOpção >> ");
            userOption = sc.nextLine();
            option(userOption);
            System.out.println();
        }
    }

    public void criarConta() {
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
            String confirmarSenha = sc.nextLine();

            if (senha.equals(confirmarSenha)) {
                System.out.println("Conta criada com sucesso!");
                crmsCadastrados.add(crm);
                senhasCadastradas.add(senha);
                break;
            } else {
                System.out.println("As senhas não são iguais. Tente novamente.");
            }
        }
    }

    private boolean verificarDuplicidadeCrm(String crm) {
        return crmsCadastrados.contains(crm);
    }

    public void entrarNaConta() {
        while (true) {
            System.out.print("Digite seu CRM: ");
            String crm = sc.nextLine();

            if (!crmsCadastrados.contains(crm)) {
                System.out.println("O CRM informado não está cadastrado!\n");
                break;
            }

            System.out.print("Digite sua senha: ");
            String senha = sc.nextLine();

            if (validarLogin(crm, senha)) {
                System.out.println("Login bem sucedido! Bem-vindo.\n");
                menuInterface();
                break;
            } else {
                System.out.println("Senha incorreta. Tente novamente.");
            }
        }
        initPrograma();
    }

    private boolean validarLogin(String crm, String senha) {
        int index = crmsCadastrados.indexOf(crm);
        if (index != -1) {
            return senhasCadastradas.get(index).equals(senha);
        }
        return false;
    }
    
}
