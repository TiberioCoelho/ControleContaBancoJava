package entidades;

public class EntidadeConta {
	int numero = 0;
	int numeroBase;
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	String agencia = "";
	String nomeCliente = "";
	double saldoContaCorrente = 0;
	double saldoContaPoupanca = 0;
	String tipoConta=null;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumeroBase() {
		return numeroBase;
	}
	public void setNumeroBase(int numeroBase) {
		this.numeroBase = numeroBase;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public double getSaldoContaCorrente() {
		return saldoContaCorrente;
	}
	public void setSaldoContaCorrente(double saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}
	public double getSaldoContaPoupanca() {
		return saldoContaPoupanca;
	}
	public void setSaldoContaPoupanca(double saldoContaPoupanca) {
		this.saldoContaPoupanca = saldoContaPoupanca;
	}
	
	
}
