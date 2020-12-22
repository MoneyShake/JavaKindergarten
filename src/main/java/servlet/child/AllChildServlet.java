package servlet.child;

import model.service.ChildService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/children")
public class AllChildServlet extends HttpServlet {

    private static final String url = "/WEB-INF/view/child/allChild.jsp";
    private final ChildService childService = new ChildService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("children", childService.getAll());

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override //метод для возможности изменять параметры ребенка
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("childId"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String sex = req.getParameter("sex");
        String groupId = req.getParameter("groupId");
        String age = req.getParameter("age");
        childService.update(id, new String[]{firstName, lastName, sex, groupId, age});

        String redirect = req.getParameter("redirect");


        if (redirect == null) {
            resp.sendRedirect(req.getContextPath() + "/children");
        } else {
            resp.sendRedirect(req.getContextPath() + "/group/children?groupId=" + groupId);
        }
    }
}
