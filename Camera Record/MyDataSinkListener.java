


import javax.media.datasink.*;


public class MyDataSinkListener implements DataSinkListener
{
	boolean endOfStream = false;

	public void dataSinkUpdate(DataSinkEvent event)
	{
		if (event instanceof javax.media.datasink.EndOfStreamEvent)
			endOfStream = true;
	}

	public void waitEndOfStream(long checkTimeMs)
	{
		while (! endOfStream)
		{
			Stdout.log("datasink: waiting for end of stream ...");
			try { Thread.currentThread().sleep(checkTimeMs); } catch (InterruptedException ie) {}
		}
		Stdout.log("datasink: ... end of stream reached.");
	}
}


