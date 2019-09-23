package com.shoestp.common.config;

import com.shoestp.common.Interceptor.TimeInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/** 第三方拦截器的配置 */
// @Configuration
public class WebConfig extends WebMvcConfigurationSupport {

  @Autowired private TimeInterceptor timeInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(timeInterceptor);
  }

  //    @Bean
  //    public FilterRegistrationBean ThirdPartyFilter() {
  //        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
  //
  //        ThirdPartyFilter thirdPartyFilter = new ThirdPartyFilter();
  //        registrationBean.setFilter(thirdPartyFilter);
  //
  //        List<String> urls = new ArrayList<>();
  //        urls.add("/*");
  //        registrationBean.setUrlPatterns(urls);
  //
  //        return registrationBean;
  //    }
}
