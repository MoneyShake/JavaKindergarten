package servlet.child;

import model.service.ChildService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addChild")
public class AddChildServlet   extends HttpServlet {

    private static final String child = "/WEB-INF/view/child/addChild.jsp";
    private final ChildService childService = new ChildService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(child).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String sex = req.getParameter("sex");
        String groupId = req.getParameter("groupId");
        String age = req.getParameter("age");
        childService.insert(new String[]{firstName, lastName, sex, groupId, age});

        resp.sendRedirect(req.getContextPath() + "/children");
    }
}