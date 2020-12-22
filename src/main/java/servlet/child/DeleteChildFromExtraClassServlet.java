package servlet.child;

import model.domain.Teacher;
import model.service.ChildService;
import model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/children/deleteFromExtraClass")
public class DeleteChildFromExtraClassServlet extends HttpServlet {
    private final ChildService childService = new ChildService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String childId = req.getParameter("childId");
        String extraClassId = req.getParameter("extraClassId");
        childService.deleteFromExtraClass(childId, extraClassId);
        resp.sendRedirect(req.getContextPath() + "/classes/info?extraClassId=" + extraClassId);
    }
}
