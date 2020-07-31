package com.cmvtech.news.cmvnews.ui.controller;

import com.cmvtech.news.cmvnews.service.AnnouncementService;
import com.cmvtech.news.cmvnews.shared.dto.AnnouncementDTO;
import com.cmvtech.news.cmvnews.ui.model.request.AnnouncementDetailRequestModel;
import com.cmvtech.news.cmvnews.ui.model.response.AnnouncementDetailResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping(value = "/announcements")
    public ResponseEntity listAllNews() {
        return ResponseEntity.ok(announcementService.findAllAnnouncements());
    }

    @PostMapping(value = "/announcements")
    public ResponseEntity createAnnouncement(@RequestBody AnnouncementDetailRequestModel anncDetail) {
        ModelMapper mapper = new ModelMapper();
        AnnouncementDTO anncDTO = mapper.map(anncDetail, AnnouncementDTO.class);

        AnnouncementDTO createdAnnouncement = announcementService.createAnnouncement(anncDTO);

        AnnouncementDetailResponseModel anncResponse = mapper.map(createdAnnouncement, AnnouncementDetailResponseModel.class);
        return ResponseEntity.ok(anncResponse);
    }

    @PutMapping(value = "/announcements/{id}")
    public ResponseEntity updateOneOfNews(@PathVariable int id, @RequestBody AnnouncementDetailRequestModel anncDetail) {

        ModelMapper mapper = new ModelMapper();
        AnnouncementDTO anncDto = mapper.map(anncDetail, AnnouncementDTO.class);
        anncDto = announcementService.updateAnnouncement(id, anncDto);

        AnnouncementDetailResponseModel responseModel = mapper.map(anncDto, AnnouncementDetailResponseModel.class);
        return ResponseEntity.ok(responseModel);
    }

    @DeleteMapping(value = "/announcements/{id}")
    public ResponseEntity deleteOneOfNews(@PathVariable int id) {
        announcementService.deleteAnnouncement(id);
        return ResponseEntity.status(200).body("Announcement deleted");
    }
}
