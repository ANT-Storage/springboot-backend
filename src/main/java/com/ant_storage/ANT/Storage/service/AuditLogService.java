package com.ant_storage.ANT.Storage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant_storage.ANT.Storage.entity.AuditLog;
import com.ant_storage.ANT.Storage.repository.AuditLogRepository;

@Service
public class AuditLogService {
	@Autowired
	private AuditLogRepository auditLogRepository;
	
	public List<AuditLog> findAllAuditLogs() {
		return auditLogRepository.findAll();
	}
	
	public Optional<AuditLog> getAuditLogById(Integer id) {
		return auditLogRepository.findById(id);
	}
	
	public AuditLog saveAuditLog(AuditLog auditLog) {
		return auditLogRepository.save(auditLog);
	}

	public void deleteAuditLog(Integer id) {
		auditLogRepository.deleteById(id);
	}
	
}
