package me.allenwilson.receiptprocessor.shared;


import java.util.List;


public record ErrorResponse(
    String message,
    List<String> detail
) {}
