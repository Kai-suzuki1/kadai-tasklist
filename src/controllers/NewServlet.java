package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;
import utils.DBUtil;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.creatEntityManager();
        em.getTransaction().begin();

        Tasks t = new Tasks();

        t.setContent("テスト");

        Timestamp curreTime = new Timestamp(System.currentTimeMillis());

        t.setCreated_at(curreTime);
        t.setUpdated_at(curreTime);

        em.persist(t);

        em.getTransaction().commit();

        response.getWriter().append(Integer.valueOf(t.getId()).toString());

        em.close();

    }

}
