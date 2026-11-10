# Dùng JDK 21 bản nhẹ của Amazon
FROM amazoncorretto:21-alpine
# Tạo thư mục làm việc trong container
WORKDIR /app
# Copy file JAR từ thư mục out của IntelliJ vào container
# ĐỔI TÊN: Thay "football_player_management_jar" và "football_player_management.jar" bằng tên thật của bạn
COPY out/artifacts/football_player_management_jar/football_player_management.jar /app/football_player_management.jar
# Lệnh chạy ứng dụng khi container khởi động
ENTRYPOINT ["java", "-jar", "/app/football_player_management.jar"]
