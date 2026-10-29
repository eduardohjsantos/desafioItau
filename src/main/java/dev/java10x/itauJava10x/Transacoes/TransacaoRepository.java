package dev.java10x.itauJava10x.Transacoes;

import dev.java10x.itauJava10x.Estatisticas.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TransacaoRepository{

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();


    public void salvarDados(TransacaoRequest transacaoRequest){
        listaDeTransacoes.add(transacaoRequest);
    }


    public void limparDados(TransacaoRequest transacaoRequest){

    }

    public List<TransacaoRequest> getListaDeTransacoes(){
        return listaDeTransacoes;
    }

    public void deletarDados(){
        listaDeTransacoes.clear();
    }

    public EstatisticaDTO estatistica(OffsetDateTime horarioInicial){
        long count;
        if (listaDeTransacoes.isEmpty()){
            return new EstatisticaDTO(0,0.0,0.0,0.0,0.0);
        }
        final var summary = listaDeTransacoes.stream()
        .filter(t ->
                t.getDataHora().isAfter(horarioInicial) || t.getDataHora().isEqual(horarioInicial))
        .mapToDouble(t -> t.getValor().doubleValue())
        .summaryStatistics();

        return new EstatisticaDTO(
            summary.getCount(),
            summary.getSum(),
            summary.getAverage(),
            summary.getMin(),
            summary.getMax());
    }

}
