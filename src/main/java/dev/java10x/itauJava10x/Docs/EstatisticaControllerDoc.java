package dev.java10x.itauJava10x.Docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Estatisticas",
    description = "Endingpoint para calcular e apresentar as Estatisticas"
)
public interface EstatisticaControllerDoc {

    @Operation(summary = "Calcular Estatísticas",
        description = "Calcula as estatísticas das transações nos último intervalo de tempo definido"
    )
    @ApiResponse(responseCode = "200",
        description = "Estatisticas calculadas com sucesso"
    )
    public ResponseEntity<Void> estatistica();

}
