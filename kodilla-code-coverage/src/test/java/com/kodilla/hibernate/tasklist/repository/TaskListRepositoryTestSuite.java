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
        //Given
        String listName = "ToDo List";
        String description = "Tasks to be done this week";
        TaskList taskList = new TaskList(listName, description);

        //When
        taskListRepository.save(taskList);

        //Then
        String nameToFind = taskList.getListName();
        List<TaskList> readTaskLists = taskListRepository.findByListName(nameToFind);

        //Asercja
        Assertions.assertEquals(1, readTaskLists.size());
        Assertions.assertEquals(description, readTaskLists.get(0).getDescription());

        //CleanUp
        int id = readTaskLists.get(0).getId();
        taskListRepository.deleteById(id);
    }
}