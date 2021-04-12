package cn.abb.oa.mapper;

import cn.abb.oa.pojo.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    public void addInfo(Post post);

    public void deleteInfo(long postId);

    public void updateInfo(Post post);

    public Post selectPositionById(long postId);

    public List<Post> selectPositionByName(String postName);

    public List<Post> selectAllPosition();
}
