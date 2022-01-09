package com.example.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 기본적으로 서블릿은 HttpServlet을 상속 받아야 한다.
@WebServlet(name="helloServlet", urlPatterns="/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 서블릿이 호출되면 서비스 메소드가 호출이 된다.
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request); // 요청에 대한 값
        System.out.println("response = " + response); // 응답에 대한 값

        String username = request.getParameter("username");
        System.out.println("username = " + username); // 파라미터 쿼리

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); //인코딩 타입 설정 요즘은 UTF-8 사용한다.
        response.getWriter().write("hello" + username); // 응답 요청을 하여 화면에 username 일는 파라미터를 전달


    }
}
