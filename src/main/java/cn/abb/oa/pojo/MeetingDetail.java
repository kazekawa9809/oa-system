package cn.abb.oa.pojo;

import lombok.Data;

@Data
public class MeetingDetail {
    Meeting meeting;
    UserDto creator;
    UserDto participant;
    long meetingId;
    long creatorId;
    long participantId;
}
