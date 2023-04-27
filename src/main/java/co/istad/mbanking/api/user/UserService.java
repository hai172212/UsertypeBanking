package co.istad.mbanking.api.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UerDto CreateNewUser(CeateUserDto ceateUserDto);
    UerDto findUserById(Integer id);
    Integer deleteUserById(Integer id);
    Integer updateISDeletedStatusById(Integer id , boolean status);

}
