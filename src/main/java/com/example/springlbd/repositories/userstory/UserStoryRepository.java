package com.example.springlbd.repositories.userstory;

import com.example.springlbd.entity.userstory.UserStory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserStoryRepository extends PagingAndSortingRepository<UserStory,Long> {

}
