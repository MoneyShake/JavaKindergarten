package servlet.extraClass;

import model.service.ExtraClassService;
import model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addExtraClass")
public class AddExtraClassServlet extends HttpServlet {

    private static final String child = "/WEB-INF/view/extraClass/addExtraClass.jsp";
    private final ExtraClassService extraClassService = new ExtraClassService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(child).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String extraClassName = req.getParameter("extraClassName");
        String description = req.getParameter("description");
        extraClassService.insert(new String[]{extraClassName, description});

        resp.sendRedirect(req.getContextPath() + "/classes");
    }
}
