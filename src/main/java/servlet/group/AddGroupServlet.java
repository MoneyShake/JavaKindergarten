package servlet.child;

import model.service.ChildService;
import model.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addGroup")
public class AddGroupServlet extends HttpServlet {

    private static final String url = "/WEB-INF/view/group/addGroup.jsp";
    private final GroupService groupService = new GroupService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupName = req.getParameter("groupName");
        String minAge = req.getParameter("minAge");
        String maxAge = req.getParameter("maxAge");
        groupService.insert(new String[]{groupName, minAge, maxAge});

        resp.sendRedirect(req.getContextPath() + "/groups");
    }

}