package gushouchen.springmvc.helloword.pojo;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/3/14 09:53
 */
public class User {

  private String profileImageUrl;

  public User(String profileImageUrl, String name) {
    this.profileImageUrl = profileImageUrl;
    this.name = name;
  }

  private String name;

  public String getProfileImageUrl() {
    return profileImageUrl;
  }

  public void setProfileImageUrl(String profileImageUrl) {
    this.profileImageUrl = profileImageUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
