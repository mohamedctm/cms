package com.project2.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project2.cms.model.Inbox;

@Repository
public interface InboxRepository extends JpaRepository<Inbox, Integer>{

}
