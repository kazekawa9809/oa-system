package cn.abb.oa.service.impl;

import cn.abb.oa.mapper.MeetingDetailMapper;
import cn.abb.oa.pojo.MeetingDetail;
import cn.abb.oa.service.MeetingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("MeetingDetailService")
public class MeetingDetailServiceImpl implements MeetingDetailService {

    @Autowired
    MeetingDetailMapper meetingDetailMapper;

    @Override
    public void addMeetingDt(MeetingDetail meetingDetailList) {
        meetingDetailMapper.addMeetingDt(meetingDetailList);
    }

    @Override
    public void deleteMeetingDt(long meetingId) {
        meetingDetailMapper.deleteMeetingDt(meetingId);
    }

    @Override
    public void updateMeetingDt(List<MeetingDetail> meetingDetailList) {
        meetingDetailMapper.updateMeetingDt(meetingDetailList);
    }

    @Override
    public List<MeetingDetail> selectAllMeetingDt() {
        return meetingDetailMapper.selectAllMeetingDt();
    }

    @Override
    public List<MeetingDetail> selectAllMeetingDtByID(long meetingId) {
        return meetingDetailMapper.selectAllMeetingDtByID(meetingId);
    }

    @Override
    public List<MeetingDetail> selectMeetingDtByID(long participantId) {
        return meetingDetailMapper.selectMeetingDtByID(participantId);
    }
}
