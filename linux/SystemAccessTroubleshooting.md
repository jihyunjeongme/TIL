# System Access Troubleshooting

## Server is Not Reachable
### Ping the destination `server name`


```bash
ubuntu@ip-10-0-1-123:~$ ping google.com
PING google.com (172.217.175.238) 56(84) bytes of data.
64 bytes from nrt12s29-in-f14.1e100.net (172.217.175.238): icmp_seq=1 ttl=105 time=32.2 ms
64 bytes from nrt12s29-in-f14.1e100.net (172.217.175.238): icmp_seq=2 ttl=105 time=32.2 ms
64 bytes from nrt12s29-in-f14.1e100.net (172.217.175.238): icmp_seq=3 ttl=105 time=32.2 ms
^C
--- google.com ping statistics ---
3 packets transmitted, 3 received, 0% packet loss, time 2003ms
rtt min/avg/max/mdev = 32.157/32.184/32.220/0.026 ms
```

#### If server name is NOT pingable
```bash
ubuntu@ip-10-0-1-123:~$ ping google.kk
ping: google.kk: Name or service not known
```


### Ping the destination server by `IP` 


   
```bash
ubuntu@ip-10-0-1-123:~$ nslookup google.com
Server:         127.0.0.53
Address:        127.0.0.53#53

Non-authoritative answer:
Name:   google.com
Address: 172.217.175.238
Name:   google.com
Address: 2404:6800:4004:824::200e
```

#### If `IP` is pingable = Name resolution issue
```bash
ubuntu@ip-10-0-1-123:~$ nslookup google.kk
Server:         127.0.0.53
Address:        127.0.0.53#53

** server can't find google.kk: NXDOMAIN
```

##### Check `/etc/hosts` file
```bash
ubuntu@ip-10-0-1-123:~$ cat /etc/hosts
127.0.0.1 localhost

# The following lines are desirable for IPv6 capable hosts
::1 ip6-localhost ip6-loopback
fe00::0 ip6-localnet
ff00::0 ip6-mcastprefix
ff02::1 ip6-allnodes
ff02::2 ip6-allrouters
ff02::3 ip6-allhosts
ubuntu@ip-10-0-1-123:~$ ping localhost
PING localhost (127.0.0.1) 56(84) bytes of data.
64 bytes from localhost (127.0.0.1): icmp_seq=1 ttl=64 time=0.030 ms
64 bytes from localhost (127.0.0.1): icmp_seq=2 ttl=64 time=0.025 ms
64 bytes from localhost (127.0.0.1): icmp_seq=3 ttl=64 time=0.024 ms
^C
--- localhost ping statistics ---
3 packets transmitted, 3 received, 0% packet loss, time 2043ms
rtt min/avg/max/mdev = 0.024/0.026/0.030/0.002 ms
```

##### Check `/etc/resolv.conf`
```bash
ubuntu@ip-10-0-1-123:~$ cat /etc/resolv.conf 

nameserver 127.0.0.53
options edns0 trust-ad
search ap-northeast-2.compute.internal
```

##### Check `/etc/nsswitch.conf`

```bash
ubuntu@ip-10-0-1-123:~$ cat /etc/nsswitch.conf 
# /etc/nsswitch.conf
#
# Example configuration of GNU Name Service Switch functionality.
# If you have the `glibc-doc-reference' and `info' packages installed, try:
# `info libc "Name Service Switch"' for information about this file.

passwd:         files systemd
group:          files systemd
shadow:         files
gshadow:        files

hosts:          files dns
networks:       files

protocols:      db files
services:       db files
ethers:         db files
rpc:            db files

