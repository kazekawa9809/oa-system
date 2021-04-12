package cn.abb.oa.service.impl;

import cn.abb.oa.mapper.AdminMapper;
import cn.abb.oa.pojo.Admin;
import cn.abb.oa.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public String adminLogin(String adminEmail, String password) {
        Admin admin = selectAdminByEmail(adminEmail);
        if (admin == null) {
            return "用户不存在";
        } else if (!admin.getAdminPassword().equals(password)) {
            return "用户名或密码错误";
        } else {
            return "success";
        }
    }

    @Override
    public void addInfo(Admin admin) {
        adminMapper.addInfo(admin);
    }

    @Override
    public void deleteInfo(long adminId) {
        adminMapper.deleteInfo(adminId);
    }

    @Override
    public void updateInfo(Admin admin) {
        adminMapper.updateInfo(admin);
    }

    public Admin selectAdminById(long adminId) {
        Admin admin = adminMapper.selectAdminById(adminId);
        return admin;
    }

    public Admin selectAdminByEmail(String adminEmail) {
        Admin admin = adminMapper.selectAdminByEmail(adminEmail);
        return admin;
    }

    public List<Admin> selectAllAdmin() {
        List<Admin> adminList = adminMapper.selectAllAdmin();
        return adminList;
    }
}
