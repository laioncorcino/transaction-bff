package com.corcino.transactionbff.transaction.api;

import com.corcino.transactionbff.transaction.json.TransactionRequest;
import com.corcino.transactionbff.transaction.json.TransactionResponse;
import com.corcino.transactionbff.transaction.json.UpdateRequest;
import com.corcino.transactionbff.transaction.service.TransactionService;
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
@Tag(name = "/api/v1/transaction", description = "API's group for manipulation financial transactions")
@AllArgsConstructor
public class TransactionController {

    private TransactionService transactionService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "API to create a financial transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Authentication error"),
            @ApiResponse(responseCode = "403", description = "Authorization error"),
            @ApiResponse(responseCode = "500", description = "Internal error server")
    })
    public Mono<TransactionResponse> sendTransaction(@RequestBody @Valid TransactionRequest transactionRequest) throws Exception {
        TransactionResponse transactionResponse = transactionService.createTransaction(transactionRequest);
        return Mono.just(transactionResponse);
    }


    @GetMapping(value = "/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public Mono<TransactionResponse> getTransaction(@PathVariable String transactionId) {
        TransactionResponse transaction = transactionService.getTransactionById(transactionId);
        return Mono.just(transaction);
    }


    @PutMapping(value = "/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
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
    public Mono<String> updateTransaction(@PathVariable("transactionId") String transactionId, UpdateRequest updateRequest) {
        return Mono.empty();
    }


    @DeleteMapping(value = "/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public Mono<Void> deleteTransaction(@PathVariable("transactionId") String transactionId) {
        return Mono.empty();
    }

}










