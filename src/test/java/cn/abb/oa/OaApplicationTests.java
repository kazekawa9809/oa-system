package cn.abb.oa;

import cn.abb.oa.mapper.DepartMapper;
import cn.abb.oa.mapper.MeetingDetailMapper;
import cn.abb.oa.mapper.PostMapper;
import cn.abb.oa.mapper.UserMapper;
import cn.abb.oa.pojo.Depart;
import cn.abb.oa.pojo.MeetingDetail;
import cn.abb.oa.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OaApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    DepartMapper departMapper;

    @Autowired
    PostMapper postMapper;

    @Autowired
    MeetingService meetingService;

    @Autowired
    MeetingDetailService meetingDetailService;

    @Autowired
    AnnounceService announceService;

    @Test
    public void testUserService() {
        System.out.println(userService.selectAllDto());
    }

    /*@Test
    public void testDepart(){
        Depart depart = new Depart();
        depart.setDepartId(3);
        depart.setDepartName("3n");
        depart.setDepartDescription("3333");
        depart.setDepartLocation("3333");
        depart.setDepartTel("3333");
        depart.setDepartManagerId(4);
        depart.setDepartUpperId(3);
        departMapper.addInfo(depart);
*//*
        System.out.println(departMapper.selectDepartById(1));
*//*
        depart.setDepartName("4n");
        departMapper.updateInfo(depart);
    }*/

    @Test
    public void testPost(){
        System.out.println(postService.selectPositionById(1));
    }

    /*@Test
    public void testMeetingDt(){
        System.out.println(meetingDetailMapper.selectAllMeetingDt());
    }*/

    @Test
    public void testMeeting(){
        System.out.println(meetingService.selectMeetingById(1));
    }

    @Test
    public void testDetail(){
        List<MeetingDetail> meetingDetails = meetingDetailService.selectAllMeetingDtByID(1);
        System.out.println(meetingDetails.get(0));
    }

    @Test
    public void testAnnounce(){
        System.out.println(announceService.selectAllAnnounce());
    }


}
