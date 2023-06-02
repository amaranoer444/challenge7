package com.example.challenge_chapter_4.Controller;

import com.example.challenge_chapter_4.Model.DataTransactionEntity;
import com.example.challenge_chapter_4.Model.TransactionEntity;
import com.example.challenge_chapter_4.Response.CommonResponse;
import com.example.challenge_chapter_4.Response.CommonResponseGenerator;
import com.example.challenge_chapter_4.Service.DataTransactionService;
import com.example.challenge_chapter_4.Service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value ="/DataTransaction")
@Api(value = "DataTransaction")
public class DataTransactioncontroller {
    @Autowired
    TransactionService transactionService;
    @Autowired
    DataTransactionService dataTransactionService;
    @Autowired
    CommonResponseGenerator crg;

    @PostMapping()
    @Operation(description = "Data Transaction")
    @PreAuthorize("hasAuthority('ROLE_USERS')")
    public CommonResponse<TransactionEntity> Buy(@RequestBody DataTransactionEntity transaction2){
        try {
            //TransactionEntity buyTransaction = transactionService.buyTicket(transaction);
            DataTransactionEntity saveTransaction = dataTransactionService.saveDataTransaction(transaction2);
            log.info(String.valueOf(saveTransaction), "Sukses Menambahkan Data " + saveTransaction.getUid_transaction());
            return crg.succsesResponse(saveTransaction, "Sukses Menambahkan Data " + saveTransaction.getId_user());
        }
        catch (Exception e){
            log.warn(String.valueOf(e));
            return crg.failedResponse(e.getMessage());
        }

    }
}
