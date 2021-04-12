package cn.abb.oa.service.impl;

import cn.abb.oa.mapper.UserMapper;
import cn.abb.oa.pojo.User;
import cn.abb.oa.pojo.UserDto;
import cn.abb.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void addUser(User user) {
        System.out.println(user);
        userMapper.addUser(user);
    }

    @Override
    public void deleteUserById(long userId) {
        userMapper.deleteUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        System.out.println(user);
        userMapper.updateUser(user);
    }

    @Override
    public void updateUserPrvt(User user) {
        userMapper.updateUserPrvt(user);
    }

    @Override
    public void updateUserByAdmin(User user) {
        userMapper.updateUserByAdmin(user);
    }



    @Override
    public void updateUserLevel(User user) {
        userMapper.updateUserLevel(user);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public List<UserDto> selectAllDto() {
        return userMapper.selectAllDto();
    }

    @Override
    public UserDto selectDtoByName(String userName) {
        return userMapper.selectDtoByName(userName);
    }

    @Override
    public User selectUserById(long userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public User selectUserByEmail(String userEmail) {
        return userMapper.selectUserByEmail(userEmail);
    }

    @Override
    public List<User> selectUserByLevel(int userLevel) {
        return userMapper.selectUserByLevel(userLevel);
    }

    @Override
    public List<User> selectUserByDepart(long userDepartId) {
        return userMapper.selectUserByDepart(userDepartId);
    }

    @Override
    public User login(String userEmail, String userPassword) {
        return userMapper.login(userEmail,userPassword);
    }

    /*@Override
    public List<User> selectDepartNameByUser() {
        List<User> users = userMapper.selectDepartNameByUser();
        System.out.println(users);
        return users;
    }*/
}
