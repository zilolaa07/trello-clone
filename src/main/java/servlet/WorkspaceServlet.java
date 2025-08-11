package servlet;

import dto.WorkspaceCreateDTO;
import dto.WorkspaceDTO;
import dto.WorkspaceUpdateDto;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.WorkspaceService;

import java.io.IOException;
import java.util.List;
@WebServlet("")
public class WorkspaceServlet extends HttpServlet {
    @Inject
    private WorkspaceService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");


        if (action == null && req.getHttpServletMapping().getMatchValue() != null) {
            infoPage(req, resp);
        } else if ("add".equals(action)) {
            addPage(req, resp);
        } else if ("update".equals(action)) {
            updatePage(req, resp);
        } else {
            listPage(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("add".equals(action)) {
            addWorkspace(req, resp);
        } else if ("update".equals(action)) {
            updateWorkspace(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action: " + action);
        }
    }

    private void infoPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getHttpServletMapping().getMatchValue();
        WorkspaceDTO workspace = service.get(id);
        req.setAttribute("workspace", workspace);
        req.getRequestDispatcher("/workspace/info.jsp").forward(req, resp);
    }

    private void listPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<WorkspaceDTO> workspaces = service.getAll();
        req.setAttribute("workspaces", workspaces);
        req.getRequestDispatcher("/workspace/list.jsp").forward(req, resp);
    }

    private void addPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/workspace/add.jsp").forward(req, resp);
    }

    private void updatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        WorkspaceDTO workspace = service.get(id);
        req.setAttribute("workspace", workspace);
        req.getRequestDispatcher("/workspace/update.jsp").forward(req, resp);
    }


//----------------------------------------------------------------------------------------------------------------//

    private void addWorkspace(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");

        WorkspaceCreateDTO workspace = new WorkspaceCreateDTO();
        workspace.setName(name);

        service.create(workspace);
        resp.sendRedirect("workspace");
    }

    private void updateWorkspace(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");

        WorkspaceUpdateDto workspace = new WorkspaceUpdateDto();
        workspace.setId(id);
        workspace.setName(name);

        service.update(workspace,id);  // Service orqali yangilash
        resp.sendRedirect("workspace");  // List sahifaga qaytish
    }


}
