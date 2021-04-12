package cn.abb.oa.mapper;

import cn.abb.oa.pojo.Announce;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnounceMapper {
    public void addInfo(Announce announce);

    public void deleteInfo(long announceId);

    public void updateInfo(Announce announce);

    public Announce selectAnnounceById(long announceId);

    public List<Announce> selectAnnounceByCreateTime(String announceCreateTime);

    public List<Announce> selectAllAnnounce();

    public Announce selectAnnounceById(Long announceId);
}
