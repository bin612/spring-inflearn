package com.example.servlet.web.servlet;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MemberSaveServlet.service");

        //Form 데이터 받는다.
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        //비즈니스 로직 들어가는 부분
        //데이터 세이브
        Member member = new Member(username, age);
        System.out.println("member = " + member);
        memberRepository.save(member);

        //응답 데이터 세팅 (동적)
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter w = response.getWriter();

        w.write("<html>\n"+
                   "<head>\n"+
                   "<meta charset=\"UTF-8\">\n"+
                   "</head>\n"+
                   "<body>\n"+
                   "성공\n"+
                   "<ul>\n"+
                   "<li>id="+member.getId()+"</li>\n"+
                   "<li>username"+member.getUsername()+"</li>\n"+
                   "<li>age="+member.getAge()+"</li>\n"+
                   "</ul>\n"+
                   "<a href = \"/index.html\">메인</a>\n"+
                   "</body>\n"+
                   "</html>"
        );

    }
}
