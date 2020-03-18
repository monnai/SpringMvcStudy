package gushouchen.springmvc.helloword.configuation;

import gushouchen.springmvc.helloword.formatter.USLocalDateFormatter;
import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/3/17 15:47
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

  //增加日期自定义格式化
  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
  }

  @Bean
  public LocaleResolver localeResolver() {
    return new SessionLocaleResolver();
  }

  //拦截lang查询参数
  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    localeChangeInterceptor.setParamName("lang");
    return localeChangeInterceptor;
  }

  //增加拦截器
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }
}
