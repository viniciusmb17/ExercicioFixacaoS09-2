package entities;

public class PessoaFisica extends Contribuinte {

	private Double gastosComSaude;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	public Double valorImposto() {
		double imp;
		if (super.getRendaAnual() < 20000) {
			imp = 0.15;
		} else {
			imp = 0.25;
		}
		return (super.getRendaAnual() * imp) - (gastosComSaude * 0.50);
	}
}
