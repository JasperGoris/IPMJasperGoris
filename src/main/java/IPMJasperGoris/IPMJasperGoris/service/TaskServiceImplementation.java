package IPMJasperGoris.IPMJasperGoris.service;

import IPMJasperGoris.IPMJasperGoris.domain.SubTask;
import IPMJasperGoris.IPMJasperGoris.domain.Task;
import IPMJasperGoris.IPMJasperGoris.dto.TaskDto;
import IPMJasperGoris.IPMJasperGoris.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImplementation implements TaskService{
    private final TaskRepo repo;

    @Autowired
    public TaskServiceImplementation(TaskRepo repo) {
        this.repo = repo;
    }


    @Override
    public List<TaskDto> getTasks() {
        return repo.findAll().stream().map(h -> {
            TaskDto dto = new TaskDto();
            dto.setSubTasks(h.getSubTasks());
            dto.setTijdstip(h.getTijdstip());
            dto.setDatum(h.getDatum());
            dto.setDescription(h.getDescription());
            dto.setName(h.getName());
            dto.setId(h.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public void addTask(TaskDto DtoTask){
        Task task = new Task();
        task.setDatum(DtoTask.getDatum());
        task.setDescription(DtoTask.getDescription());
        task.setName(DtoTask.getName());
        task.setSubTasks(DtoTask.getSubTasks());
        task.setTijdstip(DtoTask.getTijdstip());

        repo.save(task);
    }

    public void editTask(Task task){
        Task d = getTask(task.getId());
        d.setTijdstip(task.getTijdstip());
        d.setName(task.getName());
        d.setDescription(task.getDescription());
        d.setDatum(task.getDatum());
        d.setId(task.getId());
        d.setSubTasks(task.getSubTasks());
        repo.flush();
    }

    public Task getTask(Long id){
        return repo.getOne(id);
    }

    public List<Task> getTaken(){  return repo.findAll(); }

    public void addSubTask(SubTask subTask){
        Task e = getTask(subTask.getCorrespondingTask());
        e.addSubTask(subTask);
        repo.save(e);
    }
}
