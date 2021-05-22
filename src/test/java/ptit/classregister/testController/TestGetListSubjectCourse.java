package ptit.classregister.testController;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import ptit.common.JwtUtils;

//Test request tới url localhost:8080/dangky/dslhp/{id} lấy danh sách lớp học phần
// Nguyễn Tất Thắng
@SpringBootTest
@AutoConfigureMockMvc
public class TestGetListSubjectCourse {
    
    @Autowired
    private MockMvc mockMvc;

    //Test lấy danh sách lớp học phần thành công với id môn học là 1
    @Test
    public void testGetListSubjectCourseSuccessful() throws Exception{
        //Sử dụng token của user có ID là 1
        String token = JwtUtils.createToken(1,"thang", "123456", "thang123@gmail.com");
        assertNotNull(token);
        mockMvc.perform(MockMvcRequestBuilders.get("/dangky/dslhp/{id}", 1)
        .header("Authorization", "Bearer " + token))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(5)))
        .andExpect(jsonPath("$[0].id", is(1)));
    }

    //Test lấy danh sách lớp học phần không thành công với id môn học 100, không tồn tại trong hệ thống
    @Test
    public void testGetListSubjectCourseUnsuccessful() throws Exception{
        //Sử dụng token của user có ID là 1
        String token = JwtUtils.createToken(1,"thang", "123456", "thang123@gmail.com");
        assertNotNull(token);
        mockMvc.perform(MockMvcRequestBuilders.get("/dangky/dslhp/{id}",100)
        .header("Authorization", "Bearer " + token))
        .andExpect(status().isNotFound())
        .andExpect(content()
        .string(containsString("vui lÃ²ng chá»n mÃ´n há»c khÃ¡c")));
        //Không tìm thấy môn học nào
    }

    //Test lấy danh sách lớp học phần không thành công, người dùng chưa đăng nhập vào hệ thống
    @Test
    public void testGetListSubjectUnsuccessful() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/dangky/dslhp/{id}",1))
        .andExpect(status().isUnauthorized()).andExpect(content()
        .string(containsString("ChÆ°a ÄÄng nháº­p, vui lÃ²ng ÄÄng nháº­p trÆ°á»c khi thá»±c hiá»n ÄÄng kÃ½ mÃ´n há»c")));
        //Chưa đăng nhập, vui lòng đăng nhập trước khi thực hiện đăng ký môn học
    }

}
