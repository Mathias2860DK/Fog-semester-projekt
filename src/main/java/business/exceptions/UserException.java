package business.exceptions;

/**
 * This class is for exceptions if anything goes wrong with the user.
 */
public class UserException extends Exception {

    /**
     * @param msg The message we want to display for the user if something goes wrong.
     */
    public UserException(String msg) {
        super(msg);
    }


}
