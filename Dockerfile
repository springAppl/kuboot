FROM centos:7

RUN yum install -y wget;  \
    wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo; \
    yum clean all; \
    rm -rf /var/cache/yum;  \
    yum makecache;   \
    yum install -y epel-release.noarch; \
    yum install -y maven.noarch; \
    yum install -y redis;\
    yum install -y java8;\
    yum clean all;   \
    rm -rf /var/cache/yum;

COPY target/kuboot-0.0.1-SNAPSHOT.jar  .
COPY ./start.sh .
RUN ["chmod", "+x", "start.sh"]
# TODO: Set the default port for applications built using this image
EXPOSE 8080
EXPOSE 6379
# TODO: Set the default CMD for the image
CMD ./start.sh