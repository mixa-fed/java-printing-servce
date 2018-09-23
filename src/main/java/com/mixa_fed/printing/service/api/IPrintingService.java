package com.mixa_fed.printing.service.api;

import java.io.IOException;
import java.io.InputStream;

import javax.print.PrintException;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrintQuality;

import com.mixa_fed.doc_flavor.detection.exception.DataTypeNotSupportedException;
import com.mixa_fed.doc_flavor.detection.exception.PrinterServiceNotFoundException;

/**
 * 
 * @author Michael Fedorenko
 * 
 *         23.09.2018
 */
public interface IPrintingService {

  /**
   * Prints the given input stream to the defined printer service. The type of
   * the input stream will be detected automatically and mapped to the correct
   * {@link javax.print.DocFlavor}.</br>
   * The printer quality is by default {@link javax.print.attribute.standard.PrintQuality#HIGH}
   * and can be changed explicitly by {@link #setPrintQuality(PrintQuality)}</br>
   * The media size name is by default {@link javax.print.attribute.standard.MediaSizeName#ISO_A4} 
   * and can be changed explicitly by {@link #setMediaSizeName(MediaSizeName)}
   * 
   * @param inputStream - The {@link InputStream} that should be printed 
   * @param printerName - The name of the printer service on the OS
   * @param numberOfCopies - The number of copies that should be printed
   * @throws DataTypeNotSupportedException
   * @throws IOException
   * @throws PrinterServiceNotFoundException
   * @throws PrintException
   */
  void print(InputStream inputStream, String printerName, int numberOfCopies) throws DataTypeNotSupportedException, IOException, PrinterServiceNotFoundException, PrintException;

  /**
   * Sets the media size name.
   * 
   * @param mediaSizeName - The {@link MediaSizeName}
   */
  void setMediaSizeName(MediaSizeName mediaSizeName);

  /**
   * Sets the print quality.
   * 
   * @param printQuality -The {@link PrintQuality}
   */
  void setPrintQuality(PrintQuality printQuality);
  
}
