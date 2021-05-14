// This is an interface used for the Strategy Pattern each item has a different way of being used
/**
 * The interface Usable.
 */
public interface Usable {
    /**
     * Use.
     *
     * @param state the state
     */
    public void use(State state);
}
