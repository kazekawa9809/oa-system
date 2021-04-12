package cn.abb.oa.service.impl;

import cn.abb.oa.mapper.DepartMapper;
import cn.abb.oa.pojo.Depart;
import cn.abb.oa.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DepartService")
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartMapper departMapper;

    public void addInfo(Depart depart) {
        departMapper.addInfo(depart);
    }

    public void deleteInfo(long departId) {
        departMapper.deleteInfo(departId);
    }

    public void updateInfo(Depart depart) {
        departMapper.updateInfo(depart);
    }

    public Depart selectDepartById(long departId) {
        return departMapper.selectDepartById(departId);
    }

    public List<Depart> selectDepartByName(String departName) {
        return departMapper.selectDepartByName(departName);
    }

    public List<Depart> selectAllDepart() {
        return departMapper.selectAllDepart();
    }
}
