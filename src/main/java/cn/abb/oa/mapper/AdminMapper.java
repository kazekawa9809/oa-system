package cn.abb.oa.mapper;

import cn.abb.oa.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    public void addInfo(Admin admin);

    public void deleteInfo(long adminId);

    public void updateInfo(Admin admin);

    public Admin selectAdminById(long adminId);

    public Admin selectAdminByEmail(String adminEmail);

    public List<Admin> selectAllAdmin();
}
