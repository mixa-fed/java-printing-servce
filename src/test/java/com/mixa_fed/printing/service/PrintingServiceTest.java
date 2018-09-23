package com.mixa_fed.printing.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrintQuality;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class PrintingServiceTest {

  private PrintingService testInstance = new PrintingService();

  private DocPrintJob printJobMock = mock(DocPrintJob.class);

  @Test
  public void test_getAllPrinterServices() {
    testInstance.getAllPrinterServices();
  }

  @Test
  public void test_directPrint() throws PrintException, IOException {
    PrintService printServiceMock = mock(PrintService.class);
    InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.jpg");
    DocFlavor docFlavor = DocFlavor.INPUT_STREAM.JPEG;
    int numberOfCopies = 2;

    given(printServiceMock.createPrintJob()).willReturn(printJobMock);

    testInstance.directPrint(printServiceMock, inputStream, docFlavor, numberOfCopies);

    ArgumentCaptor<Doc> captorDocFlavor = ArgumentCaptor.forClass(Doc.class);
    ArgumentCaptor<PrintRequestAttributeSet> captorAttributes = ArgumentCaptor.forClass(PrintRequestAttributeSet.class);

    verify(printJobMock).print(captorDocFlavor.capture(), captorAttributes.capture());

    Doc docToVerify = captorDocFlavor.getValue();
    assertEquals(docFlavor, docToVerify.getDocFlavor());
    assertEquals(inputStream, docToVerify.getStreamForBytes());

    PrintRequestAttributeSet attributesToVerify = captorAttributes.getValue();
    assertEquals(MediaSizeName.ISO_A4, attributesToVerify.get(Media.class)); // ISO_A4 is default
    assertEquals(PrintQuality.HIGH, attributesToVerify.get(PrintQuality.class)); // Quality HIGH is
                                                                                 // default

    System.out.println(attributesToVerify.get(Copies.class));

    assertEquals(numberOfCopies, ((Copies) attributesToVerify.get(Copies.class)).getValue());
  }

}
