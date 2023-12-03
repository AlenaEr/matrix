package springborisov.springbuilder;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ObjectFactory {
    private final ApplicationContext context;
//    private static ObjectFactory instance = new ObjectFactory();
//    private Config config;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory (ApplicationContext context) {
        this.context = context;
//        Reflections scanner = new Reflections("com.epam");
//        Map<Class, Class> map = new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class) );
//        config = new JavaConfig(context.getScanner(), map);
        Set<Class<? extends ObjectConfigurator>> classes = context.getScanner().getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

//    public static ObjectFactory getInstance() {
//        return instance;
//    }

    public <T> T createObject(Class<T> type) throws Exception{
//        type = resolveImpl(type);
        T t = type.getDeclaredConstructor().newInstance();
        configure(t);

        invokeInit(type, t);
        return t;
    }

    private static <T> void invokeInit(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method : type.getMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure (T t) {
        configurators.forEach(configurator -> configurator.configure(t, context));
    }

}