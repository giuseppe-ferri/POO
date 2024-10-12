package docManage;

public class Paciente extends Pessoa {
	private String txt;
    private String diagnostico;
    private String tratamento;

    public Paciente(String nome, int dia, int mes, int ano,
                    String email, String telefone, String cpf,String diagnostico, String tratamento) {
        super(nome, dia, mes, ano, email, telefone, cpf);
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
    }
    
    public Paciente() {}

    // Getters e Setters
    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    @Override
    public String info() {
    	txt = "INFORMAÇÕES DO PACIENTE\n\n";
        txt += super.info();
        txt += String.format("\nDiagnóstico: %s\nTratamento: %s", diagnostico, tratamento);

        return txt;
    }
}
