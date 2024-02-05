package com.projet_voiture.projet_voiture.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.projet_voiture.projet_voiture.modele.Task;

import java.util.List;
public interface  TaskRepository extends MongoRepository<Task,String>  {
    List<Task> findBySeverity(int severity);

    @Query("{ assignee: ?0 }")
    List<Task> getTasksByAssignee(String assignee);
}
