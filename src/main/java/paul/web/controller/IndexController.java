package paul.web.controller;

import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
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
    @RequestMapping("/testRequestBody")
    public void setJson(@RequestBody Book book, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        book.setAuthor("徐凌峰");
        book.setName("小黄书");
        response.setContentType("text/html, charset=UTF-8");
        //将book对象转换成json输出到客户端
        response.getWriter().println(mapper.writeValueAsString(book));

    }
}
