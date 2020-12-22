package servlet.extraClass;

import model.service.ExtraClassService;
import model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/classes")
public class AllClassesServlet extends HttpServlet {

    private static final String url = "/WEB-INF/view/extraClass/allExtraClasses.jsp";
    private final ExtraClassService extraClassService = new ExtraClassService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("extraClasses", extraClassService.getAll());

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("extraClassId"));
        String extraClassName = req.getParameter("extraClassName");
        String description = req.getParameter("description");
        extraClassService.update(id, new String[]{extraClassName, description});

        resp.sendRedirect(req.getContextPath() + "/classes");

    }
}
