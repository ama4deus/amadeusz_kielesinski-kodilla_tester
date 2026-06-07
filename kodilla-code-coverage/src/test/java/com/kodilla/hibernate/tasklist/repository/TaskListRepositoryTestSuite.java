package com.kodilla.hibernate.tasklist.repository;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class TaskListRepositoryTestSuite {

    @Autowired
    private TaskListRepository taskListRepository;

    @Test
    void testFindByListName() {
        TaskList taskList = new TaskList("ToDo List", "Tasks to be done this week");
        taskListRepository.save(taskList);
        int id = taskList.getId();

        try {
            List<TaskList> readTaskLists = taskListRepository.findByListName("ToDo List");

            Assertions.assertEquals(1, readTaskLists.size());
            Assertions.assertEquals("ToDo List", readTaskLists.get(0).getListName());
            Assertions.assertEquals(
                    "Tasks to be done this week",
                    readTaskLists.get(0).getDescription()
            );
        } finally {
            taskListRepository.deleteById(id);
        }
    }

    @Test
    void testFindByListNameWhenNotExists() {
        List<TaskList> readTaskLists = taskListRepository.findByListName("Non Existent List");

        Assertions.assertTrue(readTaskLists.isEmpty());
        Assertions.assertEquals(0, readTaskLists.size());
    }
}