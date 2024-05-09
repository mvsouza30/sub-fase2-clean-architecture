package sub.fase2.cleanarchitecture.carsales.infrastructure.providers;

import sub.fase2.cleanarchitecture.carsales.domain.entity.valueobject.DateTimeProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeProvider implements DateTimeProvider {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String currentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }
}
