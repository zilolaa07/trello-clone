package uz.pdp.dto.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import uz.pdp.dto.TaskCreateDto;
import uz.pdp.dto.TaskUpdateDto;
import uz.pdp.dto.service.TaskService;

import java.io.IOException;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    @Inject
    TaskService taskService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {

            req.setAttribute("tasks", taskService.getAll());
            req.getRequestDispatcher("/task-list.jsp").forward(req, resp);
        }
        else if (action.equals("edit")) {

            Long id = Long.valueOf(req.getParameter("id"));
            taskService.getById(id).ifPresent(taskDto -> req.setAttribute("task", taskDto));
            req.getRequestDispatcher("/task-form.jsp").forward(req, resp);
        }
        else if (action.equals("delete")) {

            Long id = Long.valueOf(req.getParameter("id"));
            taskService.delete(id);
            resp.sendRedirect("/tasks");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");

        if (action != null && action.equals("update")) {

            Long id = Long.valueOf(req.getParameter("id"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            Integer sortOrder = Integer.valueOf(req.getParameter("sortOrder"));
            String workspaceId = String.valueOf(Long.valueOf(req.getParameter("workspaceId")));


            TaskUpdateDto dto = new TaskUpdateDto(id, name, description, sortOrder, workspaceId);
            taskService.update(dto);
        }
        else {

            String name = req.getParameter("name");
            String description = req.getParameter("description");
            Integer sortOrder = Integer.valueOf(req.getParameter("sortOrder"));
            String workspaceId = String.valueOf(Long.valueOf(req.getParameter("workspaceId")));

            TaskCreateDto dto = new TaskCreateDto(name, description, sortOrder, workspaceId);
            taskService.create(dto);
        }

        resp.sendRedirect("/tasks");
    }
}

