package servlet.group;

import model.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteGroup")
public class DeleteGroupServlet extends HttpServlet {
    private final GroupService groupService = new GroupService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long groupId = Long.parseLong(req.getParameter("groupId"));
        groupService.delete(groupId);
        resp.sendRedirect(req.getContextPath() + "/groups");
    }
}
