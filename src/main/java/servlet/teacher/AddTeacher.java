package servlet.teacher;

import model.service.ChildService;
import model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTeacher")
public class AddTeacher extends HttpServlet {

    private static final String child = "/WEB-INF/view/teacher/addTeacher.jsp";
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(child).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String sex = req.getParameter("sex");
        teacherService.insert(new String[]{firstName, lastName, sex});

        resp.sendRedirect(req.getContextPath() + "/teachers");
    }
}