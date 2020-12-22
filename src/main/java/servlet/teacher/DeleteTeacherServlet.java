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

@WebServlet("/deleteTeacher")
public class DeleteTeacherServlet extends HttpServlet {
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long teacherId = Long.parseLong(req.getParameter("teacherId"));
        teacherService.delete(teacherId);
        resp.sendRedirect(req.getContextPath() + "/teachers");
    }
}
