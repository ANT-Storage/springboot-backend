package com.ant_storage.ANT.Storage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant_storage.ANT.Storage.entity.AuditLog;
import com.ant_storage.ANT.Storage.service.AuditLogService;

@RestController
@RequestMapping("antstorage/v1/audit_logs")
public class AuditLogController {
	@Autowired
	private AuditLogService auditLogService;
	
	@GetMapping()
	public List<AuditLog> getAllAuditLogs() {
		return auditLogService.findAllAuditLogs();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<AuditLog>> getAuditLogById(@PathVariable Integer id){
		Optional<AuditLog> auditLog = auditLogService.getAuditLogById(id);
		return (auditLog.isPresent()) ? ResponseEntity.ok(auditLog) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public AuditLog createAuditLog(AuditLog auditLog) {
		return auditLogService.saveAuditLog(auditLog);
	}
}
