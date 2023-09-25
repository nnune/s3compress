package com.example.snappycompressstreams3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "{bucket}/{key}")
public class compressS3 {

    @PostMapping("compress-streaming")
    public ResponseEntity<String> uploadStreamingS3(@PathVariable String bucket,
                                                    @PathVariable String key,
                                                    @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
                                                    HttpRequest httpRequest
                                                    ){

        return null;
    }
    @PostMapping("compress")
    public ResponseEntity<String> uploadNonStreamingS3(@PathVariable String bucket,
                                                    @PathVariable String key,
                                                    @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
                                                    HttpRequest httpRequest
    ){

        return null;
    }
    @PostMapping
    public ResponseEntity<String> uploadNocompressionS3(@PathVariable String bucket,
                                                    @PathVariable String key,
                                                    @RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
                                                    HttpRequest httpRequest
    ){

        return null;
    }
    @GetMapping
    public ResponseEntity<String> getStreamingS3(@PathVariable String bucket,
                                                    @PathVariable String key
    ){

        return null;
    }
}
