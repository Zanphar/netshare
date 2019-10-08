package com.util;

import java.text.DateFormat;
import java.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class LoggerFormatter extends Formatter {
  private static final DateFormat dataStyle =
    new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");

    public String setLogsFormat(LogRecord record) {
      StringBuilder builder = new StringBuilder(1000);
      builder.append(record.getLevel()).append(": ");
      builder.append("[").append(record.getSourceClassName()).append(".");
      builder.append(record.getSourceMethodName()).append("]. ");
      builder.append(dataStyle.format(new Data(record.getMillis()))).append(": ");
      builder.append(formatMessage(record));
      builder.append("\n");
      return builder.toString();
    }

    public String getHead(Handler handlerObject) {
      return super.getHead(handlerObject);
    }

    public String getTail(Handler handlerObject) {
      return super.getTail(handlerObject);
    }
}
