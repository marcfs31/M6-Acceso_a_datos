public class Ejemplo {
	public static void main (String[] args) {
		int [] arraynum = new int [4];
		try {
			arraynum[10] = 20;
		} catch (Exception ex) {
			System.err.println ("toString      => " + ex.toString());
			System.err.println ("getMessage => " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			System.out.println ("SE EJECUTA SIEMPRE");
		}
	}
}