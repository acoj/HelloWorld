package com.example.server;

public class LoginServlet implements Servlet{
    @Override
    public void service(Request request, Response response) {
        System.out.println("login servlet");
        response.print("<html>").print("<head>").print("<title>").print("以字符流操作字节流").print("</title>").print("</head>");
        response.print("<body>").print("反序列化和序列化" + request.getParameterValue("用户名")).print("</body>").print("</html>");
    }
}
