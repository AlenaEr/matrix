package springborisov.springbuilder;

/**
 * @author Evgeny Borisov
 */
public class AngryPoliceman implements Policeman {
    @Override
    public void getOutPeople() {
        System.out.println("Всех убью! Вон пошли");
    }
}
