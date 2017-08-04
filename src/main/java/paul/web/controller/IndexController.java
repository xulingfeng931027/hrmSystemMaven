package paul.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import paul.domain.Book;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by paul on 2017-08-02.
 */
@Controller
@RequestMapping("/json")
public class IndexController {
     //@RequestBody根据json数据,转换成对应的Object
    @RequestMapping("/test")
    public void setJson( @RequestBody Book book, HttpServletResponse response) throws IOException {
        book.setAuthor("Paul");
        response.setContentType("text/html,charset=UTF-8");
        //将book对象转换成json输出到客户端
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(book));
        System.out.println(objectMapper.writeValueAsString(book));


    }

}
