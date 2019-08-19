package br.rafael.myapplicationconta;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public abstract class Conta {
    private Long numero;
    private String nomeBanco;
    private Double saldo;
    private ArrayList<OperacaoRealizada> operacoesRealizadas;

    public Conta(Long numero, String nomeBanco, Double saldo) {
        this.numero = numero;
        this.nomeBanco = nomeBanco;
        this.saldo = saldo;
        operacoesRealizadas = new ArrayList<>();
    }

    public abstract String getIdentificacaoCorrentista();

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void addOperacaoCredito(Double valor) {
        OperacaoRealizada operacaoRealizada = new OperacaoRealizada(OperacaoRealizada.TIPO_OPERACAO_CREDITO, valor);
        operacoesRealizadas.add(operacaoRealizada);
    }

    public void addOperacaoDebito(Double valor) {
        OperacaoRealizada operacaoRealizada = new OperacaoRealizada(OperacaoRealizada.TIPO_OPERACAO_DEBITO, valor);
        operacoesRealizadas.add(operacaoRealizada);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getExtrato() {
        String retorno = System.lineSeparator();
        for (OperacaoRealizada operacao : operacoesRealizadas) {
            switch (operacao.getTipoOperacao()) {
                case OperacaoRealizada.TIPO_OPERACAO_CREDITO:
                    retorno += operacao.getDataOperacao().getTime().toString()
                            + " - CREDITO = " + operacao.getValorOperacao();
                    break;
                case OperacaoRealizada.TIPO_OPERACAO_DEBITO:
                    retorno += operacao.getDataOperacao().getTime().toString()
                            + " - DEBITO = " + operacao.getValorOperacao();
                    break;
            }
            retorno += System.lineSeparator();
        }
        retorno += "SALDO ATUAL = " + saldo;
        return retorno;
    }
}
