package cn.abb.oa.pojo;

import lombok.Data;

@Data
public class Post {
    Long postId;
    String postName;
    String postDescription;

    public Post(Long postId, String postName, String postDescription) {
        this.postId = postId;
        this.postName = postName;
        this.postDescription = postDescription;
    }
}
