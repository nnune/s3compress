package com.example.snappycompressstreams3.compression;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.xerial.snappy.Snappy;
import org.xerial.snappy.SnappyInputStream;
import org.xerial.snappy.SnappyOutputStream;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CCSnappy {
    @SneakyThrows
    public static void compress(InputStream uncompressedInputStream, OutputStream compressedOutputStream){
        SnappyOutputStream snappyOutputStream = new SnappyOutputStream(compressedOutputStream);
        IOUtils.copy(uncompressedInputStream, snappyOutputStream);
    }
    @SneakyThrows
    public static void compressByteArray(InputStream inputStream, OutputStream outputStream){
        byte[] input = inputStream.readAllBytes();
        byte[] output = Snappy.compress(input);
        IOUtils.copy(new ByteArrayInputStream(output), outputStream);
    }

}
