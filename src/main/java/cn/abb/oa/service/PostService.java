package cn.abb.oa.service;

import cn.abb.oa.pojo.Post;

import java.util.List;

public interface PostService {
    public void addInfo(Post post);

    public void deleteInfo(long postId);

    public void updateInfo(Post post);

    public Post selectPositionById(long postId);

    public List<Post> selectPositionByName(String postName);

    public List<Post> selectAllPosition();
}
