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
        initPacientes();
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
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Listar todos os pacientes");
            System.out.println("2. Adicionar novo paciente");
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
        System.out.println("Paciente adicionado com sucesso!\n");
    }

    public void listar() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.\n");
        } else {
            System.out.println("LISTA DE PACIENTES");
            
            for (Paciente paciente : pacientes) {
        		System.out.printf("%d - %s\n", paciente.getPID(), paciente.getName());
        	}
            
            System.out.print("Insira o ID do paciente para visualizar suas informações: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println();
            Paciente pacienteEncontrado = null;
            
            for (Paciente paciente : pacientes) {
                if (paciente.getPID() == id) {
                    pacienteEncontrado = paciente;
                    break;
                }
            }
            System.out.println(pacienteEncontrado.info());
            System.out.println();
        }
    }

    public void atualizar() {
    	for (Paciente paciente : pacientes) {
    		System.out.printf("%d - %s\n", paciente.getPID(), paciente.getName());
    	}
        System.out.print("Digite o ID do paciente que deseja atualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println();
        Paciente pacienteEncontrado = null;

        for (Paciente paciente : pacientes) {
            if (paciente.getPID() == id) {
                pacienteEncontrado = paciente;
                break;
            }
        }

        if (pacienteEncontrado != null) {
            System.out.println("\nAtualizando informações para: " + pacienteEncontrado.getName());
            System.out.print("Digite o novo diagnóstico: ");
            String novoDiagnostico = sc.nextLine();
            System.out.print("Digite o novo tratamento: ");
            String novoTratamento = sc.nextLine();
            pacienteEncontrado.setDiagnostico(novoDiagnostico);
            pacienteEncontrado.setTratamento(novoTratamento);
            System.out.println("Informações atualizadas com sucesso!\n");
        } else {
            System.out.println("Paciente não encontrado.\n");
        }
    }

    public void remover() {
    	for (Paciente paciente : pacientes) {
    		System.out.printf("%d - %s\n", paciente.getPID(), paciente.getName());
    	}
        System.out.print("Digite o ID do paciente que deseja remover: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println();
        Paciente pacienteParaRemover = null;

        for (Paciente paciente : pacientes) {
            if (paciente.getPID() == id) {
                pacienteParaRemover = paciente;
                break;
            }
        }

        if (pacienteParaRemover != null) {
            pacientes.remove(pacienteParaRemover);
            System.out.println("Paciente removido com sucesso!\n");
        } else {
            System.out.println("Paciente não encontrado.\n");
        }
    }

    private void sair() {
        System.exit(0);
        sc.close();
    }

    private void option(String UserOption) {
        switch (userOption) {
	        case "1":
	        	listar();
	        	break;
            case "2":
                adicionar();
                break;
            case "3":
                atualizar();
                break;
            case "4":
                remover();
                break;
            case "5":
            	System.out.println("Saindo...");
                sair();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.\n");
                break;
        }
    }
}
