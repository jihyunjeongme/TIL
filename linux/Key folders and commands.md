 # Key folders and commands

### `/etc`
- OS information: `cat /etc/*-release`
```bash
ubuntu@ip-10-0-1-123:/var/log$ cat /etc/*-release
DISTRIB_ID=Ubuntu
DISTRIB_RELEASE=20.04
DISTRIB_CODENAME=focal
DISTRIB_DESCRIPTION="Ubuntu 20.04.5 LTS"
NAME="Ubuntu"
VERSION="20.04.5 LTS (Focal Fossa)"
ID=ubuntu
ID_LIKE=debian
PRETTY_NAME="Ubuntu 20.04.5 LTS"
VERSION_ID="20.04"
HOME_URL="https://www.ubuntu.com/"
SUPPORT_URL="https://help.ubuntu.com/"
BUG_REPORT_URL="https://bugs.launchpad.net/ubuntu/"
PRIVACY_POLICY_URL="https://www.ubuntu.com/legal/terms-and-policies/privacy-policy"
VERSION_CODENAME=focal
UBUNTU_CODENAME=focal
```

- `cat timezone`: timezone check
```
ubuntu@ip-10-0-1-123:/etc$ cat timezone
Etc/UTC
```


### `/var` & `/var/log`
- system process's temp files, log files
- `zcat syslog.2.gz `: cat `.gz` log files.

```
buntu@ip-10-0-1-123:/var/log$ ls
alternatives.log  auth.log.1             dist-upgrade  kern.log    nginx     syslog.2.gz  syslog.6.gz                 wtmp
amazon            btmp                   dmesg         kern.log.1  private   syslog.3.gz  syslog.7.gz
apt               cloud-init-output.log  dpkg.log      landscape   syslog    syslog.4.gz  ubuntu-advantage-timer.log
auth.log          cloud-init.log         journal       lastlog     syslog.1  syslog.5.gz  unattended-upgrades
ubuntu@ip-10-0-1-123:/var/log$ zcat syslog.2.gz 
Dec 20 00:00:57 ip-10-0-1-123 systemd[1]: man-db.service: Succeeded.
Dec 20 00:00:57 ip-10-0-1-123 systemd[1]: Finished Daily man-db regeneration.
Dec 20 00:17:01 ip-10-0-1-123 CRON[262522]: (root) CMD (   cd / && run-parts --report /etc/cron.hourly)
Dec 20 00:17:38 ip-10-0-1-123 systemd[47554]: var-lib-docker-overlay2-9b48092ca3fcc673d32ed5dea04056dcf7bbd15ab1136c32ab5082f50432a47e\x2dinit-merged.mount: Succeeded.
Dec 20 00:17:38 ip-10-0-1-123 systemd[1]: var-lib-docker-overlay2-9b48092ca3fcc673d32ed5dea04056dcf7bbd15ab1136c32ab5082f50432a47e\x2dinit-merged.mount: Succeeded.
Dec 20 00:17:38 ip-10-0-1-123 systemd[1]: var-lib-docker-overlay2-9b48092ca3fcc673d32ed5dea04056dcf7bbd15ab1136c32ab5082f50432a47e-merged.mount: Succeeded.
Dec 20 00:17:38 ip-10-0-1-123 systemd[47554]: var-lib-docker-overlay2-9b48092ca3fcc673d32ed5dea04056dcf7bbd15ab1136c32ab5082f50432a47e-merged.mount: Succeeded.
```

### `find`
- `find -newerct "22 Dec 2022" -ls`: recent created
```
ubuntu@ip-10-0-1-123:/var/log$ find -newerct "22 Dec 2022" -ls
    81256      4 drwxrwxr-x  10 root     syslog       4096 Dec 22 00:00 .
    65577     12 -rw-r--r--   1 root     root         9578 Dec 22 03:09 ./ubuntu-advantage-timer.log
    71449   1156 -rw-rw----   1 root     utmp      1178880 Dec 22 09:28 ./btmp
      120     20 -rw-r-----   1 syslog   adm         18296 Dec 22 00:00 ./syslog.1
   258231   8192 -rw-r-----   1 root     systemd-journal  8388608 Dec 22 01:51 ./journal/fa8ca72f45184cef805e9e60735eb9c0/user-1000.journal
   ```
- `find -newermt "22 Dec 2022" -ls`: Files that have been changed since.

- `sudo find . -size +1M`: volume search more than bigger size
```
ubuntu@ip-10-0-1-123:/var/log$ sudo find . -size +1M
./btmp
./journal/fa8ca72f45184cef805e9e60735eb9c0/user-1000.journal
./journal/fa8ca72f45184cef805e9e60735eb9c0/system.journal
./auth.log
```

- `find . -mtime +2 -a -mtime -5 -ls`: the recent modified files between 2 and 5 days. 

