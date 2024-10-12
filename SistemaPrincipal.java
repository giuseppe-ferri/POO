package docManage;

import java.util.ArrayList;
import java.util.List;

public class SistemaPrincipal {
    public static void main(String[] args) {
        List<Paciente> pacientes = new ArrayList<>();

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

        for (Paciente paciente : pacientes) {
            System.out.println(paciente.info());
            System.out.println();
        }
    }
}
