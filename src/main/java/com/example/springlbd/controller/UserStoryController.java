package com.example.springlbd.controller;
import com.example.springlbd.dto.UserStoryDto;
import com.example.springlbd.services.UserStoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/userstory")
@AllArgsConstructor
public class UserStoryController {

    private final UserStoryService userStoryService;

    @GetMapping("/descriptionById")
    public String getUserStoryDescriptionById(@RequestParam("id") Long id){
        return userStoryService.getUserStoryDescriptionById(id);
    }

    @PostMapping(path="/{id}/attachment")
    public void addUserStoryAttachment(
            @PathVariable("id") Long id,
            @RequestParam("file") MultipartFile file) throws IOException {
        userStoryService.addUserStoryAttachment(id,file);
    }

    @GetMapping("/{idUserStory}/attachment")
    public ResponseEntity<byte[]> getFile(
            @PathVariable("idUserStory") Long idUserStory,
            @RequestParam(value = "offset",required = false) Long offset){
        return userStoryService.getFile(idUserStory,offset);
    }

    @DeleteMapping("/{id}")
    public void deleteUserStoryById(@PathVariable("id") Long id){
        userStoryService.deleteUserStoryById(id);
    }

    @GetMapping("/sortedByName")
    public List<UserStoryDto> getSortedByNamePage(@RequestParam("pageSize") Integer pageSize,
                                                  @RequestParam("pageNumber") Integer pageNumber){
        return userStoryService.getSortedByNamePage(pageSize,pageNumber);
    }

    @PostMapping(value = "/save")
    public void saveUserStory(@RequestBody UserStoryDto userStoryDto){
        userStoryService.saveUserStory(userStoryDto);
    }

}
