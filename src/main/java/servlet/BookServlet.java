
package servlet;

import Model.Book;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
@WebServlet(urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("add")) {
            add(req, resp);
        }
        if (action.equals("query")) {
            query(req, resp);
        }
        if (action.equals("search")) {
            search(req, resp);
        }
        if (action.equals("update")) {
            update(req, resp);
        }
        if (action.equals("remove")) {
            remove(req, resp);
        }

    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookTitle = req.getParameter("bookTitle");
        String author = req.getParameter("author");
        String publishing = req.getParameter("publishing");
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("book.add", new Book(null, bookTitle, author, publishing));
        }
        resp.sendRedirect("/book?action=query");

    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            req.getSession().setAttribute("books", sqlSession.selectList("book.query"));
        }
        resp.sendRedirect("home.jsp");
    }


    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            req.getSession().setAttribute("book", sqlSession.selectOne("book.search", id));
        }
        resp.sendRedirect("edit.jsp");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.valueOf(req.getParameter("id"));
        String bookTitle = req.getParameter("bookTitle");
        String author = req.getParameter("author");
        String publishing = req.getParameter("publishing");
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.update("book.update", new Book(id, bookTitle, author, publishing));
        }

        try {
            resp.sendRedirect("/book?action=query");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void remove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.delete("book.remove", id);
        }
        resp.sendRedirect("/book?action=query");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}