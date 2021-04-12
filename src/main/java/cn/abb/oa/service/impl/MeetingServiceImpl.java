package cn.abb.oa.service.impl;

import cn.abb.oa.mapper.MeetingMapper;
import cn.abb.oa.pojo.Meeting;
import cn.abb.oa.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MeetingService")
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MeetingMapper meetingMapper;

    public void addInfo(Meeting meeting) {
        meetingMapper.addInfo(meeting);
    }

    public void deleteInfo(long meetingId) {
        meetingMapper.deleteInfo(meetingId);
    }

    public void updateInfo(Meeting meeting) {
        meetingMapper.updateInfo(meeting);
    }

    public Meeting selectMeetingById(long meetingId) {
        return meetingMapper.selectMeetingById(meetingId);
    }

    public List<Meeting> selectMeetingByStartTime(String meetingStartTime) {
        return meetingMapper.selectMeetingByStartTime(meetingStartTime);
    }

    public List<Meeting> selectAllMeeting() {
        return meetingMapper.selectAllMeeting();
    }

    public long maxId() {
        return meetingMapper.maxId();
    }
}
