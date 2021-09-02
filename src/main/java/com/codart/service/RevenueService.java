package com.codart.service;

import java.util.List;
import java.util.Arrays;
import com.codart.model.Account;

/**
 *
 * @author Robson
 */
public class RevenueService {

    public boolean updateAccount(Account account) throws RuntimeException, 
            InterruptedException {

        if(isValidAgency(account.getAgency())) return false;
        if(isValidAccount(account.getAccount())) return false;
        if(isStatusValid(account.getStatus())) return false;
        fakeResponseTime();
        simulateFakeError();
        return true;
    }

    private void simulateFakeError() throws RuntimeException {
        long randomError = Math.round(Math.random() * 1000);
        if (randomError == 500) {
            throw new RuntimeException("Error");
        }
    }

    private void fakeResponseTime() throws InterruptedException {
        long wait = Math.round(Math.random() * 4000) + 1000;
        Thread.sleep(wait);
    }

    private boolean isStatusValid(String status) {
        List tipos = Arrays.asList("A", "I", "B", "P");
        return status == null || !tipos.contains(status);
    }

    private boolean isValidAccount(String account) {
        return account == null || account.length() != 6;
    }

    private boolean isValidAgency(String agency) {
        return agency == null || agency.length() != 4;
    }
}
