package cn.abb.oa.service;

import cn.abb.oa.pojo.Announce;

import java.util.List;


public interface AnnounceService {
    public void addInfo(Announce announce);

    public void deleteInfo(long announceId);

    public void updateInfo(Announce announce);

    public Announce selectAnnounceById(long announceId);

    public List<Announce> selectAnnounceByCreateTime(String announceCreateTime);

    public List<Announce> selectAllAnnounce();

    public Announce selectAnnounceById(Long announceId);
}
