<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2018/5/6
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testget</title>
</head>
<body>
    <h3>get方式提交</h3>
    <form action="/servletdemo/getUser" method="get">
        username:<input type="text" name="username"/><br/>
        password:<input type="text" name="password"/><br/>
        <input type="submit" value="submit" >
    </form>

    <hr/>

    <h3>post方式提交</h3>
    <input action="/servletdemo/getUser" method="post">
        username:<input type="text" name="username"/><br/>
        password:<input type="text" name="password"/><br/>
        hobits:
            <input type="checkbox" name="hobits" value="1" >1</input>
            <input type="checkbox" name="hobits" value="2" >2</input>
            <input type="checkbox" name="hobits" value="3" >3</input>
        <input type="submit" value="submit" >
    </form>
</body>
</html>
