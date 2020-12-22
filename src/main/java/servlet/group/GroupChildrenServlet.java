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


@WebServlet("/group/children")
public class GroupChildrenServlet extends HttpServlet {


    private static final String url = "/WEB-INF/view/group/childrenInGroup.jsp";

    private final GroupService groupService = new GroupService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("children", groupService.getChildrenByGroupId(Long.parseLong(req.getParameter("groupId"))));
        req.setAttribute("groupId", Long.parseLong(req.getParameter("groupId")));

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
