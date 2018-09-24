# Lesson 1

## Introduction

Hadoop is a open source framework. The main task of Hadoop is the realize distributed computations. All information about hadoop is in the web site https://hadoop.apache.org/

The note about the first lesson of cours is in the Lesson_1.java

## Install and Test Hadoop in linux

Download bin from  [https://hadoop.apache.org/releases.html](here.)
FIND java path:
  >$ which java
  > _/usr/bin/java_
  >$ ls -al /usr/bin/java
  > _lrwxrwxrwx 1 root root 46 mars  18  2018 /etc/alternatives/java -> /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java_
  >$ ls -al ls -al /etc/alternatives/java
  > _lrwxrwxrwx 1 root root 46 mars  18  2018 /etc/alternatives/java -> /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java_

ADD in $JAVA_HOME the link until jre.
  >$ export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/jre/
ADD $HADOOP_HOME from the location folder where is your hadoop bin.
  >$ export HADOOP_HOME=/home/aaron/Documents/HadoopFormation/hadoop-3.1.1/
ADD PATH to find all bin hadoop.
  >$ export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
TEST whether haddop is installed.
  >$ hadoop version
  >  _Hadoop 3.1.1_
  >  _Source code repository https://github.com/apache/hadoop -r 2b9a8c1d3a2caf1e733d57f346af3ff0d5ba529c_
  >  _Compiled by leftnoteasy on 2018-08-02T04:26Z_
  >  _Compiled with protoc 2.5.0_
  >  _From source with checksum f76ac55e5b5ff0382a9f7df36a3ca5a0_
  >  _This command was run using /home/aaron/Documents/HadoopFormation/hadoop-3.1.1/share/hadoop/common/hadoop-common-3.1.1.jar_

To avoid to do that every time we open a terminal in linux. Add all export in the last lines of the file .bashrc in your main folder (/home/<user>/.bashrc)

###Example
  >$ hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-3.1.1.jar wordcount Readme.txt output

The rest of lesson is in the Java src. 
