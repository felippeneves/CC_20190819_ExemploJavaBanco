package br.rafael.myapplicationconta;

import java.util.Calendar;

public class OperacaoRealizada {

    public static final int TIPO_OPERACAO_CREDITO = 1;
    public static final int TIPO_OPERACAO_DEBITO = 2;

    private Calendar dataOperacao;
    private int tipoOperacao;
    private Double valorOperacao;

    public OperacaoRealizada(int tipoOperacao, Double valorOperacao) {
        this.dataOperacao = Calendar.getInstance();
        this.tipoOperacao = tipoOperacao;
        this.valorOperacao = valorOperacao;
    }

    public Calendar getDataOperacao() {
        return dataOperacao;
    }

    public int getTipoOperacao() {
        return tipoOperacao;
    }

    public Double getValorOperacao() {
        return valorOperacao;
    }
}
