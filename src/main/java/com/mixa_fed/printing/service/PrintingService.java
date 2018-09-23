package com.mixa_fed.printing.service;

import java.io.IOException;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrintQuality;
import javax.print.attribute.standard.PrinterName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mixa_fed.doc_flavor.detection.Detector;
import com.mixa_fed.doc_flavor.detection.exception.DataTypeNotSupportedException;
import com.mixa_fed.doc_flavor.detection.exception.PrinterServiceNotFoundException;
import com.mixa_fed.printing.service.api.IPrintingService;

public class PrintingService implements IPrintingService {

  private static Logger LOGGER = LoggerFactory.getLogger(PrintingService.class);
  
  private MediaSizeName mediaSizeName = MediaSizeName.ISO_A4;
  private PrintQuality printQuality = PrintQuality.HIGH;
  

  public MediaSizeName getMediaSizeName() {
    return mediaSizeName;
  }

  @Override
  public void setMediaSizeName(MediaSizeName mediaSizeName) {
    this.mediaSizeName = mediaSizeName;
  }

  public PrintQuality getPrintQuality() {
    return printQuality;
  }
  
  @Override
  public void setPrintQuality(PrintQuality printQuality) {
    this.printQuality = printQuality;
  }

  @Override
  public void print(InputStream inputStream, String printerName, int numberOfCopies) throws DataTypeNotSupportedException, IOException, PrinterServiceNotFoundException, PrintException {
    LOGGER.debug("Try to print input stream " + numberOfCopies + "x times on the printer '" + printerName + "'");

    DocFlavor detectedDocFlavor = Detector.detect(inputStream);
    LOGGER.debug("Detected docFlavor of the input stream is " + detectedDocFlavor);

    PrintService[] printServices = getPrintServices(detectedDocFlavor, printerName);
    if (printServices != null && printServices.length > 0) {
      directPrint(printServices[0], inputStream, detectedDocFlavor, numberOfCopies);
    } else {
      throw new PrinterServiceNotFoundException("Printer Service with the name '" + printerName + "' and supported docFalvor " + detectedDocFlavor + " could not be found!");
    }

  }
  
  protected void directPrint(PrintService printService, InputStream inputStream, DocFlavor docFlavor, int numberOfCopies) throws PrintException {
    Doc doc = new SimpleDoc(inputStream, docFlavor, null);

    PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
    attributes.add(this.mediaSizeName);
    attributes.add(this.printQuality);
    attributes.add(new Copies(numberOfCopies));

    DocPrintJob printJob = printService.createPrintJob();
    printJob.print(doc, attributes);
  }

  protected PrintService[] getPrintServices(DocFlavor docFlavor, String printerName) {
    AttributeSet attributes = new HashAttributeSet();
    attributes.add(new PrinterName(printerName, null));
    return PrintServiceLookup.lookupPrintServices(docFlavor, attributes);
  }
  
  protected PrintService[] getAllPrinterServices() {
    PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
    return printServices;
  }

}
