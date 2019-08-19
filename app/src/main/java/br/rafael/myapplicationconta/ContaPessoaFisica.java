package br.rafael.myapplicationconta;

public class ContaPessoaFisica extends Conta implements OperacoesBancarias{
    private static final Long taxa = 5l;

    private String cpf;
    private String nome;

    public ContaPessoaFisica(Long numero, String nomeBanco, Double saldo, String cpf, String nome) {
        super(numero, nomeBanco, saldo);
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override
    public String getIdentificacaoCorrentista() {
        return cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
