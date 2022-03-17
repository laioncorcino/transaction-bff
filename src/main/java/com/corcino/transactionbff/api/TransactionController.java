package com.corcino.transactionbff.api;

import com.corcino.transactionbff.json.TransactionRequest;
import com.corcino.transactionbff.json.TransactionResponse;
import com.corcino.transactionbff.json.UpdateRequest;
import com.corcino.transactionbff.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/transaction")
@Tag(name = "/transaction", description = "API's group for manipulation financial transactions")
@AllArgsConstructor
public class TransactionController {

    private TransactionService transactionService;

    @Operation(description = "API to create a financial transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Authentication error"),
            @ApiResponse(responseCode = "403", description = "Authorization error"),
            @ApiResponse(responseCode = "500", description = "Internal error server")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TransactionResponse> sendTransaction(@RequestBody @Valid TransactionRequest transactionRequest) throws Exception {
        TransactionResponse transactionResponse = transactionService.createTransaction(transactionRequest);
        return Mono.just(transactionResponse);
    }


    @Operation(description = "API to find transaction by transactionId")
    @Parameters(value = {
            @Parameter(name = "transactionId", in = ParameterIn.PATH)
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction ok return"),
            @ApiResponse(responseCode = "401", description = "Authentication error"),
            @ApiResponse(responseCode = "403", description = "Authorization error"),
            @ApiResponse(responseCode = "404", description = "Transaction not found"),
            @ApiResponse(responseCode = "500", description = "Internal error server")
    })
    @GetMapping(value = "/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TransactionResponse> getTransaction(@PathVariable("transactionId") String transactionId) {
        TransactionResponse transaction = transactionService.getTransactionById(transactionId);
        return Mono.just(transaction);
    }


    @Operation(description = "API to update transaction by transactionId")
    @Parameters(value = {
            @Parameter(name = "transactionId", in = ParameterIn.PATH)
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction updated successfully"),
            @ApiResponse(responseCode = "401", description = "Authentication error"),
            @ApiResponse(responseCode = "403", description = "Authorization error"),
            @ApiResponse(responseCode = "404", description = "Transaction not found"),
            @ApiResponse(responseCode = "500", description = "Internal error server")
    })
    @PutMapping(value = "/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> updateTransaction(@PathVariable("transactionId") String transactionId, UpdateRequest updateRequest) {
        return Mono.empty();
    }


    @Operation(description = "API to delete transaction by transactionId")
    @Parameters(value = {
            @Parameter(name = "transactionId", in = ParameterIn.PATH)
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Transaction delete successfully"),
            @ApiResponse(responseCode = "401", description = "Authentication error"),
            @ApiResponse(responseCode = "403", description = "Authorization error"),
            @ApiResponse(responseCode = "404", description = "Transaction not found"),
            @ApiResponse(responseCode = "500", description = "Internal error server")
    })
    @DeleteMapping(value = "/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> deleteTransaction(@PathVariable("transactionId") String transactionId) {
        return Mono.empty();
    }

}










