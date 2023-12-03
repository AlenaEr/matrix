package springborisov.springbuilder;

public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    //            ObjectFactory.getInstance().createObject(Announcer.class);
    /*new ConsoleAnnouncer ();*/
    @InjectByType
    private Policeman policeman;
//        ObjectFactory.getInstance().createObject(Policeman.class);
    /*new PolicemanImpl();*/

    public void start(Room room) {
            if (announcer != null) {
                announcer.announce("надо выйти из помещения");
            } else {
                System.out.println("Announcer is not initialized");
            }
            if (policeman != null) {
                policeman.getOutPeople();
            } else {
                System.out.println("Policeman is not initialized");
            }
            desinfect(room);
            if (announcer != null) {
                announcer.announce("Рискните вернуться, вроде короны не видно");
            } else {
                System.out.println("Announcer is not initialized");
            }
        }

    private void desinfect(Room room) {
        System.out.println("зачитывается молитва: 'корона изыди!' ");
    }
}