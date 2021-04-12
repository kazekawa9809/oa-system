package cn.abb.oa.service.impl;

import cn.abb.oa.mapper.PostMapper;
import cn.abb.oa.pojo.Post;
import cn.abb.oa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PostService")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    public void addInfo(Post position) {
        postMapper.addInfo(position);
    }

    public void deleteInfo(long positionId) {
        postMapper.deleteInfo(positionId);
    }

    public void updateInfo(Post position) {
        postMapper.updateInfo(position);
    }

    public Post selectPositionById(long positionId) {
        return postMapper.selectPositionById(positionId);
    }

    public List<Post> selectPositionByName(String positionName) {
        return postMapper.selectPositionByName(positionName);
    }

    public List<Post> selectAllPosition() {
        return postMapper.selectAllPosition();
    }
}
