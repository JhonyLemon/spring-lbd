package com.example.springlbd.repositories;

import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.UserStory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SprintRepository extends PagingAndSortingRepository<Sprint,Long> {

    @Query("SELECT s.userStories FROM Sprint s WHERE s.id=?1")
    Optional<List<UserStory>> findUserStoriesById(Long id);

    Optional<List<Sprint>> findByBeginDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate begin, LocalDate end);

    @Query("SELECT SUM(u.storyPoints) FROM UserStory u INNER JOIN u.sprints s WHERE s.id=?1")
    Optional<Long> countStoryPointsBySprintId(Long id);


    @Query("select S FROM Sprint S join fetch S.userStories")
    Iterable<Sprint> findAllFetchUserStories();

    @Query("SELECT S FROM Sprint S WHERE S.sprintStatus='Pending' ORDER BY S.beginDate DESC")
    Optional<Sprint> findRecentWithPendingStatus();


}
