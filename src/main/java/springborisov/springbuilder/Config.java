package springborisov.springbuilder;

public interface Config {
    <T> Class<? extends T> getImplClass (Class<T> type);
}