netgroup:       nis
```

#### If `IP` is NOT pingable
##### Ping another server by name and then by `IP`

##### Checking if your server has an IP address
- `inet 172.18.0.1`
```bash
ubuntu@ip-10-0-1-123:~$ ifconfig
br-61637d787645: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 172.18.0.1  netmask 255.255.0.0  broadcast 172.18.255.255
        inet6 fe80::42:4bff:fe8b:889  prefixlen 64  scopeid 0x20<link>
        ether 02:42:4b:8b:08:89  txqueuelen 0  (Ethernet)
        RX packets 721675  bytes 77663718 (77.6 MB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 626131  bytes 427887623 (427.8 MB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
```

##### Ping your gateway/modem IP
```bash
buntu@ip-10-0-1-123:~$ netstat -rnv
Kernel IP routing table
Destination     Gateway         Genmask         Flags   MSS Window  irtt Iface
0.0.0.0         10.0.1.1        0.0.0.0         UG        0 0          0 eth0
10.0.1.0        0.0.0.0         255.255.255.0   U         0 0          0 eth0
10.0.1.1        0.0.0.0         255.255.255.255 UH        0 0          0 eth0
172.17.0.0      0.0.0.0         255.255.0.0     U         0 0          0 docker0
172.18.0.0      0.0.0.0         255.255.0.0     U         0 0          0 br-61637d787645

ubuntu@ip-10-0-1-123:~$ ping 10.0.1.1
PING 10.0.1.1 (10.0.1.1) 56(84) bytes of data.
64 bytes from 10.0.1.1: icmp_seq=1 ttl=255 time=0.332 ms
64 bytes from 10.0.1.1: icmp_seq=2 ttl=255 time=0.294 ms
64 bytes from 10.0.1.1: icmp_seq=3 ttl=255 time=0.260 ms
^C
--- 10.0.1.1 ping statistics ---
3 packets transmitted, 3 received, 0% packet loss, time 2016ms
rtt min/avg/max/mdev = 0.260/0.295/0.332/0.029 ms
```

##### Check physical cable connection(On-prem)
---
## Cannot Connect to a Website or an Application

### Troubleshooting Steps
1. Ping server by `hostname` and `IP`
```bash
ubuntu@ip-10-0-1-123:~$ nslookup www.google.com
Server:         127.0.0.53
Address:        127.0.0.53#53

Non-authoritative answer:
Name:   www.google.com
Address: 142.251.42.196
Name:   www.google.com
Address: 2404:6800:4004:827::2004

ubuntu@ip-10-0-1-123:~$ ping 142.251.42.196
PING 142.251.42.196 (142.251.42.196) 56(84) bytes of data.
64 bytes from 142.251.42.196: icmp_seq=1 ttl=46 time=32.4 ms
64 bytes from 142.251.42.196: icmp_seq=2 ttl=46 time=32.4 ms
64 bytes from 142.251.42.196: icmp_seq=3 ttl=46 time=32.3 ms
^C
--- 142.251.42.196 ping statistics ---
3 packets transmitted, 3 received, 0% packet loss, time 2003ms
rtt min/avg/max/mdev = 32.348/32.373/32.392/0.018 ms
```
- If NOT pingable = go back to "Server Not Reachable"

2. If pingable = Connect to server 
- telnet 142.251.42.196 80
- If telnet command not found `install telnet`.

```bash
ubuntu@ip-10-0-1-123:~$ telnet 142.251.42.196 80
Trying 142.251.42.196...
Connected to 142.251.42.196.
Escape character is '^]'.
```
- If `Conneted` = the target Server is running.
- Login to the server and start the service (http/ssh) -> check `ps -ef | grep ssh`

```bash
ubuntu@ip-10-0-1-123:~$ ps -ef | grep ssh
root         754       1  0 Dec13 ?        00:00:03 sshd: /usr/sbin/sshd -D -o AuthorizedKeysCommand /usr/share/ec2-instance-connect/eic_run_authorized_keys %u %f -o AuthorizedKeysCommandUser ec2-instance-connect [listener] 0 of 10-100 startups
root      264058     754  0 02:28 ?        00:00:00 sshd: ubuntu [priv]
ubuntu    264131  264058  0 02:28 ?        00:00:07 sshd: ubuntu@notty
ubuntu    267052  265754  0 10:52 pts/2    00:00:00 grep --color=auto ssh
```
---
## Firewall

### Connetion refused 
- Check `Firewall`
  - CentOS: `systemctl status firewalld`
  <img src="https://phoenixnap.com/kb/wp-content/uploads/2021/04/active-firewalld-centos7.png">
  
  - Ubuntu: `sudo ufw status verbose`
  <img src="https://storage.googleapis.com/static.configserverfirewall.com/images/ufw/status/ufw-status-verbose.png">
  
  - `sudo ufw status numbered`
  
  - `sudo ufw status | grep -i deny`
  <img src="https://storage.googleapis.com/static.configserverfirewall.com/images/ufw/status/statust-deny.png">