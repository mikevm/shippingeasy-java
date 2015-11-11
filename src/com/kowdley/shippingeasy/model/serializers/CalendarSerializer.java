package com.kowdley.shippingeasy.model.serializers;

import com.google.gson.*;
import com.google.gson.stream.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.reflect.Type;

public class CalendarSerializer implements JsonSerializer<Calendar> {
  private static final String SHIPPINGEASY_DATE_FORMAT =
      "yyyy-MM-dd HH:mm:ss Z";

  public JsonElement serialize(Calendar src, Type type,
      JsonSerializationContext context) {
    if (src == null) {
      return null;
    } else {
      SimpleDateFormat format = new SimpleDateFormat(SHIPPINGEASY_DATE_FORMAT);
      return new JsonPrimitive(format.format(src.getTime()));
    }
  }
}
