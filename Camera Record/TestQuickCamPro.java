import java.io.*;

import javax.media.*;
import javax.media.control.*;
import javax.media.datasink.*;
import javax.media.format.*;
import javax.media.protocol.*;


public class TestQuickCamPro
{

	public static void main(String args[]) throws IOException, NoDataSourceException, IncompatibleSourceException
	{
		MediaLocator camDeviceMediaLocator = new MediaLocator("vfw:Micrsoft WDM Image Capture (Win32):0");
                DataSource myDataSource = Manager.createDataSource(camDeviceMediaLocator);
                DataSource videoDataSource = myDataSource;
                MediaLocator audioMediaLocator = new MediaLocator("dsound://");
                DataSource audioDataSource = null;
                audioDataSource = Manager.createDataSource(audioMediaLocator);
                DataSource dArray[] = new DataSource[2];
                dArray[0] = videoDataSource;
                dArray[1] = audioDataSource;
                DataSource mixedDataSource = null;
                mixedDataSource = Manager.createMergingDataSource(dArray);
                Format outputFormat[] = new Format[2];
                outputFormat[0] = new VideoFormat(VideoFormat.YUV);
                outputFormat[1] = new AudioFormat(AudioFormat.GSM_MS);
		ProcessorModel processorModel = new ProcessorModel(mixedDataSource,outputFormat,new FileTypeDescriptor(FileTypeDescriptor.MSVIDEO));
                Processor processor = null;
		try{
                     processor = Manager.createRealizedProcessor(processorModel);}
		catch (IOException e) { Stdout.logAndAbortException(e); }
		catch (NoProcessorException e) { Stdout.logAndAbortException(e); }
		catch (CannotRealizeException e) { Stdout.logAndAbortException(e); }
		// get the output of the processor
		DataSource source = processor.getDataOutput();
		// create a File protocol MediaLocator with the location
		// of the file to which bits are to be written
		//MediaLocator dest = new MediaLocator("file:testcam.mov");
		MediaLocator dest = new MediaLocator("file:.\\testcam.avi");
		// create a datasink to do the file
		DataSink dataSink = null;
		MyDataSinkListener dataSinkListener = null;
		try{
			//dataSink = Manager.createDataSink(source, dest);
                        dataSink =  Manager.createDataSink(processor.getDataOutput(), dest);
			dataSinkListener = new MyDataSinkListener();
			dataSink.addDataSinkListener(dataSinkListener);
			dataSink.open();}
		catch (IOException e) { Stdout.logAndAbortException(e); }
		catch (NoDataSinkException e) {
                    e.printStackTrace();
                    Stdout.logAndAbortException(e);}
		catch (SecurityException e) { Stdout.logAndAbortException(e); }
		// now start the datasink and processor
		try{
			dataSink.start();}
		catch (IOException e) { Stdout.logAndAbortException(e); }
		processor.start();
		Stdout.log("starting capturing ...");
		try { Thread.currentThread().sleep(10000); } catch (InterruptedException ie) {}	// capture for 10 seconds
		Stdout.log("... capturing done");
		// stop and close the processor when done capturing...
		// close the datasink when EndOfStream event is received...
		processor.stop();
		processor.close();

		dataSinkListener.waitEndOfStream(10);
		dataSink.close();

		Stdout.log("[all done]");
	}

}
