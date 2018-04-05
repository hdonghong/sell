package pers.hdh.sell.utils.serializer;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Date2LongSerializer class<br/>
 * 转换日期格式类
 * @author hdonghong
 * @date 2018/04/04
 */
public class Date2LongSerializer extends JsonSerializer<Date> {

    /**
     * 将日期的时间戳单位毫秒转换成秒
     * @param date
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeNumber(date.getTime() / 1000);
    }
}
