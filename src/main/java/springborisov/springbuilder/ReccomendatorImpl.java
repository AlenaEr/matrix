package springborisov.springbuilder;

@Singleton
public class ReccomendatorImpl implements Reccomendator{
    @InjectProperty ("alcohol")
    private String drinkName;

    public ReccomendatorImpl() {
        System.out.println("reccomendator was created");
    }

    @Override
    public void reccomend() {
        System.out.println("drink " + drinkName);
    }
}
