package servlet.teacher;

import model.domain.Teacher;
import model.service.ChildService;
import model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teachers/deleteFromExtraClass")
public class DeleteTeacherFromExtraClassServlet extends HttpServlet {
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = req.getParameter("teacherId");
        String extraClassId = req.getParameter("extraClassId");
        teacherService.deleteFromExtraClass(teacherId, extraClassId);
        resp.sendRedirect(req.getContextPath() + "/classes/info?extraClassId=" + extraClassId);
    }
}
