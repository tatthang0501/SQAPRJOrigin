package ptit.classregister.testController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import ptit.dto.LoginForm;

//Test request đăng nhập 
//Nguyễn Tất Thắng

@SpringBootTest()
@AutoConfigureMockMvc
public class TestLogin {

    @Autowired(required = true)
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //Test trường hợp đăng nhập thành công, tài khoản và mật khẩu đúng
    @Test
    public void testLoginSuccessful() throws JsonProcessingException, Exception {
        LoginForm test = new LoginForm();
        test.setUsername("thang");
        test.setPassword("123456");
        mockMvc.perform(post("http://localhost:8080/login", 42L)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(test)))
        .andExpect(status().isOk()).andExpect(content().string(containsString("accessToken")));
        //Status trả về là 200: OK, 
    }

    //Test trường hợp đăng nhập không thành công, tài khoản đúng, mật khẩu sai
    @Test
    public void testLoginUnsuccessful1() throws JsonProcessingException, Exception{
        LoginForm test = new LoginForm();
        test.setUsername("thang");
        test.setPassword("1234567");
        // Mật khẩu đúng là 123456
        mockMvc.perform(post("http://localhost:8080/login", 42L)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(test)))
        .andExpect(status().isUnauthorized());
        //Status trả về là 401: Unauthorized
    }

    //Test trường hợp đăng nhập không thành công, tài khoản sai, mật khẩu đúng
    @Test
    public void testLoginUnsuccessful2() throws JsonProcessingException, Exception{
        LoginForm test = new LoginForm();
        test.setUsername("thangabc");
        //Tài khoản đúng là "thang"
        test.setPassword("123456");
        mockMvc.perform(post("http://localhost:8080/login", 42L)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(test)))
        .andExpect(status().isUnauthorized());
        //Status trả về là 401: Unauthorized
    }

    //Test trường hợp đăng nhập không thành công, tài khoản để trống, mật khẩu đúng
    @Test
    public void testLoginUnsuccessful3() throws JsonProcessingException, Exception{
        LoginForm test = new LoginForm();
        test.setUsername("");
        //Tài khoản đúng là "thang"
        test.setPassword("123456");
        mockMvc.perform(post("http://localhost:8080/login", 42L)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(test)))
        .andExpect(status().isUnauthorized());
        //Status trả về là 401: Unauthorized
    }

    //Test trường hợp đăng nhập không thành công, tài khoản đúng, mật khẩu để trống
    @Test
    public void testLoginUnsuccessful4() throws JsonProcessingException, Exception{
        LoginForm test = new LoginForm();
        test.setUsername("thang");
        test.setPassword("");
        //Mật khẩu đúng là 123456
        mockMvc.perform(post("http://localhost:8080/login", 42L)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(test)))
        .andExpect(status().isUnauthorized());
        //Status trả về là 401: Unauthorized
    }

    //Test trường hợp đăng nhập không thành công, để trống cả tài khoản và mật khẩu
    @Test
    public void testLoginUnsuccessful5() throws JsonProcessingException, Exception{
        LoginForm test = new LoginForm();
        test.setUsername("");
        // Tài khoản đúng là "thang"
        test.setPassword("");
        //Mật khẩu đúng là 123456
        mockMvc.perform(post("http://localhost:8080/login", 42L)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(test)))
        .andExpect(status().isUnauthorized());
        //Status trả về là 401: Unauthorized
    }
}
