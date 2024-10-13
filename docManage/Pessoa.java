package docManage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public abstract class Pessoa {
	
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
	private String txt;
	
	public Pessoa(String name, int dia, int mes, int ano,
			String email, String telefone, String cpf) {
		this.pid = nextPid++;
		this.nome = name;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.dataNascimento = LocalDate.of(ano, mes, dia);
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
    
    private int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        return Period.between(dataNascimento, hoje).getYears();
    }
    
    public String info() {
    	txt = String.format("ID: %s\nNome: %s\nData de Nascimento: %s\nIdade: %d\nEmail: %s"
    			+ "\nTelefone: %s\nCPF: %s", pid ,nome, dataNascimentoFormat(), calcularIdade(), email, telefone, cpf );
    	return txt;
    }
}
