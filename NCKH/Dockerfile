# Sử dụng một image base với Java 8 (OpenJDK 8)
FROM openjdk:8-jre

# Thêm các lệnh khác cần thiết cho việc xây dựng hình ảnh của bạn ở đây
# Ví dụ: Sao chép tệp JAR của ứng dụng vào container
COPY target/post-api-0.0.1.2-SNAPSHOOT.jar /post-api/post-api.jar

WORKDIR /post-api
# Câu lệnh CMD để chạy ứng dụng Java khi container được khởi động
CMD ["java", "-jar", "post-api.jar"]