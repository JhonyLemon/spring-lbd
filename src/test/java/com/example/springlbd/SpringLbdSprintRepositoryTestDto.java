package com.example.springlbd;

import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.enums.SprintStatus;
import com.example.springlbd.repositories.SprintRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
public class SpringLbdSprintRepositoryTestDto {

    @Autowired
    SprintRepository sprintRepository;

    @Test
    void givenDataCreated_whenFindAllPaginatedAndSort_thenSuccess(){

        Random random =new Random();

        for(Integer i=0; i<10; i++)
        {
            sprintRepository.save(new Sprint(
                    UUID.randomUUID().toString(),
                    LocalDate.of(random.nextInt(2050-1900)+1900,random.nextInt(12-1)+1,random.nextInt(31-1)+1),
                    LocalDate.of(random.nextInt(2070-2060)+2060,random.nextInt(12-1)+1,random.nextInt(31-1)+1),
                    UUID.randomUUID().toString(),
                    SprintStatus.values()[random.nextInt(3)],
                    null
            ));
        }
        Sprint sprint = new Sprint(
                null,
                LocalDate.of(2100,1,1),
                LocalDate.of(2200,1,1),
                "opis",
                SprintStatus.In_progress,
                null
        );
        sprintRepository.save(sprint);

        Page<Sprint> retrivedSprints = sprintRepository
                .findAll(PageRequest
                        .of(
                                0,
                                3,
                                Sort.by(Sort.Order.desc("beginDate"))));

        assert (retrivedSprints.getContent().size()==3 &&
                retrivedSprints.getContent().get(0).getBeginDate().equals(sprint.getBeginDate())
        );
    }
}
