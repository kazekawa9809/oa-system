package cn.abb.oa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announce {

    Long announceId;
    String announceTitle;
    String announceCover;
    Long announceCreator;
    String announceContent;
    Date announceCreateTime;
    Date announceUpdateTime;

}
