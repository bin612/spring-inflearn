package com.example.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
* 1. 파라미터 전송 기능
* 2. http://localhost:8080/request-param?username=hello&age=20
* */

@WebServlet(name="requestParameterServlet" , urlPatterns = "/request-param")
public class requestParameterServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회 - start]");

        //모든 요청 파라미터를 꺼내 올 수 있다.
        //전체 데이터 조회
        request.getParameterNames().asIterator()
            .forEachRemaining(paramName-> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        //단일 파라미터 조회
        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        // 같은 파라이터 네임을 사용하는 경우
        System.out.println("[이름이 같은 복수 파라미터 조회]");
        // getParameterValues() : String 배열로 결과값을 리턴
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }
        response.getWriter().write("ok");
    }
}
