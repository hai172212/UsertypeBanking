package co.istad.mbanking.api.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserMapper userMapper;
    private final UserMapStruct userMapStruct;


    @Override
    public UerDto CreateNewUser(CeateUserDto ceateUserDto) {
        User user = userMapStruct.createUserDtoToUser(ceateUserDto);
        System.out.println(user);

        userMapper.insert(user);
        log.info("User = {}",user.getId());
        return this.findUserById(user.getId());
    }

    @Override
    public UerDto findUserById(Integer id) {
        User user = userMapper.selectById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User With %d is not found")));
        return userMapStruct.userToUserDto(user);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        Boolean isFound = userMapper.existById(id);
//        System.out.println(isFound);
        if(isFound){
            //delete
            userMapper.deleteById(id);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User With %d is not found"));

    }

    @Override
    public Integer updateISDeletedStatusById(Integer id ,boolean status) {
        Boolean isExisted = userMapper.existById(id);
        if(isExisted){
            userMapper.updateIsDeletedById(id , status);
            return id;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User With %d is not found"));


    }
}
