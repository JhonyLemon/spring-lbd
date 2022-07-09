package com.example.springlbd.controller;

import com.example.springlbd.dto.AttachmentsDto;
import com.example.springlbd.services.AttachmentsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/attachments")
public class AttachmentsController {

    private AttachmentsService attachmentsService;

    public AttachmentsController(AttachmentsService attachmentsService) {
        this.attachmentsService = attachmentsService;
    }

    @PostMapping(path="/userstory/{id}")
    public void addUserStoryAttachment(
            @PathVariable("id") Long id,
            @RequestParam("file") MultipartFile file) throws IOException {
        attachmentsService.addUserStoryAttachment(id,file);
    }

    @GetMapping("/userstory/{idUserStory}")
    public ResponseEntity<byte[]> getFile(
            @PathVariable("idUserStory") Long idUserStory,
            @RequestParam(value = "offset",required = false) Long offset){
        return attachmentsService.getFile(idUserStory,offset);
    }

}
