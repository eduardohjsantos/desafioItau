package dev.java10x.itauJava10x.Transacoes;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class TransacaoRequest {

    @NotNull(message = "O valor da transação não deve ser nulo: ")
    @PositiveOrZero(message = "O valor da transação deve ser maior ou igual a zero: ")
    private BigDecimal valor;

    @PastOrPresent(message = "A transação pode ser relizada no passado e no presente: ")
    private OffsetDateTime dataHora;


}
