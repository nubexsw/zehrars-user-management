package com.zehra.realstate.usermanagement.api;

import com.zehra.realstate.usermanagement.exception.DataNotFoundException;
import com.zehra.realstate.usermanagement.persistence.audit.AuditEntity;
import com.zehra.realstate.usermanagement.persistence.audit.AuditRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Locale;
import java.util.Optional;

@RestController
public class AuditController {

    private final MessageSource messageSource;

    private final AuditRepository repository;

    @Autowired
    public AuditController(AuditRepository repository, MessageSource messageSource) {
        this.repository = repository;
        this.messageSource = messageSource;
    }

    @GetMapping("/audit/logs/help")
    public String getHelp() {
        Locale locale = LocaleContextHolder.getLocale();
        Object[] args = new Object[]{"Zehra Realstate"};
        return messageSource.getMessage("audit.service.help.description", args, "Audit logs help message", locale);
    }

    @GetMapping("/v1/audit/logs/help")
    public String getHelpV1() {
        Locale locale = LocaleContextHolder.getLocale();
        Object[] args = new Object[]{"Zehra Realstate"};
        return messageSource.getMessage("audit.service.v1.help.description", args, "Audit logs help message", locale);
    }

    @GetMapping(path = "/audit/logs/help", params="version=2")
    public String getHelpV2() {
        Locale locale = LocaleContextHolder.getLocale();
        Object[] args = new Object[]{"Zehra Realstate"};
        return messageSource.getMessage("audit.service.v2.help.description", args, "Audit logs help message", locale);
    }

    @GetMapping(path = "/audit/logs/help", headers="X-API-VERSION=3")
    public String getHelpV3() {
        Locale locale = LocaleContextHolder.getLocale();
        Object[] args = new Object[]{"Zehra Realstate"};
        return messageSource.getMessage("audit.service.v3.help.description", args, "Audit logs help message", locale);
    }

    @GetMapping(path = "/audit/logs/help", produces = "application/zehra.real.state.app-v4+json")
    public String getHelpV4() {
        Locale locale = LocaleContextHolder.getLocale();
        Object[] args = new Object[]{"Zehra Realstate"};
        return messageSource.getMessage("audit.service.v4.help.description", args, "Audit logs help message", locale);
    }

    // Include @Valid annotation to ensure the request body is validated
    // The validation constraints should be defined in the AuditEntity class
    @PostMapping("/audit/logs")
    public ResponseEntity<AuditEntity> addAuditLog(@Valid @RequestBody AuditEntity audit) {
        AuditEntity savedLog = repository.save(audit);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedLog.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/audit/logs/{id}")
    public AuditEntity getById(@PathVariable(name = "id") Long id) {
        Optional<AuditEntity> logs = repository.findById(id);
        if (logs.isEmpty()) {
            throw new DataNotFoundException("Audit log not found with id: " + id);
        }
        return logs.orElse(new AuditEntity());
    }
}
