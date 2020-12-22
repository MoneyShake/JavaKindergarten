package servlet.teacher;

import model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teachers/deleteFromGroup")
public class DeleteTeacherFromGroupServlet extends HttpServlet {
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = req.getParameter("teacherId");
        String groupId = req.getParameter("groupId");
        teacherService.deleteFromGroup(teacherId, groupId);
        resp.sendRedirect(req.getContextPath() + "/teachers");
    }
}
