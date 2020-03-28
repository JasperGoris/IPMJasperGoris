package IPMJasperGoris.IPMJasperGoris;

import IPMJasperGoris.IPMJasperGoris.domain.SubTask;
import IPMJasperGoris.IPMJasperGoris.domain.Task;
import IPMJasperGoris.IPMJasperGoris.dto.TaskDto;
import IPMJasperGoris.IPMJasperGoris.service.TaskService;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;


    @Test
    @Transactional
    public void hibernateShit(){
        TaskDto taskDto = new TaskDto();
        taskDto.setName("Bibliotheek");
        taskDto.setDescription("Boeken binnen brengen");
        taskDto.setDatum("28/03/2020");
        taskDto.setTijdstip("18:00");
        taskService.addTask(taskDto);

        List<Task> tasks = taskService.getTaken();
        Task task = tasks.get(0);

        assertEquals(taskService.getTask((long) 1), task);

    }
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

        assertEquals(task.getId(), 1);
        assertEquals(task.getDatum(), "28/03/2020");
        assertEquals(task.getTijdstip(), "18:00");
        assertEquals(task.getName(), "Bibliotheek");
        assertEquals(task.getDescription(), "Boeken binnen brengen");
    }
    @Test
    public void DtoTests(){
        TaskDto taskDto = new TaskDto();
        taskDto.setName("Bibliotheek");
        taskDto.setDescription("Boeken binnen brengen");
        taskDto.setDatum("28/03/2020");
        taskDto.setTijdstip("18:00");
        taskService.addTask(taskDto);

        List<Task> tasks = taskService.getTaken();
        Task task = tasks.get(0);
        assertEquals(taskDto.getDatum(), task.getDatum());
        assertEquals(taskDto.getDescription(), task.getDescription());
        assertEquals(taskDto.getName(), task.getName());
        assertEquals(taskDto.getTijdstip(), task.getTijdstip());

    }

    @Transactional
    @Test
    public void editTest(){
        TaskDto taskDto = new TaskDto();
        taskDto.setName("Bibliotheek");
        taskDto.setDescription("Boeken binnen brengen");
        taskDto.setDatum("28/03/2020");
        taskDto.setTijdstip("18:00");
        taskService.addTask(taskDto);

        TaskDto taskDto1 = taskDto;
        taskService.addTask(taskDto1);

        List<Task> tasks = taskService.getTaken();
        Task task = tasks.get(0);
        Task task2 = tasks.get(1);

        task.setDescription("Test");
        taskService.editTask(task);

        List<Task> taken = taskService.getTaken();
        Task task3 = taken.get(0);
        Task task4 = taken.get(1);
        assertNotEquals(task3, task4);
    }


    @Test
    public void checkSubTasks() {
        TaskDto taskDto = new TaskDto();
        taskDto.setName("Bibliotheek");
        taskDto.setDescription("Boeken binnen brengen");
        taskDto.setDatum("28/03/2020");
        taskDto.setTijdstip("18:00");
        taskService.addTask(taskDto);




        SubTask subTask = new SubTask();
        subTask.setCorrespondingTask((long) 1);
        subTask.setDatum("28/03/2020");
        subTask.setDescription("Boete eerst betalen");
        subTask.setName("Boete");
        subTask.setTijdstip("18:05");

        Task d = taskService.getTaken().get(0);
        d.addSubTask(subTask);

        SubTask Nul = null;
        assertThrows(IllegalArgumentException.class, () -> d.addSubTask(Nul));


        assertEquals(subTask.getCorrespondingTask(), 1);
        assertEquals(subTask.getDatum(), "28/03/2020");
        assertEquals(subTask.getTijdstip(), "18:05");
        assertEquals(subTask.getName(), "Boete");
        assertEquals(subTask.getDescription(), "Boete eerst betalen");

        List<SubTask> subtasks = d.getSubTasks();
        assertNotNull(subtasks);
        assertFalse(subtasks.isEmpty());
        assertEquals(1, subtasks.size());
        SubTask t = subtasks.get(0);
        assertNotNull(t);

    }
}
