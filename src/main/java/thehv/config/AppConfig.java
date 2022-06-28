package thehv.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppConfig {
    @Value("${jasypt.encryptor.password}")
    private String jasyptPassword;
}