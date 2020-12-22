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

@WebServlet("/addTeacherToGroup")
public class AddTeacherToGroup extends HttpServlet {
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = req.getParameter("teacherId");
        String groupId = req.getParameter("groupId");

        teacherService.addTeacherToGroup(teacherId, groupId);

        resp.sendRedirect(req.getContextPath() + "/teachers");
    }
}
