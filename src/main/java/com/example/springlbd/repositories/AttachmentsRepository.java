package com.example.springlbd.repositories;

import com.example.springlbd.entity.Attachment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.Set;

public interface AttachmentsRepository extends PagingAndSortingRepository<Attachment,Long> {

    @Query(value = "SELECT A.* FROM ATTACHMENT A INNER JOIN USER_STORY U ON A.USER_STORY_ID=U.ID WHERE U.ID=?1 OFFSET ?2",nativeQuery = true)
    Optional<Attachment> findByUserStoryId(Long id,Long offset);

}
