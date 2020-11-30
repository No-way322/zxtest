FROM java:8
#维护者信息
MAINTAINER zx <zzzx>
VOLUME /tmp
ADD ./target/zxtest-0.0.1-SNAPSHOT.jar app.jar
# 指定容器时区:东八区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN bash -c 'touch /app.jar'
EXPOSE 8085
ENTRYPOINT ["java","-jar","app.jar"]