package cn.abb.oa.mapper;

import cn.abb.oa.pojo.Depart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartMapper {
    public void addInfo(Depart depart);

    public void deleteInfo(long departId);

    public void updateInfo(Depart depart);

    public Depart selectDepartById(long departId);

    public List<Depart> selectDepartByName(String departName);

    public List<Depart> selectAllDepart();
}
