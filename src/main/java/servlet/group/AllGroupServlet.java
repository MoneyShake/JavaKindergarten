package servlet.group;

import model.domain.Child;
import model.service.ChildService;
import model.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/groups")
public class AllGroupServlet extends HttpServlet {


    private static final String url = "/WEB-INF/view/group/allGroup.jsp";

    private final GroupService groupService = new GroupService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("groups", groupService.getAll());

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("groupId"));
        String groupName = req.getParameter("groupName");
        String minAge = req.getParameter("minAge");
        String maxAge = req.getParameter("maxAge");
        groupService.update(id, new String[]{groupName, minAge, maxAge});

        resp.sendRedirect(req.getContextPath() + "/groups");
    }
}
