package cn.abb.oa.mapper;

import cn.abb.oa.pojo.MeetingDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeetingDetailMapper {
    public void addMeetingDt(MeetingDetail meetingDetail);
    public void deleteMeetingDt(long meetingId);
    public void updateMeetingDt(List<MeetingDetail> meetingDetail);
    public List<MeetingDetail> selectAllMeetingDt();
    public List<MeetingDetail> selectAllMeetingDtByID(long meetingId);
    public List<MeetingDetail> selectMeetingDtByID(long participantId);
}
