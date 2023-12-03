package springborisov.springbuilder;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class Start {
    @SneakyThrows
    public static void main(String[] args) {
        HashMap<Class, Class> map = new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class));
        ApplicationContext context = ApplicationRunner.run("springbuilder", map);
        context.getObject(CoronaDesinfector.class).start(new Room());
        //        CoronaDesinfector desinfector = ObjectFactory.getInstance().createObject(CoronaDesinfector.class);
//        desinfector.start(new Room());
    }
}
