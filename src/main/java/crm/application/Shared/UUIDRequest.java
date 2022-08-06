package crm.application.Shared;

import java.util.UUID;

public record UUIDRequest(
        UUID id, String note
) {
}
