package com.flexible.iot.hq.service;


import com.flexible.iot.hq.io.entity.AnnouncementEntity;
import com.flexible.iot.hq.shared.dto.AnnouncementDTO;

public interface AnnouncementService {

    AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO);

    Iterable<AnnouncementEntity> findAllAnnouncements();

    void deleteAnnouncement(long announcementId);

    AnnouncementDTO updateAnnouncement(long announcementId, AnnouncementDTO announcementDTO) throws Exception;

    AnnouncementDTO findSingleAnnouncement(long announcementId) throws Exception;
}
