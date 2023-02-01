<%--JSP 용 주석--%>
<!-- HTML 용 주석 -->

<%-- 지시자--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- page 지시자--%>
<%! //선언부(declaration)

    //자바의 주석
    public int add(int a, int b) {
        int c = a + b;
        return c;
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<% //Scriptlet 영역(자바 코드를 작성하는 영영)
    int num1 = 100;
    int num2 = 200;
    int res = add(num1, num2);
%>

<p><%=num1%>과 <%=num2%> 합은 <%=res%>입니다.</p>
<p><%=num1%>에서 <%=num2%>를 빼면 <%=num1 - num2%>입니다.</p>
<p><%=add(15, 20)%>
</p>
<%
    for (int i = 0; i < 5; i++) {
%>
<p><%=i%>번째 문장</p>
<%
    }
%>

<hr>
<%--include 지시자 사용. file 속성을 사용해서 가져올 페이지를 가져옴--%>
<%--srpring boot 환경에서는 컨트롤러를 거쳐서 와야하지만, 학습 목적상 include사용--%>
<%@include file="jspbasic.jsp" %>
<%--include로 불려오는 jspbasic.jsp에는 <html>태그나 <head>등을 지워도 이상없이 불려온다. 필요한 태그만 작성해도 상관 없음--%>


</body>
</html>
