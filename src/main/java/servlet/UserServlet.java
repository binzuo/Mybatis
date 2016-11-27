package servlet;

import Model.*;
import com.sun.deploy.nativesandbox.comm.Request;
import com.sun.net.httpserver.HttpServer;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;


import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.JAXRException;
import javax.xml.registry.LifeCycleManager;
import javax.xml.registry.infomodel.*;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
@WebServlet(urlPatterns = "/user")

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("register")) {
            register(req, resp);
        }
        if (action.equals("login")) {
            login(req, resp);
        }


    }

    private void register(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("user.create",new Model.User(null,username,password));
        }
        try {
            resp.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            List<Model.User> users=sqlSession.selectList("user.login",new Model.User(null,username,password));
            if (users.size()>0){

            }else {

            }
        }
        try {
            resp.sendRedirect("home.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}