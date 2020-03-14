package gushouchen.springmvc.helloword.web;

import gushouchen.springmvc.helloword.exception.NotSupportSearchException;
import gushouchen.springmvc.helloword.pojo.Tweet;
import gushouchen.springmvc.helloword.pojo.User;
import gushouchen.springmvc.helloword.util.Twitter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/3/12 17:41
 */
@Controller
@RequestMapping("hello")
public class HelloController {

  private Twitter twitter;

  @ResponseBody
  @RequestMapping("test1")
  String test1() {
    return "hello word";
  }

  @RequestMapping("test2")
  private ModelAndView test2() {
    LinkedList<Tweet> tweets = new LinkedList<>();
    tweets.add(new Tweet(new User("ceshi", "gushouchen1"), "ceshi1"));
    tweets.add(new Tweet(new User("ceshi", "gushouchen2"), "ceshi2"));
    tweets.add(new Tweet(new User("ceshi", "gushouchen3"), "ceshi3"));
    ModelAndView resultPage = new ModelAndView("resultPage");
    resultPage.addObject("tweets", tweets);
    resultPage.addObject("search", "SearchUrl");
    return resultPage;
  }

  @RequestMapping("/toSearchPage")
  private String test3() {
    return "searchPage";
  }

  /**
   * 能有一个搜索按钮就太棒啦
   */
  @RequestMapping("/result")
  private String test4(@RequestParam(defaultValue = "masterSpringMvc4") String search,
      Model model, RedirectAttributes redirectAttributes) {
    Twitter searchResults = null;
    try {
      searchResults = twitter.searchOperations().search(search);
    } catch (NotSupportSearchException e) {
      e.printStackTrace();
      redirectAttributes.addAttribute("search", search);
      redirectAttributes.addFlashAttribute("error",e.getMessage());
      return "redirect:/hello/toSearchPage";
    }
    List<Tweet> tweets = searchResults.getTweets();
    model.addAttribute("tweets", tweets);
    model.addAttribute("search", search);
    return "resultPage";
  }

  @RequestMapping(value = "/postSearch", method = RequestMethod.POST)
  public String postSearch(HttpServletRequest request,
      RedirectAttributes redirectAttributes) {
    String search = request.getParameter("search");
    redirectAttributes.addAttribute("search", search);
    return "redirect:result";
  }
}
