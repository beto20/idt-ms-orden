package org.example.model;

import java.time.Instant;
import java.util.UUID;

public record OrderRegisteredEvent(
        UUID eventId,
        String eventType,
        int schemaVersion,
        String attendeeId,
        String email,
        Instant occurredAt
) {

    public static OrderRegisteredEvent create(
            String attendeeId,
            String email
    ) {
        return new OrderRegisteredEvent(
                UUID.randomUUID(),
                "attendee.registered",
                1,
                attendeeId,
                email,
                Instant.now()
        );
    }
}
