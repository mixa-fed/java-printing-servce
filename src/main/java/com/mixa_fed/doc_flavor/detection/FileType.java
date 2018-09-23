package com.mixa_fed.doc_flavor.detection;

import java.util.Arrays;

import javax.print.DocFlavor;

public class FileType {

  private byte[] firstBytes;
  private String fileExtension;
  private String mimeType;
  private DocFlavor docFlavor;

  public FileType(byte[] firstBytes, String fileExtension, String mimeType, DocFlavor docFlavor) {
    this.firstBytes = firstBytes;
    this.fileExtension = fileExtension;
    this.mimeType = mimeType;
    this.docFlavor = docFlavor;
  }

  public byte[] getFirstBytes() {
    return firstBytes;
  }

  public String getFileExtension() {
    return fileExtension;
  }

  public String getMimeType() {
    return mimeType;
  }

  public DocFlavor getDocFlavor() {
    return docFlavor;
  }

  @Override
  public String toString() {
    return "FileType [firstBytes=" + Arrays.toString(firstBytes) + ", fileExtension=" + fileExtension + ", mimeType=" + mimeType + ", docFlavor=" + docFlavor + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((docFlavor == null) ? 0 : docFlavor.hashCode());
    result = prime * result + ((fileExtension == null) ? 0 : fileExtension.hashCode());
    result = prime * result + Arrays.hashCode(firstBytes);
    result = prime * result + ((mimeType == null) ? 0 : mimeType.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FileType other = (FileType) obj;
    if (docFlavor == null) {
      if (other.docFlavor != null)
        return false;
    } else if (!docFlavor.equals(other.docFlavor))
      return false;
    if (fileExtension == null) {
      if (other.fileExtension != null)
        return false;
    } else if (!fileExtension.equals(other.fileExtension))
      return false;
    if (!Arrays.equals(firstBytes, other.firstBytes))
      return false;
    if (mimeType == null) {
      if (other.mimeType != null)
        return false;
    } else if (!mimeType.equals(other.mimeType))
      return false;
    return true;
  }

}
