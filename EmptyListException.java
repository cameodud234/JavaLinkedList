public class EmptyListException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 8763413167219403635L;

    private String s;

    EmptyListException(String s) {
        super(s);
        this.s = s;
    }
    
    public String toString() {
        return this.s;
    }
}