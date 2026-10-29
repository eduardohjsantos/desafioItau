package dev.java10x.itauJava10x.Transacoes;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    private BigDecimal valor;
    private OffsetDateTime dataHora;


}
