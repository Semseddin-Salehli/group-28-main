package az.developia.course.qrup28.configuration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "fake")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppProperties {
    String url;
    String type;
}
