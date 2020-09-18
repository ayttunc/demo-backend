package com.flexible.iot.hq.service;


import com.flexible.iot.hq.io.entity.AnnouncementEntity;
import com.flexible.iot.hq.shared.dto.AnnouncementDto;

public interface AnnouncementService {

    AnnouncementDto createAnnouncement(AnnouncementDto announcementDTO);

    Iterable<AnnouncementEntity> findAllAnnouncements();

    void deleteAnnouncement(long announcementId);

    AnnouncementDto updateAnnouncement(long announcementId, AnnouncementDto announcementDTO) throws Exception;

    AnnouncementDto findSingleAnnouncement(long announcementId) throws Exception;
}
