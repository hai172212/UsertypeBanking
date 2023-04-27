package co.istad.mbanking.api.accounttype;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountTypeSevice{
List<AccountTypeDto> findAll();
}
