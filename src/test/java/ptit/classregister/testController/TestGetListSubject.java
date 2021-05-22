package ptit.classregister.testController;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import ptit.common.JwtUtils;


//Test request tới url localhost:8080/dangky lấy danh sách môn học
// Nguyễn Tất Thắng
@SpringBootTest
@AutoConfigureMockMvc
public class TestGetListSubject {
    
    @Autowired(required = true)
    private MockMvc mockMvc;
    //Test get danh sách môn học thành công, sử dụng token mặc định với tài khoản có id là 1
    @Test
    public void testGetListSubjectSuccessful() throws Exception {
        //Sử dụng token của user có ID là 1
        String token = JwtUtils.createToken(1,"thang", "123456", "thang123@gmail.com");
        assertNotNull(token);
        mockMvc.perform(MockMvcRequestBuilders.get("/dangky")
        .header("Authorization", "Bearer " + token))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(8)))
        .andExpect(jsonPath("$[0].ten", is("Nhập môn công nghệ phần mềm")))
        .andExpect(jsonPath("$[0].soTC", is(3)));
    }

    //Test get danh sách môn học không thành công, người dùng chưa đăng nhập và không có token
    @Test
    public void testGetListSubjectUnsuccessful() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/dangky"))
        .andExpect(status().isUnauthorized()).andExpect(content()
        .string(containsString("ChÆ°a ÄÄng nháº­p, vui lÃ²ng ÄÄng nháº­p trÆ°á»c khi thá»±c hiá»n ÄÄng kÃ½ mÃ´n há»c")));
        //Chưa đăng nhập, vui lòng đăng nhập trước khi thực hiện đăng ký môn học
    }
}
