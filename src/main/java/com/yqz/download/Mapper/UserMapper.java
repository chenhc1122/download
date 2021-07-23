package com.yqz.download.Mapper;


import com.yqz.download.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select(value = "select username , password from  user  where username=#{username}")
    @Results
            ({@Result(property = "username", column = "username"),
                    @Result(property = "password", column = "password")})
    User findUserByName(@Param("username") String username);


    @Insert("insert into user values(#{id},#{username},#{password})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void regist(User user);


    @Select("select id from login.user where username = #{username} and password = #{password}")
    Long login(String username,String password);
}