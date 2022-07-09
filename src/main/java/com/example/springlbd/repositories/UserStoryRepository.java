package com.example.springlbd.repositories;

import com.example.springlbd.entity.UserStory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserStoryRepository extends PagingAndSortingRepository<UserStory,Long> {

    @Query("SELECT u.description FROM UserStory u WHERE u.id=?1")
    Optional<String> findUserStoryDescriptionById(Long id);

}
