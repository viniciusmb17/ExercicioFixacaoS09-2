package entities;

public class PessoaJuridica extends Contribuinte{

	private Integer numFuncionarios;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numFuncionarios) {
		super(nome, rendaAnual);
		this.numFuncionarios = numFuncionarios;
	}

	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	@Override
	public Double valorImposto() {
		double imp = 0.16;
		if(numFuncionarios > 10) {
			imp = 0.14;
		}
		return super.getRendaAnual() * imp;
	}
}
