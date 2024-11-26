package me.allenwilson.receiptprocessor.processor;

class ReceiptProcessingException extends RuntimeException {

    ReceiptProcessingException(String message) {
        super(message);
    }

    ReceiptProcessingException(String message, Exception exception) {
        super(message, exception);
    }
}
