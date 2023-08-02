package com.maksimprivalov.springbank;

import com.maksimprivalov.springbank.model.TransferBalance;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController("/balance")
@AllArgsConstructor
public class BankController {

    private final BankService bankService;


    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accoutnId){
        return bankService.getBalance(accoutnId);
    }
    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance){
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }
    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance){
        bankService.makeTransfer(transferBalance);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        log.error(e.getMessage());
        return "Мама, я сломался..";
    }
}
