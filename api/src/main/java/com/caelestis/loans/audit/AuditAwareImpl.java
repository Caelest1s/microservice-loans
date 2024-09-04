package com.caelestis.loans.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    /**
     * Return the current auditor of the application
     *
     * @return the current auditor (data registered in DB create at and by)
     */

    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("LOANS_MICROSERVICE");
    }
}
