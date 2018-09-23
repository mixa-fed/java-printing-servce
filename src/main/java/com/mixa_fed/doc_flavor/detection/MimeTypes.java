package com.mixa_fed.doc_flavor.detection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.DocFlavor;

public interface MimeTypes {


//  static FileType WORD = new FileType(new byte[] {(byte) 0xEC, (byte) 0xA5, (byte) 0xC1, 0x00}, "doc", "application/msword");
//  public static FileType EXCEL = new FileType(new byte[] {0x09, 0x08, 0x10, 0x00, 0x00, 0x06, 0x05, 0x00}, "xls", "application/excel");
  // public static FileType PPT = new FileType(new byte[] {(byte)0xFD, (byte)0xFF, (byte)0xFF,
  // (byte)0xFF, null, 0x00, 0x00, 0x00}, "ppt", "application/mspowerpoint");

//  public static FileType RTF = new FileType(new byte[] {0x7B, 0x5C, 0x72, 0x74, 0x66, 0x31}, "rtf", "application/rtf");
//  public static FileType PDF = new FileType(new byte[] {0x25, 0x50, 0x44, 0x46}, "pdf", "application/pdf");
//  public static FileType MSDOC = new FileType(new byte[] {(byte) 0xD0, (byte) 0xCF, 0x11, (byte) 0xE0, (byte) 0xA1, (byte) 0xB1, 0x1A, (byte) 0xE1}, "", "application/octet-stream");
//
//  public static FileType XML = new FileType(new byte[] {0x72, 0x73, 0x69, 0x6F, 0x6E, 0x3D, 0x22, 0x31, 0x2E, 0x30, 0x22, 0x3F, 0x3E}, "xml,xul", "text/xml");

  // GRAPHICS
  public static FileType JPEG = new FileType(new byte[] {(byte) 0xFF, (byte) 0xD8, (byte) 0xFF}, "jpg", "image/jpeg", DocFlavor.INPUT_STREAM.JPEG);
  public static FileType PNG = new FileType(new byte[] {(byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A}, "png", "image/png", DocFlavor.INPUT_STREAM.PNG);
  // public static FileType GIF = new FileType(new byte[] {0x47, 0x49, 0x46, 0x38, null, 0x61},
  // "gif", "image/gif");
  public static FileType BMP = new FileType(new byte[] {66, 77}, "bmp", "image/gif", DocFlavor.INPUT_STREAM.GIF);

  public static List<FileType> mimeTypes = new ArrayList<FileType>(Arrays.asList(MimeTypes.JPEG, MimeTypes.PNG, MimeTypes.BMP));

}
