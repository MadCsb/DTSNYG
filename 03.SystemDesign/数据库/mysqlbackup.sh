#!/bin/sh 
source /etc/profile

#define mysql variables.if not install mysqldump :  yum -y install holland-mysqldump.noarch
#vi /etc/crontab 23 59 * * 0 root /snyg_back/mysqlbackup.sh
db_user=""
db_passwd=""
db_host=""
db_port=""

#the real databases which you want to backup.
db_array=("")
#the dir for saving your backup file.
backup_dir="/snyg_back"
if [ ! -d  $backup_dir ];then
	mkdir -p $backup_dir
fi 
#date format for the backup file (yyyy-mm-dd) 
time=`date +"%Y-%m-%d"`
#the mysql,mysqldump and other bin's path
MYSQL_COMMDAND="/usr/bin/mysql"
MYSQLDUMP_COMMAND="/usr/bin/mysqldump"
MKDIR_COMMAND="/usr/bin/mkdir"
RM_COMMAND="/usr/bin/rm"
MV_COMMAND="/usr/bin/mv"
GZIP_COMMAND="/usr/bin/gzip"


# check the dir for saving backup file is writeable or not.
if [ ! -w  $backup_dir ];then

	echo "Error: $backup_dir is un-writeable." && exit 0 

fi

#check if the dir for saving the backup file exists or not.
if [ ! -d  ${backup_dir}/backup.0 ];then

	$MKDIR_COMMAND  -p "$backup_dir/backup.0"

fi

#starting to backup.

for db_name in ${db_array[*]}
do
	$MYSQLDUMP_COMMAND -P$db_port -u$db_user -h$db_host -p$db_passwd -B  $db_name | $GZIP_COMMAND -9 > "$backup_dir/backup.0/$time.$db_name.gz" 
done

# delete the oldest backup 
if [ -d "$backup_dir/backup.13" ];then

	$RM_COMMAND -rf "$backup_dir/backup.13" 

fi


# rotate backup directory 

#for int in 12 .. 6 5 4 3 2 1 0 
for int in {12..0}
do 
	if [ -d "$backup_dir"/backup."$int" ];then
		next_int=`expr  $int  + 1` 
		$MV_COMMAND "$backup_dir"/backup."$int" "$backup_dir"/backup."$next_int" 
	fi
done 
	
exit 0;
