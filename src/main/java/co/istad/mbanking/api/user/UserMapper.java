package co.istad.mbanking.api.user;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Mapper
public interface UserMapper {
    @InsertProvider(type = UserProvider.class ,method = "buildInsert")
    @Options(useGeneratedKeys = true , keyColumn = "id",keyProperty = "id")
    void insert(@Param("u") User user);
    @SelectProvider(type = UserProvider.class , method = "buildInsertById")
    @Result(column = "student_card_id",property = "studentCardងិត")
    @Result(column = "is_student",property = "isStudent")
    Optional<User> selectById(@Param("id") Integer id);
    @Select("SELECT EXISTS(SELECT * FROM user WHERE id = #{id})")
    Boolean existById(@Param("id") Integer id);
    @DeleteProvider(type = UserProvider.class , method = "buildDeleteByIdSql")
    void deleteById(@Param("id") Integer id);
    @UpdateProvider(type = UserProvider.class , method = "buildUpdateIsDeleteById")
    void updateIsDeletedById(@Param("id") Integer id,@Param(("status")) boolean status);
}
