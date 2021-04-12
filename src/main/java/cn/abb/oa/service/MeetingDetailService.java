package cn.abb.oa.service;

import cn.abb.oa.pojo.MeetingDetail;

import java.util.List;

public interface MeetingDetailService {
    public void addMeetingDt(MeetingDetail meetingDetail);
    public void deleteMeetingDt(long meetingId);
    public void updateMeetingDt(List<MeetingDetail> meetingDetail);
    public List<MeetingDetail> selectAllMeetingDt();
    public List<MeetingDetail> selectAllMeetingDtByID(long meetingId);
    public List<MeetingDetail> selectMeetingDtByID(long participantId);
}
