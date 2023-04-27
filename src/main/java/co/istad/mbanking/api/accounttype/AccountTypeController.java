package co.istad.mbanking.api.accounttype;

import co.istad.mbanking.api.base.BaseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/account-types")
@RequiredArgsConstructor
public class AccountTypeController {
    private final AccountTypeSevice accountTypeSevice;

    @GetMapping()
    public BaseRest<?> findAll(){
        var accountTypeDtoList = accountTypeSevice.findAll();
        return BaseRest.builder()
                .status(true).code(HttpStatus.OK.value())
                .message("Account type have been found")
                .timeStap(LocalDateTime.now())
                .data(accountTypeDtoList)
                .build();
    }
}
