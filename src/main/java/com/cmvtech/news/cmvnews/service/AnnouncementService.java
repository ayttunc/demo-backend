package com.cmvtech.news.cmvnews.service;


import com.cmvtech.news.cmvnews.io.entity.AnnouncementEntity;
import com.cmvtech.news.cmvnews.shared.dto.AnnouncementDTO;

public interface AnnouncementService {

    AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO);

    Iterable<AnnouncementEntity> findAllAnnouncements();

    void deleteAnnouncement(long announcementId);

    AnnouncementDTO updateAnnouncement(long announcementId, AnnouncementDTO announcementDTO) throws Exception;

    AnnouncementDTO findSingleAnnouncement(long announcementId) throws Exception;
}
