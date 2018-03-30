package pirate.debug;

/**

 @author flashman
 */
public class DebugInfo<T extends Enum> {

    protected T state;
    protected String message = null;

    public DebugInfo(T state) {
        this.state = state;
    }

    public DebugInfo(T state, String message) {
        this.state = state;
        this.message = message;
    }

    public T getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }
}
