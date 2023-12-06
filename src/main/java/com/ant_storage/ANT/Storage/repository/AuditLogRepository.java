package com.ant_storage.ANT.Storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant_storage.ANT.Storage.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer>{

}
