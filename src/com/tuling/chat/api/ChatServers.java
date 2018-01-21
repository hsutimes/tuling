package com.tuling.chat.api;

import com.tuling.chat.test.Chat;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChatServers")
public class ChatServers extends HttpServlet {
    private PrintWriter out;
    private JSONObject json;
    private Chat chat;

    @Override
    public void init() {
        chat = new Chat();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/json");
        json = new JSONObject();
        if (text == null) {
            json.put("code", 1);
            json.put("msg", "参数为空");
        } else {
            json.put("code", 0);
            json.put("data", chat.getReplay(text));
        }
        out = response.getWriter();
        out.print(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
