package com.cmvtech.news.cmvnews.service.impl;

import com.cmvtech.news.cmvnews.io.entity.AnnouncementEntity;
import com.cmvtech.news.cmvnews.io.repository.AnnouncementReporsitory;
import com.cmvtech.news.cmvnews.service.AnnouncementService;
import com.cmvtech.news.cmvnews.shared.dto.AnnouncementDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {


    private final AnnouncementReporsitory announcementReporsitory;

    public AnnouncementServiceImpl(AnnouncementReporsitory announcementReporsitory) {
        this.announcementReporsitory = announcementReporsitory;
    }

    @Override
    public AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO) {
        AnnouncementEntity announcement = new AnnouncementEntity();
        announcement.setTitle(announcementDTO.getTitle());
        announcement.setDescription(announcementDTO.getDescription());
        announcement.setValidUntil(announcementDTO.getValidUntil());

        announcementReporsitory.save(announcement);
        return announcementDTO;
    }

    @Override
    public Iterable<AnnouncementEntity> findAllAnnouncements() {
        return announcementReporsitory.findAll();
    }

    @Override
    public void deleteAnnouncement(long announcementId) {
        Optional<AnnouncementEntity> anncmnt = announcementReporsitory.findById(announcementId);
        if (anncmnt.isPresent()) {
            announcementReporsitory.delete(anncmnt.get());
        }
    }

    @Override
    public AnnouncementDTO updateAnnouncement(long announcementId, AnnouncementDTO announcementDTO) throws Exception {
        Optional<AnnouncementEntity> announcementEntity = announcementReporsitory.findById(announcementId);
        if (announcementEntity.isPresent()) {
            announcementEntity.get().setTitle(announcementDTO.getTitle());
            announcementEntity.get().setDescription(announcementDTO.getDescription());
            announcementEntity.get().setValidUntil(announcementDTO.getValidUntil());
            announcementReporsitory.save(announcementEntity.get());
            return announcementDTO;
        }else {
            throw new Exception("Duyuru Bulunamadı");
        }
    }

    @Override
    public AnnouncementDTO findSingleAnnouncement(long announcementId) throws Exception {
        ModelMapper mapper = new ModelMapper();
        AnnouncementEntity anncmnt;
        if (announcementReporsitory.findById(announcementId).isPresent()) {
            anncmnt = announcementReporsitory.findById(announcementId).get();
            AnnouncementDTO retAnncmnt = mapper.map(anncmnt, AnnouncementDTO.class);
            return retAnncmnt;
        } else {
            throw new Exception("Announcement not found exception");
        }
    }
}
