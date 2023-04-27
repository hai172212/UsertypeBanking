package co.istad.mbanking.api.accounttype;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;
@Repository
@Mapper
public interface AccountTypeMapper {
    @SelectProvider(type = AccountTypeProvider.class , method = "buildSelectSQL")
    List<AccountType> select();
}
