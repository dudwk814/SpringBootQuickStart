<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html"; charset="UTF-8" http-equiv="Content-Type">
    <title>글 조회</title>
</head>
<body>
    <center>
        <h3>글 조회</h3>
        <hr/>
        <form action="/updateBoard" method="post">
            <input type="hidden" name="seq" value="${board.seq}">
            <table border="1" cellpadding="0" cellspacing="0">
                <tr>
                    <td bgcolor="orange" width="70">제목</td><td align="left">
                    <input type="text" name="title" value="${board.title}">
                </td>
                </tr>
                <tr>
                    <td bgcolor="orange" width="70">작성자</td><td align="left">
                    ${board.writer}
                </td>
                </tr>
                <tr>
                    <td bgcolor="orange" width="70">내용</td><td align="left">
                    <textarea rows="10" cols="40" name="content">${board.content}</textarea>
                </td>
                </tr>
                <tr>
                    <td bgcolor="orange">등록일</td>
                    <td align="left"><fmt:formatDate value="${board.createDate}" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <td bgcolor="orange">조회수</td>
                    <td align="left">${board.cnt}</td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="글 수정">
                    </td>
                </tr>
            </table>
        </form>
        <hr/>
        <a href="insertBoard">글등록</a>&nbsp;&nbsp;&nbsp;
        <a href="deleteBoard?seq=${board.seq}">글삭제</a>&nbsp;&nbsp;&nbsp;
        <a href="getBoardList">글목록</a>
    </center>
</body>
</html>
