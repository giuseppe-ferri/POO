package docManage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
	private static int nextPid = 0;
	private int pid;
	private String nome;
	private int dia;
	private int mes;
	private int ano;
	private LocalDate dataNascimento;
	private String email;
	private String telefone;
	private String cpf;
	private String tipoInfo;
	private String txt;
	
//	LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
	public Pessoa(int pid, String name, int dia, int mes, int ano, LocalDate dataNascimento,
			String email, String telefone, String cpf) {
		this.pid = nextPid++;
		this.nome = name;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
	}
	
	// Overload
	public Pessoa() {
		this.pid = nextPid++;
	}
	
	// Getters e Setters
	public int getPID() {
		return pid;
	}
	
    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
        atualizarDataNascimento();
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
        atualizarDataNascimento();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
        atualizarDataNascimento();
    }

    public void setDataNascimento(int dia, int mes, int ano) {
    	this.dataNascimento = LocalDate.of(ano, mes, dia);
    }
    
    public String getDataNascimento() {
        return dataNascimentoFormat();
    }

    private void atualizarDataNascimento() {
        this.dataNascimento = LocalDate.of(ano, mes, dia);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    private String dataNascimentoFormat() {
    	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	return this.dataNascimento.format(formatador);
    }
    
    public String info() {
    	tipoInfo = "INFORMAÇÕES PESSOAIS";
    	txt = String.format("%s\n\nID: %s\nNome: %s\nData de Nascimento: %s\nEmail: %s"
    			+ "\nTelefone: %s\nCPF: %s", tipoInfo, pid ,nome, dataNascimentoFormat(), email, telefone, cpf );
    	return txt;
    }
}
