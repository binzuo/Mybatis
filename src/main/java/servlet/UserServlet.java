package servlet;
//项目包>src>main>java>创建的servlet>用户注册登录类 UserServlet

import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            login(req,resp);
        }
        if (action.equals("logout")) {
            logout(req, resp);
        }


    }

    private void register(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("user.create",new Model.User(null,email,password));
        }
        try {
            resp.sendRedirect("index.jsp");
            req.getSession().setAttribute("congratulation","恭喜您注册成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            List<Model.User> users=sqlSession.selectList("user.login",new Model.User(null,email,password));
            if (users.size()>0){
                try {
                    resp.sendRedirect("/book?action=query");
                    req.getSession().setAttribute("email",email);
                    req.getSession().setAttribute("welcome","欢迎您:"+email);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    resp.sendRedirect("index.jsp");
                    req.getSession().setAttribute("warning","您输入的账号或密码不正确!");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getSession().invalidate();
            resp.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}