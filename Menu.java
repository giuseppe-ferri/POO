package docManage;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Menu implements Crud {
    private Scanner sc = new Scanner(System.in);
    private String userOption;
    private List<Paciente> pacientes;

    public Menu() {
        this.pacientes = new ArrayList<>();
        initPacientes(); // Initialize with sample patients
    }

    private void initPacientes() {
        pacientes.add(new Paciente("Ana Souza", 25, 12, 1988, "ana.souza@example.com", "987654321", "444.555.666-77", "Hipertensão Arterial", "Mudança de dieta e exercícios"));
        pacientes.add(new Paciente("Carlos Lima", 10, 11, 1975, "carlos.lima@example.com", "123456789", "123.456.789-10", "Diabetes Tipo 2", "Insulina e dieta controlada"));
        pacientes.add(new Paciente("Maria Clara", 5, 3, 1992, "maria.clara@example.com", "321654987", "987.654.321-00", "Asma", "Inaladores e exercícios respiratórios"));
        pacientes.add(new Paciente("João Silva", 15, 8, 1980, "joao.silva@example.com", "654123987", "654.321.987-11", "Artrite", "Fisioterapia e medicação"));
        pacientes.add(new Paciente("Fernanda Costa", 20, 9, 1995, "fernanda.costa@example.com", "147258369", "369.258.147-12", "Alergia Alimentar", "Dieta especializada"));
        pacientes.add(new Paciente("Lucas Mendes", 30, 6, 1983, "lucas.mendes@example.com", "159357486", "852.963.741-11", "Hipertensão", "Medicamento contínuo"));
        pacientes.add(new Paciente("Paula Ramos", 17, 4, 1979, "paula.ramos@example.com", "951753852", "135.791.246-13", "Ansiedade", "Terapia e medicação"));
        pacientes.add(new Paciente("David Alves", 9, 1, 1965, "david.alves@example.com", "357951456", "246.813.579-14", "Colesterol Alto", "Exercícios e dieta"));
        pacientes.add(new Paciente("Sandra Oliveira", 23, 5, 2000, "sandra.oliveira@example.com", "159246753", "753.951.852-10", "Hipotireoidismo", "Hormônio sintético"));
        pacientes.add(new Paciente("Renato Fernandes", 19, 7, 1972, "renato.fernandes@example.com", "852741963", "963.852.741-15", "Bronquite", "Tratamento respiratório"));
    }

    public void menuInterface() {
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Adicionar novo paciente");
            System.out.println("2. Listar todos os pacientes");
            System.out.println("3. Atualizar os dados do paciente");
            System.out.println("4. Remover paciente");
            System.out.print("5. Sair\nOpção >> ");
            userOption = sc.nextLine();
            System.out.println();
            option(userOption);
        } while (!userOption.equals("5"));
    }

    public void adicionar() {
        System.out.println("CADASTRAR NOVO PACIENTE\n");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        int dia, mes, ano;
        while (true) {
            try {
                System.out.print("Data de nascimento (dia mês ano): ");
                dia = sc.nextInt();
                mes = sc.nextInt();
                ano = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Tente novamente.");
                sc.nextLine(); 
            }
        }

        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Diagnóstico: ");
        String diagnostico = sc.nextLine();
        System.out.print("Tratamento: ");
        String tratamento = sc.nextLine();

        Paciente novoPaciente = new Paciente(nome, dia, mes, ano, email, telefone, cpf, diagnostico, tratamento);
        pacientes.add(novoPaciente);
        System.out.println("Paciente adicionado com sucesso!");
    }

    public void listar() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            System.out.println("LISTA DE PACIENTES\n");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente.info());
                System.out.println();
            }
        }
    }

    public void atualizar() {
        System.out.print("Digite o ID do paciente que deseja atualizar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        Paciente pacienteEncontrado = null;

        for (Paciente paciente : pacientes) {
            if (paciente.getPID() == id) {
                pacienteEncontrado = paciente;
                break;
            }
        }

        if (pacienteEncontrado != null) {
            System.out.println("Atualizando informações para: " + pacienteEncontrado.getName());
            System.out.print("Digite o novo diagnóstico: ");
            String novoDiagnostico = sc.nextLine();
            System.out.print("Digite o novo tratamento: ");
            String novoTratamento = sc.nextLine();
            pacienteEncontrado.setDiagnostico(novoDiagnostico);
            pacienteEncontrado.setTratamento(novoTratamento);
            System.out.println("Informações atualizadas com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public void remover() {
        System.out.print("Digite o ID do paciente que deseja remover: ");
        int id = sc.nextInt();
        sc.nextLine();
        Paciente pacienteParaRemover = null;

        for (Paciente paciente : pacientes) {
            if (paciente.getPID() == id) {
                pacienteParaRemover = paciente;
                break;
            }
        }

        if (pacienteParaRemover != null) {
            pacientes.remove(pacienteParaRemover);
            System.out.println("Paciente removido com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private void sair() {
        System.out.println("Saindo...");
        sc.close();
        System.exit(0);
    }

    private void option(String option) {
        switch (option) {
            case "1":
                adicionar();
                break;
            case "2":
                listar();
                break;
            case "3":
                atualizar();
                break;
            case "4":
                remover();
                break;
            case "5":
                sair();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }
}
