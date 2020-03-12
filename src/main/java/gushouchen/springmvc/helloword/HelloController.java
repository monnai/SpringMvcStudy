package gushouchen.springmvc.helloword;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/3/12 17:41
 */
@RestController
@RequestMapping("hello")
public class HelloController {

  @RequestMapping("test1")
  String test1() {
    return "hello word";
  }
}
