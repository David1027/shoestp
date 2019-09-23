package com.shoestp.common.Interceptor;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/** 第三方过滤器(Filter) */
public class ThirdPartyFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("third party filter init");
  }

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    System.out.println("third party filter start");
    long start = System.currentTimeMillis();
    filterChain.doFilter(servletRequest, servletResponse);
    System.out.println("third party filter 耗时: " + (System.currentTimeMillis() - start) + " 毫秒");
    System.out.println("third party filter finish");
  }

  @Override
  public void destroy() {
    System.out.println("third party filter destroy");
  }
}
