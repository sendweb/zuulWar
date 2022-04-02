package abc.xhb.zuulwar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {
    @Autowired
    private Person person;

    @ResponseBody
    @RequestMapping("/hello")
    public Person hello() {
        return person;
    }

    //@ResponseBody
    @RequestMapping("/test")
    public void sayHello(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getQueryString());
        response.setHeader("refresh","5;url=https://www.baidu.com");

    }
}
