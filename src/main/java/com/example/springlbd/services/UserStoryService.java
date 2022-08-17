package com.example.springlbd.services;

import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.entity.Attachment;
import com.example.springlbd.entity.Sprint;
import com.example.springlbd.entity.enums.UserStoryStatus;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.events.UserStoryCreatedEvent;
import com.example.springlbd.mapper.UserStoryMapper;
import com.example.springlbd.repositories.AttachmentsRepository;
import com.example.springlbd.repositories.SprintRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class UserStoryService {

    private final UserStoryRepository userStoryRepository;
    private final AttachmentsRepository attachmentsRepository;


    private final UserStoryMapper userStoryMapper;

    private final ApplicationEventPublisher applicationEventPublisher;



    public String getUserStoryDescriptionById(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        return userStoryRepository
                .findUserStoryDescriptionById(id)
                .orElseThrow(()-> new EntityNotFoundException("User story o podanym id nie istnieje"));

    }

    @Transactional
    public void addUserStoryAttachment(Long id, MultipartFile file) throws IOException {
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        UserStory userStory=userStoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("User story o podanym id nie istnieje"));
        userStory
                .getAttachments()
                .add(Attachment
                        .builder()
                        .name(file.getOriginalFilename())
                        .attachment(file.getBytes())
                        .userStory(userStory)
                        .build());
    }

    public ResponseEntity<byte[]> getFile(Long idUserStory, Long offset){
        List<Attachment> attachments=userStoryRepository
                .findById(idUserStory)
                .orElseThrow(()->new EntityNotFoundException("User story o podanym id nie istnieje"))
                .getAttachments();
        if(attachments.size()<=offset)
            throw new EntityNotFoundException("Nie znaleziono pliku z podanym przesunięciem");
        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachments.get(offset.intValue()).getName() + "\"")
                .body(attachments.get(offset.intValue()).getAttachment());
    }

    @Transactional
    public void deleteUserStoryById(Long id){
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");

        UserStory userStory = userStoryRepository
                .findById(id)
                .orElseThrow(()->new EntityNotFoundException("User story o podanym id nie istnieje"));

        userStory.getSprints().forEach(x -> x.getUserStories().remove(userStory));
        userStoryRepository.delete(userStory);
    }

    public List<UserStoryDto> getSortedByNamePage(Integer pageSize, Integer pageNumber){
        return userStoryRepository
                .findAll(PageRequest.of(
                        pageNumber,
                        pageSize,
                        Sort.by("name").ascending())
                )
                .map(x-> userStoryMapper.UserStoryToUserStoryDtoWithoutConstraints(x)).toList();
    }

    @Transactional
    public UserStoryDto saveUserStory(UserStoryDto userStoryDto){
        if(userStoryDto.getName()==null)
            throw new IllegalArgumentException("Pole nazwy user story nie może być puste");
        if(userStoryDto.getDescription()==null)
            throw new IllegalArgumentException("Pole opisu user story nie może być puste");
        if(userStoryDto.getUserStoryStatus()==null)
            userStoryDto.setUserStoryStatus(UserStoryStatus.To_do);
        UserStory userStory=userStoryRepository.save(userStoryMapper.UserStoryDtoToUserStory(userStoryDto));
        applicationEventPublisher.publishEvent(new UserStoryCreatedEvent(userStory));
        return userStoryMapper.UserStoryToUserStoryDtoWithoutConstraints(userStory);
    }

}
