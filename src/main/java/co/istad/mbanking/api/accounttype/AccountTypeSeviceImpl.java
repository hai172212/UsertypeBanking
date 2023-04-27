package co.istad.mbanking.api.accounttype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountTypeSeviceImpl implements AccountTypeSevice{
    private final AccountTypeMapper accountTypeMapper;
    private final AccountTypeMapStuct accountTypeMapStuct;

    @Override
    public List<AccountTypeDto> findAll() {
        List<AccountType> accountTypes = accountTypeMapper.select();
//        System.out.println(accountTypes.get(0).getName());
        return accountTypeMapStuct.toDto(accountTypes);
    }
}
