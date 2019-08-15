package com.leebx.mapper;

import com.leebx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM tb_user WHERE username=#{username} AND PASSWORD=#{password}")
    public User login(String username,String password);
    @Insert("INSERT INTO tb_user VALUES(#{id},#{username},#{password},#{phone},#{created},#{code},#{state})")
    public void register(User user);
    @Update("UPDATE tb_user SET state=#{state} WHERE id=#{id}")
    public void updateState(String state,Long id);
}
