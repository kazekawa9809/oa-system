package cn.abb.oa.service;

import cn.abb.oa.pojo.Meeting;

import java.util.List;

public interface MeetingService {
    public void addInfo(Meeting meeting);

    public void deleteInfo(long meetingId);

    public void updateInfo(Meeting meeting);

    public Meeting selectMeetingById(long meetingId);

    public List<Meeting> selectMeetingByStartTime(String meetingStartTime);

    public List<Meeting> selectAllMeeting();

    public long maxId();
}
