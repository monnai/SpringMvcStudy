package gushouchen.springmvc.helloword.util;

import gushouchen.springmvc.helloword.exception.NotSupportSearchException;
import gushouchen.springmvc.helloword.pojo.Tweet;
import gushouchen.springmvc.helloword.pojo.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/3/14 12:35
 */
public class Twitter {

  private List<Tweet> tweets;

  private Twitter() {
  }

  private static Twitter twitter = null;
  //模拟查询用
  private static Map<String, ArrayList<Tweet>> keyData;

  //初始化查询用数据，随机生成
  static {
    /*
      keyData里面需要9个list ，每个list里面需要递增个Tweet
     */
    keyData = new HashMap<String, ArrayList<Tweet>>();
    Random random = new Random();
    for (int i = 0; i < 9; i++) {
      ArrayList<Tweet> tweets = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        Tweet tweet = new Tweet(new User("profileImageUrl" + i + j, "gushouchen" + i + j),
            "to what??? this is " + random.nextInt());
        tweets.add(tweet);
      }
      keyData.put("key" + i, tweets);
    }
  }

  /**
   * 单例模式 返回一个实例对象
   */
  public static Twitter searchOperationsSingle() {
    if (twitter != null) {
      return twitter;
    } else {
      synchronized (Twitter.class) {
        if (twitter != null) {
          return twitter;
        } else {
          return new Twitter();
        }
      }
    }
  }

  public static Twitter searchOperations() {
    return new Twitter();
  }

  /**
   * 根据key 设置一下引用的tweets
   */
  public Twitter search(String key) throws NotSupportSearchException {
    ArrayList<Tweet> tweets = keyData.get(key);
    if (tweets == null) {
        throw new NotSupportSearchException("没有找到，请检查输入的key是否正确");
    }
    this.tweets = tweets;
    return this;
  }

  public List<Tweet> getTweets() {
    return this.tweets;
  }


}
