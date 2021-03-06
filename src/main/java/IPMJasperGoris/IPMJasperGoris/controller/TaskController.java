package IPMJasperGoris.IPMJasperGoris.controller;

import IPMJasperGoris.IPMJasperGoris.domain.SubTask;
import IPMJasperGoris.IPMJasperGoris.domain.Task;

import IPMJasperGoris.IPMJasperGoris.dto.TaskDto;
import IPMJasperGoris.IPMJasperGoris.service.TaskServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServiceImplementation service;

    @Autowired
    public TaskController(TaskServiceImplementation service) {
        this.service = service;
    }

    @GetMapping()
    public String getTasks(Model model){
        model.addAttribute("tasks", service.getTaken());
        return "tasks";
    }

    @GetMapping("/{id}")
    public String getDetails(@PathVariable("id") long id, Model model){
        model.addAttribute("id", service.getTask(id));
        return "details";
    }

    @GetMapping("/edit/{id}")
    public String getEdit(@PathVariable("id") Long id, Model model){
        model.addAttribute("task", service.getTask(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable("id") Long id, @ModelAttribute @Valid Task task){
        service.editTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/sub/create")
    public ModelAndView getCreateSub(@PathVariable(name = "id") long id){
        ModelAndView w = new ModelAndView("subtask");
        w.addObject("task", service.getTask(id));
        return w;
    }

    @PostMapping("/{id}/sub/create")
    public String createsub(@ModelAttribute SubTask subTask){
        Long id = subTask.getCorrespondingTask();
        System.out.println(id);
        service.addSubTask(subTask);
        return "redirect:/tasks/"+id;
    }


    @GetMapping("/new")
    public String makenew(Model model){
        return "new";
    }

    @PostMapping("/new")
    public String addTask(@ModelAttribute TaskDto task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "new";
        }
        service.addTask(task);
        return "redirect:/tasks";
    }
}


