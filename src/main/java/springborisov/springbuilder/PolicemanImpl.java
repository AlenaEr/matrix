package springborisov.springbuilder;

import jakarta.annotation.PostConstruct;

public class PolicemanImpl implements Policeman{
    @InjectByType
    private Reccomendator reccomendator;

    @PostConstruct
    public void init() {
        System.out.println(reccomendator.getClass());
    }

    @Override
    public void getOutPeople() {
        System.out.println("всё вон, пиф паф!!!");
    }
}
