package cn.abb.oa.mapper;

import cn.abb.oa.pojo.User;
import cn.abb.oa.pojo.UserDto;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;



@Mapper
public interface UserMapper {

    public void addUser(User user);

    public void deleteUserById(long userId);

    public void updateUser(User user);

    public void updateUserPrvt(User user);

    public void updateUserByAdmin(User user);

    public void updateUserLevel(User user);

    //public void updateUserExclLevel(User user);
    public List<User> selectAllUser();

    public List<UserDto> selectAllDto();

    public UserDto selectDtoByName(String userName);

    public User selectUserById(long userId);

    public User selectUserByEmail(String userEmail);

    public List<User> selectUserByLevel(int userLevel);

    public List<User> selectUserByDepart(long userDepartId);

    public User login(String userEmail, String userPassword);

    /*public List<User> selectDepartNameByUser();*/
}
