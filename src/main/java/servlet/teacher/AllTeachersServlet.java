package servlet.teacher;

import model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teachers")
public class AllTeachersServlet extends HttpServlet {

    private static final String url = "/WEB-INF/view/teacher/allTeachers.jsp";
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("teachers", teacherService.getAll());

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("teacherId"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String sex = req.getParameter("sex");
        teacherService.update(id, new String[]{firstName, lastName, sex});

        resp.sendRedirect(req.getContextPath() + "/teachers");

    }
}
