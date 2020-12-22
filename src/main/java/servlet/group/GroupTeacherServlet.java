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


@WebServlet("/group/teachers")
public class GroupTeacherServlet extends HttpServlet {


    private static final String url = "/WEB-INF/view/group/teachersGroup.jsp";

    private final GroupService groupService = new GroupService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("teachers", groupService.getTeachersByGroupId(Long.parseLong(req.getParameter("groupId"))));
        req.setAttribute("groupId", Long.parseLong(req.getParameter("groupId")));

        req.getRequestDispatcher(url).forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        long id = Long.parseLong(req.getParameter("childId"));
//        String groupName = req.getParameter("groupName");
//        String minAge = req.getParameter("minAge");
//        String maxAge = req.getParameter("maxAge");
//        groupService.update(id, new String[]{groupName, minAge, maxAge});
//
//        resp.sendRedirect(req.getContextPath() + "/groups");
//    }
}
