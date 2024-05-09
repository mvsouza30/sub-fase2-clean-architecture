package sub.fase2.cleanarchitecture.carsales.infrastructure.valueobjects;

import sub.fase2.cleanarchitecture.carsales.domain.entity.valueobject.DateTimeProvider;

import java.time.LocalDateTime;

public class ConcreteDateTimeProvider implements DateTimeProvider {

    public String currentDateTime() {
        return LocalDateTime.now().toString();
    }
}
