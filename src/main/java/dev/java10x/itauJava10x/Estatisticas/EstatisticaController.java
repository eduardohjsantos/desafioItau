package dev.java10x.itauJava10x.Estatisticas;

import dev.java10x.itauJava10x.Docs.EstatisticaControllerDoc;
import dev.java10x.itauJava10x.Transacoes.TransacaoRepository;
import dev.java10x.itauJava10x.Transacoes.TransacaoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.OffsetDateTime;




@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController implements EstatisticaControllerDoc {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @GetMapping
    public ResponseEntity estatistica(){

        log.info("Calculando estatísticas de transações nos últimos : " + estatisticaProperties.segundos() + " segundos");

        final var horarioInicial = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());

        return ResponseEntity.ok(transacaoRepository.estatistica(horarioInicial));
    }


}