```
ubuntu@ip-10-0-1-123:/var/log$ find . -mtime +2 -a -mtime -5 -ls
find: ‘./private’: Permission denied
    10523      4 -rw-r--r--   1 root     root          214 Dec 18 22:43 ./alternatives.log
    65592    828 -rw-r-----   1 syslog   adm        842065 Dec 17 23:58 ./auth.log.1
find: ‘./amazon’: Permission denied
    71450      8 -rw-rw-r--   1 root     utmp       292876 Dec 18 22:43 ./lastlog
       47      4 -rw-r-----   1 syslog   adm          1968 Dec 18 00:00 ./syslog.5.gz
   261436      0 -rw-r-----   1 www-data adm             0 Dec 18 20:43 ./nginx/error.log
      396     12 -rw-r-----   1 syslog   adm          9720 Dec 19 00:00 ./syslog.4.gz
ubuntu@ip-10-0-1-123:/var/log$ 
```

#### advanced find
- `find ./ -name "*.*" -exec grep "error" {} \; -print 2>/dev/null`: error message and file name

```bash
ubuntu@ip-10-0-1-123:/$ find / -name "*.log" -exec grep -i "error" {} \; -print 2>/dev/null
      verror "1.10.0"
  verror@1.10.0:
    resolved "https://registry.yarnpkg.com/verror/-/verror-1.10.0.tgz#3a105ca17053af55d6e270c1f8288682e18da400"
  Error: Command failed.
      at ProcessTermError.MessageError (/Users/junon/.yarn/lib/cli.js:186:110)
      at new ProcessTermError (/Users/junon/.yarn/lib/cli.js:226:113)
/home/ubuntu/.vscode-server/bin/3866c3553be8b268c8a7f8c0482c0c0177aa8bfa/extensions/ms-vscode.node-debug2/node_modules/is-arrayish/yarn-error.log
Error: Unexpected SIGPIPE
Error: Unexpected SIGPIPE
Error: Unexpected SIGPIPE
Error: Unexpected SIGPIPE
```

- `find . -size +1M -exec ls -l {} \; 2>/dev/null`: more than 1M files.
```bash
ubuntu@ip-10-0-1-123:/var/log$ find . -size +1M -exec ls -l {} \; 2>/dev/null
-rw-rw---- 1 root utmp 1178880 Dec 22 09:28 ./btmp
-rw-r-----+ 1 root systemd-journal 8388608 Dec 22 01:51 ./journal/fa8ca72f45184cef805e9e60735eb9c0/user-1000.journal
-rw-r-----+ 1 root systemd-journal 33554432 Dec 22 10:43 ./journal/fa8ca72f45184cef805e9e60735eb9c0/system.journal
-rw-r----- 1 syslog adm 1159123 Dec 22 10:43 ./auth.log
```


### `stat`
- `stat syslog`: Inode, size, modify and change date
```
ubuntu@ip-10-0-1-123:/var/log$ stat syslog
  File: syslog
  Size: 4947            Blocks: 16         IO Block: 4096   regular file
Device: ca01h/51713d    Inode: 6088        Links: 1
Access: (0640/-rw-r-----)  Uid: (  104/  syslog)   Gid: (    4/     adm)
Access: 2022-12-22 00:00:57.352729667 +0000
Modify: 2022-12-22 09:17:01.682558208 +0000
Change: 2022-12-22 09:17:01.682558208 +0000
```

  

### grep & sort

- `ls -al | sort -k 5 | awk '$5 >= 1000000 {print}'`: sort by size > 1000000
```bash  
ubuntu@ip-10-0-1-123:/var/log$ ls -al | sort -k 5 | awk '$5 >= 1000000 {print}'
-rw-r-----   1 syslog    adm             1159739 Dec 22 10:45 auth.log
-rw-rw----   1 root      utmp            1178880 Dec 22 09:28 btmp
```

### awk
- `ls -l | awk '{sum += $5} END {print sum}'`: sum total volume size.

```bash
ubuntu@ip-10-0-1-123:/var/log$ ls -l | awk '{sum += $5} END {print sum}'
3882084
```


### du
- `sudo du --max-depth=1 -h`

```
ubuntu@ip-10-0-1-123:/var/log$ sudo du --max-depth=1 -h
41M     ./journal
4.0K    ./private
84K     ./apt
40K     ./unattended-upgrades
24K     ./amazon
4.0K    ./dist-upgrade
84K     ./nginx
4.0K    ./landscape
44M     .
```



