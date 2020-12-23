<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html"; charset="UTF-8" http-equiv="Content-Type">
    <title>글 등록</title>
</head>
<body>
    <center>
        <h3>글 등록하기</h3>
        <hr/>
        <form action="/insertBoard" method="post">
            <table border="1" cellpadding="0" cellspacing="0">
                <tr>
                    <td bgcolor="orange" width="70">제목</td><td align="left">
                    <input type="text" name="title">
                </td>
                </tr>
                <tr>
                    <td bgcolor="orange" width="70">작성자</td><td align="left">
                    <input type="text" name="writer">
                </td>
                </tr>
                <tr>
                    <td bgcolor="orange" width="70">내용</td><td align="left">
                    <textarea rows="10" cols="40" name="content"></textarea>
                </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="새글 등록">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
