package dev.java10x.itauJava10x.Transacoes;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoRequest transacaoRequest) {

        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Erro: A transação não é valida, transações devem possuir valor maior ou igual a zero");
        }
        if (transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: Data da transação inválida");
        }
        if (transacaoRequest.getValor() == null) {
            throw new IllegalArgumentException("Erro: Campo valor da transação ausente");
        }
        if (transacaoRequest.getDataHora() == null) {
            throw new IllegalArgumentException("Erro: Campo dataHora da transação ausente");
        }
    }
}
