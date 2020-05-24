package IPMJasperGoris.IPMJasperGoris.service;

import IPMJasperGoris.IPMJasperGoris.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getTasks();

    void addTask(TaskDto task);
}
