package cn.abb.oa.service;

import cn.abb.oa.pojo.Admin;

import java.util.List;

public interface AdminService {
    public void addInfo(Admin admin);

    public void deleteInfo(long adminId);

    public void updateInfo(Admin admin);

    public Admin selectAdminById(long adminId);

    public Admin selectAdminByEmail(String adminEmail);

    public List<Admin> selectAllAdmin();
}
