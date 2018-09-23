package com.mixa_fed.doc_flavor.detection.exception;

/**
 * Exception that defines that the passed data has the data type that is not supported.
 * 
 * @author Michael Fedorenko
 * 
 * 23.09.2018
 */
public class DataTypeNotSupportedException extends Exception {

  /***/
  private static final long serialVersionUID = 4300543669658233631L;

  public DataTypeNotSupportedException() {
    super();
  }

  public DataTypeNotSupportedException(String message) {
    super(message);
  }

}
