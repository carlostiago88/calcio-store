package shop.calciostore.application.configuration.javers;

import org.javers.spring.auditable.CommitPropertiesProvider;

import java.util.Collections;
import java.util.Map;

public class EmptyPropertiesProvider implements CommitPropertiesProvider {
    @Override
    public Map<String, String> provide() {
        return Collections.emptyMap();
    }
}