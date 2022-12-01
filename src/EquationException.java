/**
 * 
 */

/**
 * @author huongbui
 *
 */
public class EquationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EquationException()
	{
		super("Your input format is wrong. Please try again!!!!!!");
	}
	public EquationException(String message)
	{
		super(message);
	}

}
