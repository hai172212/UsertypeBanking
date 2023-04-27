package co.istad.mbanking.api.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

@Repository
public class UserProvider {

    private final String tableName = "users";
    public String buildDeleteByIdSql(){
        return new SQL(){
            {
                DELETE_FROM(tableName);
                WHERE("id = #{id}");

            }

        }.toString();
    }

    public String buildInsert(@Param("u") User user){
        return new SQL(){{
            INSERT_INTO("users");
            VALUES("name","#{u.name}");
            VALUES("gender","#{u.gender}");
            VALUES("one_signal_id","#{u.oneSignal}");
            VALUES("student_card_id","#{u.studentCard}");
            VALUES("is_student","#{u.isStudent}");
        }

        }.toString();
    }
    public String buildInsertById(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("id = #{id}");
        }
        }.toString();
    }

    public String buildUpdateIsDeleteById(){
        return new SQL(){
            {
                UPDATE(tableName);
                SET("is_delete = #{status}");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
