package libreria;
import java.util.Locale;
public class Formato {
//  M�todos static que retornan valor (con par�metros)
	public static String ajusteA(double real) {
		return String.format(Locale.US, "%2.2f", real);
	}
	public static String ajusteB(double real) {
		return String.format(Locale.US, "%7.2f", real);
	}
}
