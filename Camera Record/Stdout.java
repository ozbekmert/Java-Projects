




public class Stdout
{

	public static void log(String msg)
	{
		System.out.println(msg);
	}
        

	public static void logAndAbortException(Exception e)
	{
		log("" + e);
		flush();
		System.exit(0);
	}


	public static void logAndAbortError(Error e)
	{
		log("" + e);
		flush();
		System.exit(0);
	}


	public static void flush()
	{
		System.out.flush();
	}

}
