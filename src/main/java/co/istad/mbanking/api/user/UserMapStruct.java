package co.istad.mbanking.api.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User createUserDtoToUser(CeateUserDto ceateUserDto);
    UerDto userToUserDto(User user);
    User userDtoToDto(UerDto user);

}
