package co.istad.mbanking.api.user;

import co.istad.mbanking.api.base.BaseError;
import co.istad.mbanking.api.base.BaseRest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public BaseRest<?> buildInsert(@RequestBody @Valid CeateUserDto ceateUserDto){
        UerDto uerDto = userService.CreateNewUser(ceateUserDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been Created SuccessFully")
                .timeStap(LocalDateTime.now())
                .data(uerDto)
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseRest<?> deleteUserById(@PathVariable Integer id){
        Integer deleteId = userService.deleteUserById(id);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been Created SuccessFully")
                .timeStap(LocalDateTime.now())
                .data(deleteId)
                .build();
    }

    @PutMapping("/{id}")
    public BaseRest<?> updateISDeletedStatusById(@PathVariable Integer id ,@RequestBody isDeletedDto dto){
        Integer deleteId = userService.updateISDeletedStatusById(id , dto.status());
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been deleted SuccessFully")
                .timeStap(LocalDateTime.now())
                .data(deleteId)
                .build();
    }


}
