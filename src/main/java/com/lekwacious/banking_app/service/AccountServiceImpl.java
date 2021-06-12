package com.lekwacious.banking_app.service;

import com.lekwacious.banking_app.data.models.Account;
import com.lekwacious.banking_app.data.payloads.reponse.ApiResponse;
import com.lekwacious.banking_app.data.payloads.request.AccountInfoRequest;
import com.lekwacious.banking_app.data.payloads.request.AccountRequest;
import com.lekwacious.banking_app.data.payloads.request.DepositRequest;
import com.lekwacious.banking_app.data.payloads.request.WithDrawalRequest;
import com.lekwacious.banking_app.exception.ResourcesNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService{
    private List<Account> listOfAccounts = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    public String generateAccountNumber() {
        Random rnd = new Random();
        char [] digits = new char[10];
        digits[0] = (char) (rnd.nextInt(9) + '1');
        for(int i=1; i<digits.length; i++) {
            digits[i] = (char) (rnd.nextInt(10) + '0');
        }
        return String.valueOf(digits);
    }
    @Override
    public ApiResponse createAccount(AccountRequest accountRequest) {

            Account account = new Account();

            account.setAccountName(accountRequest.getAccountName());
            account.setAccountPassword(accountRequest.getAccountPassword());
            account.setAccountNumber(generateAccountNumber());
            account.setAccountBalance(0.00);
            listOfAccounts.add(account);
            System.out.println(listOfAccounts);

        return new ApiResponse(true, "success", HttpStatus.CREATED);
    }

    @Override
    public ApiResponse withdraw(WithDrawalRequest withDrawalRequest) {
        for (Account account : listOfAccounts)
            if (!account.getAccountNumber().equals(withDrawalRequest.getAccountNumber())){
                throw new RuntimeException("Account Number does not exist");
            }
      else if (!account.getAccountPassword().equals(withDrawalRequest.getAccountPassword())){
         throw new ResourcesNotFoundException("Your password is not correct");

      }

      else if(withDrawalRequest.getWithdrawalAmount() < 1.00){
          throw new ResourcesNotFoundException("You cannot withdraw amount less than 1.00 Naira");
      }
      else if (account.getAccountBalance() - withDrawalRequest.getWithdrawalAmount() < 500.00){
          throw new ResourcesNotFoundException("You most have at 500.00 Naira left in your Account");
      }
      else {
                account.withdraw(withDrawalRequest.getWithdrawalAmount());

      }
        return new ApiResponse(true, "Take your cash", HttpStatus.OK);
    }

    @Override
    public ApiResponse deposit(DepositRequest depositRequest) {
        for (Account account : listOfAccounts) {
            if (!account.getAccountNumber().equals(depositRequest.getAccountNumber())) {
                throw new RuntimeException("Account Number does not exist");
            } else if (depositRequest.getAmount() < 1.00 || depositRequest.getAmount() > 1000000.00) {
                throw new ResourcesNotFoundException("Your can not deposit amount less than 1.00 naira or greater than 1,000,000.00 naira");
            }
            else
               account.deposit(depositRequest.getAmount());

        }
        System.out.println(listOfAccounts);
        return new ApiResponse(true, "Take your cash", HttpStatus.OK);
    }

    @Override
    public ApiResponse getAccountInfo(AccountInfoRequest accountInfoRequest) {
        for (Account account : listOfAccounts)
            if (!account.getAccountNumber().equals(accountInfoRequest.getAccountNumber())) {
                throw new RuntimeException("Account Number does not exist");
            } else if (!account.getAccountPassword().equals(accountInfoRequest.getAccountPassword())) {
                throw new ResourcesNotFoundException("Your password is not correct");

            }
        System.out.println(listOfAccounts);

        return new ApiResponse(true, "successful", HttpStatus.OK);

    }
}
