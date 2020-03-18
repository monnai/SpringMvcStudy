package gushouchen.springmvc.helloword.pojo;

import gushouchen.springmvc.helloword.annotation.PastLocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/3/15 16:29
 */
public class ProfileForm {

  @Size(min = 2)
  private String twitterHandle;
  @Email
  @NotEmpty
  private String email;
  @NotNull
  @PastLocalDate
  private LocalDate birthDate;
//  @NotEmpty
  private List<String> tastes = new ArrayList<>();

  public String getTwitterHandle() {
    return twitterHandle;
  }

  public void setTwitterHandle(String twitterHandle) {
    this.twitterHandle = twitterHandle;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public List<String> getTastes() {
    return tastes;
  }

  public void setTastes(List<String> tastes) {
    this.tastes = tastes;
  }
}
