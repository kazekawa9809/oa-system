package cn.abb.oa.service;

import cn.abb.oa.pojo.Depart;

import java.util.List;

public interface DepartService {
    public void addInfo(Depart depart);

    public void deleteInfo(long departId);

    public void updateInfo(Depart depart);

    public Depart selectDepartById(long departId);

    public List<Depart> selectDepartByName(String departName);

    public List<Depart> selectAllDepart();

}
