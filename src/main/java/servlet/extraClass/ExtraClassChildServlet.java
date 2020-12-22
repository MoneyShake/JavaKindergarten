package servlet.extraClass;

import model.domain.Child;
import model.service.ChildService;
import model.service.ExtraClassService;
import model.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/classes/addTeacher")
public class ExtraClassChildServlet extends HttpServlet {

    private final ExtraClassService extraClassService = new ExtraClassService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = req.getParameter("teacherId");
        String classId = req.getParameter("classId");

        extraClassService.addTeacherToExtraClass(teacherId, classId);

        resp.sendRedirect(req.getContextPath() + "/classes");
    }
}
