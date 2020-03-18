package gushouchen.springmvc.helloword.web;

import gushouchen.springmvc.helloword.formatter.USLocalDateFormatter;
import gushouchen.springmvc.helloword.pojo.ProfileForm;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/3/15 16:26
 */
@Controller
public class ProfileController {

  //dateFormat
  @ModelAttribute("dateFormat")
  private String localeFormat(Locale locale) {
    return USLocalDateFormatter.getPattern(locale);
  }

  @RequestMapping("/profile")
  public String displayProfile(ProfileForm profileForm) {
    return "profile/profilePage";
  }

  @RequestMapping(value = "/profile", params = {"save"}, method = RequestMethod.POST)
  public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "profile/profilePage";
    }
    System.out.println("save ok" + profileForm);
    return "redirect:/profile";
  }

  /**
   * 增加口味
   */
  @RequestMapping(value = "/profile", params = "addTaste")
  private String addRow(ProfileForm profileForm) {
    profileForm.getTastes().add(null);
    return "profile/profilePage";
  }

  /**
   * 删除口味
   */
  @RequestMapping(value = "/profile", params = "removeTaste")
  public String removeRow(ProfileForm profileForm, HttpServletRequest request) {
    Integer rowId = Integer.valueOf(request.getParameter("removeTaste"));
    profileForm.getTastes().remove(rowId.intValue());
    return "profile/profilePage";
  }


}
