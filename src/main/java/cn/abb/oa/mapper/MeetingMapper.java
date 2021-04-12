package cn.abb.oa.mapper;

import cn.abb.oa.pojo.Meeting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeetingMapper {
    public void addInfo(Meeting meeting);

    public void deleteInfo(long meetingId);

    public void updateInfo(Meeting meeting);

    public Meeting selectMeetingById(long meetingId);

    public List<Meeting> selectMeetingByStartTime(String meetingStartTime);

    public List<Meeting> selectAllMeeting();

    public long maxId();
}
