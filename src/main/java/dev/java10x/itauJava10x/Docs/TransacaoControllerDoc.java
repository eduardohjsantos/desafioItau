package dev.java10x.itauJava10x.Docs;


import dev.java10x.itauJava10x.Transacoes.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Tag(name = "Transações",
        description = "Endingpoints de criação de transação"
)
public interface TransacaoControllerDoc {

    @Operation(summary = "Cria transação",
            description = "Recebe uma transação valida e adiciona em uma lista"
    )
    @ApiResponse(responseCode = "201",
            description = "Transação criada com sucesso"
    )
    @ApiResponse(responseCode = "422",
            description = "Erro de validação capturado"
    )
    @ApiResponse(responseCode = "400",
            description = "Erro inesperado no servidor"
    )
    public ResponseEntity<Void> adicionar(@RequestBody TransacaoRequest transacaoRequest);

    @Operation(summary = "Limpa a lista de transações",
            description = "Remove todas as tranções da lista"
    )
    @ApiResponse(responseCode = "200",
            description = "Lista limpa com sucesso"
    )
    public ResponseEntity<Void> deletar();
}
