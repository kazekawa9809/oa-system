package cn.abb.oa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import cn.abb.oa.pojo.Depart;


@Data
public class User {

    private Long userId;
    private String userName;
    private String userTel;
    private String userEmail;
    private String userPassword;
    private Long userDepartId;
    private Long userPositionId;
    private Long userUpperId;
    private Long userLevel;
    private Depart depart;
    private Post post;

    public User(Long userId, String userName, String userTel, String userEmail, String userPassword, Long userDepartId, Long userPositionId, Long userUpperId, Long userLevel) {
        this.userId = userId;
        this.userName = userName;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userDepartId = userDepartId;
        this.userPositionId = userPositionId;
        this.userUpperId = userUpperId;
        this.userLevel = userLevel;
    }
}
