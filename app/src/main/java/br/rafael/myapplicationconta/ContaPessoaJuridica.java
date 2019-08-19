package br.rafael.myapplicationconta;

public class ContaPessoaJuridica extends Conta implements OperacoesBancarias{
    private static final Long taxa = 10L;

    private String cnpj;
    private String razaoSocial;


    public ContaPessoaJuridica(Long numero, String nomeBanco, Double saldo, String cnpj, String razaoSocial) {
        super(numero, nomeBanco, saldo);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String getIdentificacaoCorrentista() {
        return cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public Double credito(Double valor) {
        addOperacaoCredito(valor);
        setSaldo(getSaldo() + valor - taxa);
        return getSaldo();
    }

    @Override
    public Double debito(Double valor) {
        addOperacaoDebito(valor);
        setSaldo(getSaldo() - valor - taxa);
        return getSaldo();
    }
}
