package com.cmvtech.news.cmvnews.service.impl;

import com.cmvtech.news.cmvnews.io.entity.AnnouncementEntity;
import com.cmvtech.news.cmvnews.io.repository.AnnouncementReporsitory;
import com.cmvtech.news.cmvnews.service.AnnouncementService;
import com.cmvtech.news.cmvnews.shared.dto.AnnouncementDTO;
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
        announcementReporsitory.deleteById(announcementId);
    }

    @Override
    public AnnouncementDTO updateAnnouncement(long announcementId, AnnouncementDTO announcementDTO) {
        Optional<AnnouncementEntity> announcementEntity = announcementReporsitory.findById(announcementId);
        if (announcementEntity.isPresent()) {
            announcementEntity.get().setTitle(announcementDTO.getTitle());
            announcementEntity.get().setDescription(announcementDTO.getDescription());
            announcementEntity.get().setValidUntil(announcementDTO.getValidUntil());
            announcementReporsitory.save(announcementEntity.get());
        }
        return announcementDTO;
    }
}
