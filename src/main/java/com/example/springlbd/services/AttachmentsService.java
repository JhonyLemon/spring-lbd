package com.example.springlbd.services;

import com.example.springlbd.entity.Attachment;
import com.example.springlbd.entity.UserStory;
import com.example.springlbd.mapper.AttachmentsMapper;
import com.example.springlbd.repositories.AttachmentsRepository;
import com.example.springlbd.repositories.UserStoryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@Service
public class AttachmentsService {

    private UserStoryRepository userStoryRepository;
    private AttachmentsRepository attachmentsRepository;
    private AttachmentsMapper attachmentsMapper;

    public AttachmentsService(UserStoryRepository userStoryRepository,
                              AttachmentsMapper attachmentsMapper,
                              AttachmentsRepository attachmentsRepository) {
        this.userStoryRepository = userStoryRepository;
        this.attachmentsMapper = attachmentsMapper;
        this.attachmentsRepository=attachmentsRepository;
    }

    @Transactional
    public void addUserStoryAttachment(Long id, MultipartFile file) throws IOException {
        if(id<1)
            throw new IllegalArgumentException("id nie może być mniejsze od 1");
        Optional<UserStory> optional= userStoryRepository.findById(id);
        if(!optional.isPresent())
            throw new EmptyResultDataAccessException("User story o podanym id nie istnieje",0);

            Attachment attachment = new Attachment(file.getBytes(),file.getOriginalFilename(),optional.get());
        optional.get().getAttachments().add(attachment);
        attachment.setUserStory(optional.get());
        attachmentsRepository.save(attachment);
    }

    public ResponseEntity<byte[]> getFile(Long idUserStory,Long offset){

        Optional<UserStory> optionalUserStory=userStoryRepository.findById(idUserStory);
        if(!optionalUserStory.isPresent())
            throw new EmptyResultDataAccessException("User story o podanym id nie istnieje",0);

        Optional<Attachment> optionalAttachment=attachmentsRepository.findByUserStoryId(idUserStory,(offset==null ? 0 : offset));
        if(!optionalAttachment.isPresent())
            throw new EmptyResultDataAccessException("Nie znaleziono pliku z podanym przesunięciem",0);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + optionalAttachment.get().getName() + "\"")
                .body(optionalAttachment.get().getAttachment());
    }

}
