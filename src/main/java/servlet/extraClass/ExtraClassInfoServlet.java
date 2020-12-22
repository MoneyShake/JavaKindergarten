package servlet.extraClass;

import model.domain.ExtraClass;
import model.service.ExtraClassService;
import model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/classes/info")
public class ExtraClassInfoServlet extends HttpServlet {

    private static final String url = "/WEB-INF/view/extraClass/info.jsp";
    private final ExtraClassService extraClassService = new ExtraClassService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String extraClassId = req.getParameter("extraClassId");
        ExtraClass currClass = extraClassService.getById(Long.parseLong(extraClassId));
        req.setAttribute("extraClassName", currClass.getName());
        req.setAttribute("extraClassId", extraClassId);
        req.setAttribute("children", extraClassService.getChildrenByExtraClassId(extraClassId));
        req.setAttribute("teachers", extraClassService.getTeachersByExtraClassId(extraClassId));

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
