package servlet.extraClass;

import model.domain.ExtraClass;
import model.domain.Teacher;
import model.service.ChildService;
import model.service.ExtraClassService;
import model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteExtraClass")
public class DeleteExtraClassServlet extends HttpServlet {
    private final ExtraClassService extraClassService = new ExtraClassService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long extraClassId = Long.parseLong(req.getParameter("extraClassId"));
        extraClassService.delete(extraClassId);
        resp.sendRedirect(req.getContextPath() + "/classes");
    }
}
