package cn.abb.oa.service.impl;

import cn.abb.oa.mapper.AnnounceMapper;
import cn.abb.oa.pojo.Announce;
import cn.abb.oa.service.AnnounceService;
import cn.abb.oa.utils.MarkDownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AnnounceService")
public class AnnounceServiceImpl implements AnnounceService {

    @Autowired
    private AnnounceMapper announceMapper;

    public void addInfo(Announce announce) {
        announceMapper.addInfo(announce);
    }

    public void deleteInfo(long announceId) {
        announceMapper.deleteInfo(announceId);
    }

    public void updateInfo(Announce announce) {
        announceMapper.updateInfo(announce);
    }

    public Announce selectAnnounceById(long announceId) {
        return announceMapper.selectAnnounceById(announceId);
    }

    public List<Announce> selectAnnounceByCreateTime(String announceCreateTime) {
        return announceMapper.selectAnnounceByCreateTime(announceCreateTime);
    }

    public List<Announce> selectAllAnnounce() {
        return announceMapper.selectAllAnnounce();
    }

    public Announce selectAnnounceById(Long announceId) {
        Announce announce = announceMapper.selectAnnounceById(announceId);
        String html_content = MarkDownUtil.mdToHtml(announce.getAnnounceContent());
        announce.setAnnounceContent(html_content);
        return announce;
    }
}
