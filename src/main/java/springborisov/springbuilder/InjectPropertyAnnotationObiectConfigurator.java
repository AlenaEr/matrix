package springborisov.springbuilder;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InjectPropertyAnnotationObiectConfigurator implements ObjectConfigurator{

    private Map<String, String> map;

    @SneakyThrows
    public InjectPropertyAnnotationObiectConfigurator() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
       map = lines.map(line -> line.split("=")).collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));

    }

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        Class<?> type = t.getClass () ;
        for (Field field : type.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            if (annotation != null) {
                String propertyName = annotation.value();
                String propertyValue = map.get(propertyName);
                field.setAccessible(true);
                field.set(t, propertyValue);
            }
        }
    }
}
