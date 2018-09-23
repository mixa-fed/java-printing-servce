package com.mixa_fed.doc_flavor.detection;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import javax.print.DocFlavor;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.mixa_fed.doc_flavor.detection.exception.DataTypeNotSupportedException;

public class DetectorTest {

  @Test
  public void test_detect() throws IOException, DataTypeNotSupportedException {
    InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.jpg");
    byte[] bytes = IOUtils.toByteArray(is);

    assertEquals(DocFlavor.INPUT_STREAM.JPEG, Detector.detect(bytes));
  }

}
