package com.shoestp.common.Interceptor;

import java.io.IOException;

import javax.servlet.*;

/** 自定义过滤器(Filter) */
// @Component
public class TimeFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("time filter init");
  }

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    System.out.println("time filter start");
    long start = System.currentTimeMillis();

    filterChain.doFilter(servletRequest, servletResponse);
    System.out.println("time filter 耗时: " + (System.currentTimeMillis() - start) + " 毫秒");
    System.out.println("time filter finish");
  }

  @Override
  public void destroy() {
    System.out.println("time filter destroy");
  }
}
