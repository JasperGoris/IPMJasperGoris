package IPMJasperGoris.IPMJasperGoris;

import IPMJasperGoris.IPMJasperGoris.domain.Task;
import IPMJasperGoris.IPMJasperGoris.dto.TaskDto;
import IPMJasperGoris.IPMJasperGoris.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;

    @Test
    public void testGetTasks(){
        TaskDto taskDto = new TaskDto();
        taskDto.setName("Bibliotheek");
        taskDto.setDescription("Boeken binnen brengen");
        taskDto.setDatum("28/03/2020");
        taskDto.setTijdstip("18:00");
        taskService.addTask(taskDto);

        List<Task> tasks = taskService.getTaken();

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1, tasks.size());
        Task task = tasks.get(0);
        assertNotNull(task);
    }
}
