package servlet.teacher;

import model.domain.ExtraClass;
import model.domain.Teacher;
import model.service.ExtraClassService;
import model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teachers/info")
public class TeacherInfoServlet extends HttpServlet {

    private static final String url = "/WEB-INF/view/teacher/teacherInfo.jsp";
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = req.getParameter("teacherId");
        Teacher currTeacher = teacherService.getById(Long.parseLong(teacherId));
        req.setAttribute("teacher", currTeacher);
        req.setAttribute("groups", teacherService.getTeacherGroupsByTeacherId(teacherId));

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
