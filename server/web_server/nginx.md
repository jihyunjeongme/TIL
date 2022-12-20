# NGINX

## System environment
- OS: `Ubuntu 20.04.5 LTS`

## Install
1. installation
    ```bash
    sudo apt update -y
    sudo apt upgrade -y
    sudo apt autoremove -y sudo apt install nginx -y
    ```

2. version check
    - `nginx -v`
      - `nginx version: nginx/1.18.0 (Ubuntu)`

3. check LISTEN
   - `sudo ss -tulpn | grep LISTEN`
     - `tcp    LISTEN  0        511                0.0.0.0:80             0.0.0.0:*      users:(("nginx",pid=49297,fd=6),("nginx",pid=49296,fd=6))      `

4. check process
   - `ps -ax | grep nginx`: 
    ```
        49296 ?        Ss     0:00 nginx: master process /usr/sbin/nginx -g daemon on; master_process on;
        49297 ?        S      0:00 nginx: worker process
    ```
   - `ps -ef --forest | grep nginx`: PID parent/child
    ```
    root       49296       1  0 20:43 ?        00:00:00 nginx: master process /usr/sbin/nginx -g daemon on; master_process on;www-data   49297   49296  0 20:43 ?        00:00:00  \_ nginx: worker process
    ```

## Configuration
- default: `/etc/nginx/nginx.conf`
- configuration set: `/etc/nginx/conf.d`
  - `XXX.d` is a group of configuration files and directory.

- configure a conf file: `sudo nginx -c $your_file_location`

### Validation
- `sudo nginx -t`
  ```
  nginx: the configuration file /etc/nginx/nginx.conf syntax is ok
  nginx: configuration file /etc/nginx/nginx.conf test is successful
  ```