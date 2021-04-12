package cn.abb.oa.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Meeting {
    long meetingId;
    String meetingTitle;
    String meetingDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date meetingCreateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date meetingStartTime;
    long meetingRoom;

    public Meeting(Long meetingId, String meetingTitle, String meetingDescription, Date meetingCreateTime, Date meetingStartTime, long meetingRoom) {
        this.meetingId = meetingId;
        this.meetingTitle = meetingTitle;
        this.meetingDescription = meetingDescription;
        this.meetingCreateTime = meetingCreateTime;
        this.meetingStartTime = meetingStartTime;
        this.meetingRoom = meetingRoom;
    }
}