## DISK & Device
### disk check
- `sudo fdisk -l`
```
ubuntu@ip-10-0-1-123:/dev$ sudo fdisk -l
Disk /dev/loop0: 24.4 MiB, 25571328 bytes, 49944 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop2: 63.25 MiB, 66314240 bytes, 129520 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop3: 91.83 MiB, 96272384 bytes, 188032 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop4: 49.64 MiB, 52031488 bytes, 101624 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop5: 63.24 MiB, 66301952 bytes, 129496 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop6: 91.85 MiB, 96292864 bytes, 188072 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/loop7: 55.63 MiB, 58314752 bytes, 113896 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes


Disk /dev/xvda: 30 GiB, 32212254720 bytes, 62914560 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
Disklabel type: gpt
Disk identifier: DB51FDBB-2DCF-47DE-BC51-FFE19479D3D6

Device       Start      End  Sectors  Size Type
/dev/xvda1  227328 62914526 62687199 29.9G Linux filesystem
/dev/xvda14   2048    10239     8192    4M BIOS boot
/dev/xvda15  10240   227327   217088  106M EFI System

Partition table entries are not in disk order.


Disk /dev/loop8: 55.62 MiB, 58310656 bytes, 113888 sectors
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
```

- `mount | grep xvda`

```bash
ubuntu@ip-10-0-1-123:/dev$ mount | grep xvda
/dev/xvda1 on / type ext4 (rw,relatime,discard)
/dev/xvda15 on /boot/efi type vfat (rw,relatime,fmask=0077,dmask=0077,codepage=437,iocharset=iso8859-1,shortname=mixed,errors=remount-ro)
```

- `df -T` / `df -T | grep "^/dev"`: disk type, capacity, filesystem

```
ubuntu@ip-10-0-1-123:/dev$ df -T
Filesystem     Type     1K-blocks    Used Available Use% Mounted on
/dev/root      ext4      30297152 5632204  24648564  19% /
devtmpfs       devtmpfs    487872       0    487872   0% /dev
tmpfs          tmpfs       494712       0    494712   0% /dev/shm
tmpfs          tmpfs        98944     952     97992   1% /run
tmpfs          tmpfs         5120       0      5120   0% /run/lock
tmpfs          tmpfs       494712       0    494712   0% /sys/fs/cgroup
/dev/loop0     squashfs     25088   25088         0 100% /snap/amazon-ssm-agent/6312
/dev/loop4     squashfs     50816   50816         0 100% /snap/snapd/17883
/dev/loop2     squashfs     64768   64768         0 100% /snap/core20/1695
/dev/loop3     squashfs     94080   94080         0 100% /snap/lxd/23991
/dev/xvda15    vfat        106858    5313    101545   5% /boot/efi
/dev/loop5     squashfs     64768   64768         0 100% /snap/core20/1738
/dev/loop6     squashfs     94080   94080         0 100% /snap/lxd/24061
/dev/loop7     squashfs     56960   56960         0 100% /snap/core18/2654
tmpfs          tmpfs        98940       0     98940   0% /run/user/1000
/dev/loop8     squashfs     56960   56960         0 100% /snap/core18/2667
```

```
ubuntu@ip-10-0-1-123:/dev$ df -T | grep "^/dev"
/dev/root      ext4      30297152 5632204  24648564  19% /
/dev/loop0     squashfs     25088   25088         0 100% /snap/amazon-ssm-agent/6312
/dev/loop4     squashfs     50816   50816         0 100% /snap/snapd/17883
/dev/loop2     squashfs     64768   64768         0 100% /snap/core20/1695
/dev/loop3     squashfs     94080   94080         0 100% /snap/lxd/23991
/dev/xvda15    vfat        106858    5313    101545   5% /boot/efi
/dev/loop5     squashfs     64768   64768         0 100% /snap/core20/1738
/dev/loop6     squashfs     94080   94080         0 100% /snap/lxd/24061
/dev/loop7     squashfs     56960   56960         0 100% /snap/core18/2654
/dev/loop8     squashfs     56960   56960         0 100% /snap/core18/2667
```

- `lsblk`

```
ubuntu@ip-10-0-1-123:/dev$ lsblk
NAME     MAJ:MIN RM  SIZE RO TYPE MOUNTPOINT
loop0      7:0    0 24.4M  1 loop /snap/amazon-ssm-agent/6312
loop2      7:2    0 63.2M  1 loop /snap/core20/1695
loop3      7:3    0 91.8M  1 loop /snap/lxd/23991
loop4      7:4    0 49.6M  1 loop /snap/snapd/17883
loop5      7:5    0 63.2M  1 loop /snap/core20/1738
loop6      7:6    0 91.9M  1 loop /snap/lxd/24061
loop7      7:7    0 55.6M  1 loop /snap/core18/2654
loop8      7:8    0 55.6M  1 loop /snap/core18/2667
xvda     202:0    0   30G  0 disk 
├─xvda1  202:1    0 29.9G  0 part /
├─xvda14 202:14   0    4M  0 part 
└─xvda15 202:15   0  106M  0 part /boot/efi
```

- `cat /etc/fstab`: filesystem management
```
ubuntu@ip-10-0-1-123:/dev$ cat /etc/fstab
LABEL=cloudimg-rootfs   /        ext4   defaults,discard        0 1
LABEL=UEFI      /boot/efi       vfat    umask=0077      0 1
```