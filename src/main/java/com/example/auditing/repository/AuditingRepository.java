package com.example.auditing.repository;

import com.example.auditing.entity.Auditing;
import org.springframework.data.repository.CrudRepository;

public interface AuditingRepository extends CrudRepository<Auditing, Long> {
}
