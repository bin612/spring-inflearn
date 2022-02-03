package com.example.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    // 먼저 호출
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //getRequestDispatcher : 컨트롤러에서 뷰로 이동할 때 사용
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //forward : servlet에서 jsp를 호출 할 수 있음
        dispatcher.forward(request, response);

    }
}
