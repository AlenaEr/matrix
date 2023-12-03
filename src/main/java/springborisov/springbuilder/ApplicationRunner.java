package springborisov.springbuilder;

import java.util.Map;

public class ApplicationRunner {
    public static ApplicationContext run (String packageToscan, Map<Class, Class> ifcToImplClass){
        ApplicationContext context = new ApplicationContext(packageToscan, ifcToImplClass);
        return context;
    }
}
