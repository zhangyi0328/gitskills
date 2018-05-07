package com.zy;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

@WebServlet(name = "servlet1", urlPatterns={"/getUser","/userInfo"},loadOnStartup=1)
public class servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println( "请求实体信息post－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－" );
        InputStream in = request.getInputStream() ;
        byte[] buf = new byte[1024] ;
        int len = 0 ;
        while ( (len = in.read(buf)) != -1 ){
            System.out.println( new java.lang.String(buf, 0, len));
        }

        //多个值的获取
        java.lang.String[] hobits = request.getParameterValues("hobits") ;
        for (java.lang.String h: hobits ) {
            System.out.print(h + ", ");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println( "请求行信息－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－" );
        System.out.println( "请求方式: " + request.getMethod() );
        System.out.println( "请求协议: " + request.getProtocol() );
        System.out.println( "请求URL: " + request.getRequestURL() );
        System.out.println( "请求URI: " + request.getRequestURI() );

        System.out.println( "请求头信息－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－" );
        System.out.println( "host: " + request.getHeader("Host") );
        System.out.println( "所有请求头名称: " + request.getHeaderNames() );
//        Enumeration<String> enums = request.getHeaderNames() ;
//        while (enums.hasMoreElements()){
//            String e = enums.nextElement() ;
//            String b = request.getHeader(e) ;
//            System.out.println( "所有请求头名称: " + e + ":" + b );
//        }

        System.out.println( "请求实体信息get; get无实体，所以以下没有任何内容－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－" );
        InputStream in = request.getInputStream() ;
        byte[] buf = new byte[1024] ;
        int len = 0 ;
        while ( (len = in.read(buf)) != -1 ){
            System.out.println( new java.lang.String(buf, 0, len));
        }

        System.out.println("get提交获取url后面跟的参数－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        java.lang.String v = request.getQueryString() ;
        System.out.println(v);

        System.out.println("统一的获取方式,get post都可以－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println( request.getParameter("username") );
        System.out.println( request.getParameter("password") );

    }
}
