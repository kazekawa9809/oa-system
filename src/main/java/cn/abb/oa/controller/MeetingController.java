package cn.abb.oa.controller;

import cn.abb.oa.pojo.Meeting;
import cn.abb.oa.pojo.MeetingDetail;
import cn.abb.oa.pojo.UserDto;
import cn.abb.oa.service.MeetingDetailService;
import cn.abb.oa.service.MeetingService;
import cn.abb.oa.service.UserService;
import cn.abb.oa.utils.string2date;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private MeetingDetailService meetingDetailService;

    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public String add(Model model){
        List<UserDto> userDtos = userService.selectAllDto();
        model.addAttribute("allUserDto",userDtos);
        return "admin/addMeeting";
    }

    @PostMapping("/addInfo")
    public String addMeeting(Model model,
            /*@RequestParam("meetingId") Long meetingId,*/
                             @RequestParam("meetingTitle") String meetingTitle,
                             @RequestParam("meetingDescription") String meetingDescription,
                             @RequestParam("meetingCreator") String meetingCreator,
                             @RequestParam("meetingCreateTime") String meetingCreateTime,
                             @RequestParam("meetingStartDate") String meetingStartDate,
                             @RequestParam("meetingStartTime") String meetingStartTime,
                             @RequestParam("meetingRoom") Long meetingRoom,
                             @RequestParam("meetingParticipant") List<Long> participantList) throws ParseException {
        Long meetingId = meetingService.maxId()+1;
        Meeting meeting = new Meeting(meetingId ,meetingTitle,meetingDescription, string2date.standardDate(meetingCreateTime),
                string2date.standardDate(meetingStartDate+" "+meetingStartTime+":00"),meetingRoom);

        for (Long participantId : participantList){
            MeetingDetail meetingDetail = new MeetingDetail();
            meetingDetail.setMeetingId(meetingId);
            meetingDetail.setCreatorId(userService.selectDtoByName(meetingCreator).getUserId());
            meetingDetail.setParticipantId(participantId);
            meetingDetailService.addMeetingDt(meetingDetail);
        }

        meetingService.addInfo(meeting);
        System.out.println("add meeting!");
        return "redirect:/meeting/allInfo";
    }

    @RequestMapping("/delete/{meetingId}")
    public String deleteMeeting(@PathVariable long meetingId) {
        meetingService.deleteInfo(meetingId);
        meetingDetailService.deleteMeetingDt(meetingId);
        return "redirect:/meeting/allInfo";
    }

    @GetMapping("/info/{meetingId}")
    @ApiOperation("为更新会议提供信息")
    public String meetingInfo(@PathVariable("meetingId") long meetingId, Model model) {
        Meeting meeting = meetingService.selectMeetingById(meetingId);
        List<MeetingDetail> meetingDetails = meetingDetailService.selectAllMeetingDtByID(meetingId);
        List<UserDto> userDtos = userService.selectAllDto();
        model.addAttribute("allUserDto",userDtos);
        model.addAttribute("updateMeetingInfo",meeting);
        if (meetingDetails.size()!=0) {
            model.addAttribute("meetingDetail", meetingDetails.get(0));
        }
        return "admin/updateMeeting";
    }

    @GetMapping("/detail/{meetingId}")
    @ApiOperation("会议具体信息")
    public String detail(@PathVariable("meetingId") long meetingId, Model model) {
        Meeting meeting = meetingService.selectMeetingById(meetingId);
        List<MeetingDetail> meetingDetails = meetingDetailService.selectAllMeetingDtByID(meetingId);
        List<UserDto> userDtos = userService.selectAllDto();
        model.addAttribute("allUserDto",userDtos);
        model.addAttribute("meetingInfo",meeting);
        model.addAttribute("meetingDetails",meetingDetails);
        return "admin/meetingDetail";
    }


    @PostMapping("/update")
    @ApiOperation("更新会议信息")
    public String updateMeeting(@RequestParam("meetingId") long meetingId,
                                @RequestParam("meetingTitle") String meetingTitle,
                                @RequestParam("meetingCreator") Long meetingCreator,
                                @RequestParam("meetingDescription") String meetingDescription,
                                @RequestParam("meetingCreateTime") String meetingCreateTime,
                                @RequestParam("meetingStartDate") String meetingStartDate,
                                @RequestParam("meetingStartTime") String meetingStartTime,
                                @RequestParam("meetingRoom") long meetingRoom,
                                @RequestParam("meetingParticipant") List<Long> participantList) throws ParseException {
        Meeting meeting = new Meeting(meetingId,meetingTitle,meetingDescription,
                string2date.standardDate(meetingCreateTime),string2date.standardDate(meetingStartDate+" "+meetingStartTime+":00"),meetingRoom);
        meetingService.updateInfo(meeting);
        //Long meetingCreator = meetingDetailService.selectAllMeetingDt().get(0).getCreatorId();
        for (Long participantId : participantList){
            MeetingDetail meetingDetail = new MeetingDetail();
            meetingDetail.setMeetingId(meetingId);
            meetingDetail.setCreatorId(meetingCreator);
            meetingDetail.setParticipantId(participantId);
            meetingDetailService.addMeetingDt(meetingDetail);
        }
        return "redirect:/meeting/allInfo";
    }

    @RequestMapping("/allInfo")
    @ApiOperation("所有会议信息")
    public String selectAllMeeting(Model model) {
        List<Meeting> meetingList = meetingService.selectAllMeeting();
        model.addAttribute("meetingList", meetingList);
        return "admin/allMeeting";
    }



}
