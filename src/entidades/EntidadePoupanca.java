package entidades;

public class EntidadePoupanca {
	int numero = 0;
	int numeroBase;
	String agencia = "";
	String nomeCliente = "";
	double saldo = 0;
	String tipoConta="Conta Poupança";
	
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
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
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
