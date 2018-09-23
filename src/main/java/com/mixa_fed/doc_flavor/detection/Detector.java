package com.mixa_fed.doc_flavor.detection;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import javax.print.DocFlavor;

import org.apache.commons.io.IOUtils;

import com.mixa_fed.doc_flavor.detection.exception.DataTypeNotSupportedException;

public class Detector {

  public static DocFlavor detect(InputStream inputStream) throws DataTypeNotSupportedException, IOException {
    byte[] byteArray = IOUtils.toByteArray(inputStream);
    return detect(byteArray);
  }
  
  public static DocFlavor detect(byte[] data) throws DataTypeNotSupportedException {
    List<FileType> mimetypes = MimeTypes.mimeTypes;

    Optional<FileType> findFirst = mimetypes.stream().filter(isFileTypeMatching(data)).findFirst();
    if (findFirst.isPresent()) {
      return findFirst.get().getDocFlavor();
    } else {
      throw new DataTypeNotSupportedException("The data type of the passed data is not supported! Only following types are currently supported: " + MimeTypes.mimeTypes);
    }
  }

  public static Predicate<FileType> isFileTypeMatching(byte[] data) {
    return p -> IntStream.range(0, p.getFirstBytes().length).allMatch(i -> data[i] == p.getFirstBytes()[i]);
  }

}
