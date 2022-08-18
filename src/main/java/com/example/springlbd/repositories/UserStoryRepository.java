package com.example.springlbd.repositories;

import com.example.springlbd.entity.UserStory;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserStoryRepository extends PagingAndSortingRepository<UserStory,Long> {

}
