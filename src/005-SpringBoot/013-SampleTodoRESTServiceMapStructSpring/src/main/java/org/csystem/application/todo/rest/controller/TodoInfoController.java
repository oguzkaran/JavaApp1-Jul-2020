package org.csystem.application.todo.rest.controller;

import org.csystem.application.todo.rest.dto.TodoInfoDTO;
import org.csystem.application.todo.rest.service.ITodoApplicationService;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/todos")
public class TodoInfoController {
    private final ITodoApplicationService m_todoApplicationService;

    public TodoInfoController(ITodoApplicationService todoApplicationService)
    {
        m_todoApplicationService = todoApplicationService;
    }

    @GetMapping("/count")
    public long countTodos()
    {
        return m_todoApplicationService.countTodos();
    }

    @GetMapping("/all")
    public Iterable<TodoInfoDTO> findAllTodos() // Veri çok fazlaysa bu şekilde almak doğru değildir. Sadece örnek olarak gösterilmiştir.
    {
        return m_todoApplicationService.findAllTodos();
    }

    @GetMapping("/ids")
    public TodoInfoDTO findById(@RequestParam("id") long id)
    {
        return m_todoApplicationService.findById(id).orElse(new TodoInfoDTO());
    }

    @GetMapping("/idsres")
    public ResponseEntity<TodoInfoDTO> findByIdResponseEntity(@RequestParam("id") long id)
    {
        return ResponseEntity.of(m_todoApplicationService.findById(id));
    }

    @GetMapping("/start/month")
    public Iterable<TodoInfoDTO> findByMonth(int month)
    {
        return m_todoApplicationService.findTodosByMonth(month);
    }

    @GetMapping("/start/months")
    public Iterable<TodoInfoDTO> findByMonthsBetween(
            @RequestParam(value = "start", required = false, defaultValue = "-1") int start,
            @RequestParam(value = "end", required = false, defaultValue = "-1") int end)
    {

        if (start <= 0 || start > 12)
            start = 1;

        if (end <= 0 || end > 12)
            end = 12;

        return m_todoApplicationService.findTodosByMonthsBetween(start, end);
    }

    @GetMapping("/starts/months")
    public Iterable<TodoInfoDTO> findByMonthsBetweenString(
            @RequestParam(value = "start", required = false, defaultValue = "-1") String startStr,
            @RequestParam(value = "end", required = false, defaultValue = "-1") String endStr)
    {
        try {
            var start = Integer.parseInt(startStr);
            var end = Integer.parseInt(endStr);

            if (start <= 0 || start > 12)
                start = 1;

            if (end <= 0 || end > 12)
                end = 12;

            return m_todoApplicationService.findTodosByMonthsBetween(start, end);
        }
        catch (NumberFormatException|DataServiceException ignore) {
            return new ArrayList<>();
        }
    }

    @GetMapping("/starts/monthsres")
    public ResponseEntity<Iterable<TodoInfoDTO>> findByMonthsBetweenResponseEntity(
            @RequestParam(value = "start", required = false, defaultValue = "-1") String startStr,
            @RequestParam(value = "end", required = false, defaultValue = "-1") String endStr)
    {
        try {
            var start = Integer.parseInt(startStr);
            var end = Integer.parseInt(endStr);

            if (start <= 0 || start > 12)
                start = 1;

            if (end <= 0 || end > 12)
                end = 12;

            return ResponseEntity.ok(m_todoApplicationService.findTodosByMonthsBetween(start, end));
        }
        catch (NumberFormatException|DataServiceException ignore) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/starts")
    public Iterable<TodoInfoDTO> findByMonthString(@RequestParam(value = "mon", required = false, defaultValue = "1") String month)
    {
        try {
            return m_todoApplicationService.findTodosByMonth(Integer.parseInt(month));
        }
        catch (NumberFormatException|DataServiceException ignore) {
            return new ArrayList<>();
        }
    }

    @GetMapping("/startsres")
    public ResponseEntity<Iterable<TodoInfoDTO>> findByMonthStringResponseEntity(@RequestParam(value = "mon", required = false, defaultValue = "1") String month)
    {
        try {
            return new ResponseEntity<>(m_todoApplicationService.findTodosByMonth(Integer.parseInt(month)), HttpStatus.OK);
        }
        catch (NumberFormatException|DataServiceException ignore) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public TodoInfoDTO saveTodoInfoDTO(@RequestBody TodoInfoDTO todoInfoDTO)
    {
        return m_todoApplicationService.saveTodo(todoInfoDTO);
    }
}
