package servlet.child;

import model.service.ChildService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteChild")
public class DeleteChildServlet  extends HttpServlet {
    private final ChildService childService = new ChildService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long childId = Long.parseLong(req.getParameter("childId"));
        String groupId = req.getParameter("groupId");
        childService.delete(childId);
        if (groupId == null) {
            resp.sendRedirect(req.getContextPath() + "/children");
        } else {
            resp.sendRedirect(req.getContextPath() + "/group/children?groupId=" + groupId);
        }
    }
}
