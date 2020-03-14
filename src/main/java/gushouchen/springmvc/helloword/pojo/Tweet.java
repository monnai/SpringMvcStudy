package gushouchen.springmvc.helloword.pojo;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/3/14 09:53
 */
public class Tweet {

  public Tweet(User user, String text) {
    this.user = user;
    this.text = text;
  }

  private User user;
  private String text;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
