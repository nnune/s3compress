# Test compressing files and uploading and download from S3. 

* Support for streaming upload and download
* Compressing and un compressing without loading everything into memory. So, should operate on streams
* Ability to stream files commpressed using Snappy.compress - backward compatibility
* Measure performance
* Support for multipart uploads
  * Upload multi part upload
  * Compress on the fly
  * Upload to S3 using multipart upload
* Measure performance
  * Memory usage