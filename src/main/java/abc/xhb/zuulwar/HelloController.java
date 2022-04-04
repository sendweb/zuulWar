package abc.xhb.zuulwar;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//@AllArgsConstructor

@RequiredArgsConstructor
public class HelloController {
    Logger logger = LoggerFactory.getLogger(getClass());
    private final Person person;

    @ResponseBody
    @RequestMapping("/hello")
    public Person hello() {
        logger.trace("trace 级别日志");
        logger.debug("debug 级别日志");
        logger.info("info 级别日志");
        logger.warn("warn 级别日志");
        logger.error("error 级别日志");
        return person;
    }

    @ResponseBody
    @PostMapping("getDog")
    public Dog getDog(@RequestBody Dog dog) {
        dog.setName("你的狗是：" + dog.getName());
        return dog;
    }


    //@ResponseBody
    @RequestMapping("/test")
    public void sayHello(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getQueryString());
        response.setHeader("refresh", "5;url=https://www.baidu.com");

    }
}
