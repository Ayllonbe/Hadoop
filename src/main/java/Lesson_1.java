
public class Lesson_1 {
	/*
	 * Formation Hadoop Lundi matin
	 * 
	 * On va faire une program HAD-DEV
	 * 
	 * Basée sur la technologie Map-Reduce. 
	 * 
	 * Formation bassée aussi sur la développement.
	 * 
	 * ## Introduction
	 * 
	 * Hadoop, open source ("https://hadoop.apache.org/")
	 * 
	 * serve a faire de calculs distribué
	 * 
	 * Pouvoir calculer de données de grand volumes que on peut pas
	 * stocker dans une machin.
	 * 
	 *  Hadoop c'est un framework qui permet de faire de calculs sur ce
	 *  type de donnée de grand dimension et volume.
	 *  
	 * Map Reduce est simple pour utiliser.
	 * 
	 * En hadoop permet avoir une structure que en ajoutant de machine 
	 * le processus est plus rapide (sans changer le code).
	 * 
	 * Particularité : Il faut decouper le taches pour le machine et donner
	 * un code, c'est très couteux. Mais hadoop donne une mecanisme pour 
	 * amelirer ce problemtique. 
	 * 
	 * Peuve avoir de gros machine très couteaux et ça coute de l'argnet au
	 * entreprises.
	 * 
	 * Il faut prend en consideration quand on fait un architecture de calcul
	 * que machine tombe et que il faut donner la tache a une autre ordinateru
	 * 
	 * Hadoop permet gerer cet redondance inconsistance....
	 * 
	 * 
	 * Papier à lire :
	 * 
	 * Google File System (2003) et MapReduce: Simplified data processing on
	 * large clusters (2004). 
	 * 
	 * ** Lucene c'est un moteur de recherche. Pour de document en local. 
	 * ** Nutch web proler, telecharger de page web choisir et permet avoir une
	 * ** moteur de recherche.
	 * 
	 * Hadoop c'est fait vers 2006/2007
	 * 
	 * vers 2009/2010 : first version
	 * 
	 * 2013 nouvelle techno sur Haddop: YARN - Modele de traitement de donée
	 * 
	 * De hadoop 2 à hadoop 3 c'est plutôt amelioration des performance.
	 * 
	 * Hadoop va : 
	 * 
	 * 	Lire de volume masive de donée en parallele.
	 * 
	 * Pour des données qui tiens sur un ordi, ça vaut pas le coup faire
	 * de Hadoop.
	 * 
	 * On parle de petabyte des données
	 * 
	 * Rêquette batch: rêquete que prend trop de temps et que c'est
	 * pas immediat il font un dossier et une fois finis on regarde.
	 * 
	 * 
	 * 4 techno de Hadoop que constitue la basse: 
	 * 
	 * Hadoop Common - ensemble lib pour la gestion de entre/sorti et sur la 
	 * notion de donnée distribué
	 * HDFS - system de fichier distribué
	 * YARN - Cluster resource management system permettant a n'impoirte que programme distribué
	 * Permet de gerer la location de resource.
	 * MapReduce - Modele d'application sur un cluster Hadoop
	 * 
	 * # ecosysteme hadoop (le Zoo)
	 * 
	 * C'est tous les technos dans Hadoop.
	 * 
	 * Un job c'est un programme qui fait de calcul distribué.
	 * 
	 * Oozie c'est une techno qui construit un workflow en langage XML.
	 * 		Il aura un sucessor -> AirFlow.
	 * 
	 * Squoop fait de SQL (datastore structurés) to Hadoop.
	 * 
	 * Marmota avec triplestore. (blazegraph aussi).
	 * 
	 * 
	 * SPARK c'est un de principaux traiteur d'utilisation d'hadoop
	 * 
	 * KAFKA plataforme de streaming distribué (flux des donnée en continue). Et kafka permet
	 * consomer les données qui viens en flux (en temps réel). En terme de fiabilité et d'echelle
	 * c'est le mieux. Plus directe que SPARK. On peut faire de MAchine learning en temps reels.
	 * 
	 * Regarder Cassandra (Base de donées noSQL)
	 * Beaucoup plus rapide que le base de donnée SQL (Regarder-interessant)
	 * 
	 * Apache Sentry permet gerer qui a le droight a utiliser sur un cluster donner
	 * 
	 * 
	 * Mieux specialiste Hadoop : Cloudera, Hortonworks, MapR,...
	 * 
	 * Install Hadoop
	 * Download bin from:  https://hadoop.apache.org/releases.html
	 * FIND java path:
	 *  > which java
	 *    res: /usr/bin/java
	 *  > ls -al /usr/bin/java
	 *    res: lrwxrwxrwx 1 root root 46 mars  18  2018 /etc/alternatives/java -> /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java
	 *  > ls -al ls -al /etc/alternatives/java
	 *    res: lrwxrwxrwx 1 root root 46 mars  18  2018 /etc/alternatives/java -> /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java
	 *ADD in $JAVA_HOME the link until jre.
	 *  > export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/jre/
	 *ADD $HADOOP_HOME from the location folder where is your hadoop bin.
	 *  > export HADOOP_HOME=/home/aaron/Documents/HadoopFormation/hadoop-3.1.1/
	 *ADD PATH to find all bin hadoop.
	 *  > export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
	 * TEST whether haddop is installed.
	 *  > hadoop version
	 *    res: Hadoop 3.1.1
	 *         Source code repository https://github.com/apache/hadoop -r 2b9a8c1d3a2caf1e733d57f346af3ff0d5ba529c
	 *         Compiled by leftnoteasy on 2018-08-02T04:26Z
	 *         Compiled with protoc 2.5.0
	 *         From source with checksum f76ac55e5b5ff0382a9f7df36a3ca5a0
	 *         This command was run using /home/aaron/Documents/HadoopFormation/hadoop-3.1.1/share/hadoop/common/hadoop-common-3.1.1.jar
	 * 
	 *Example
	 * 
	 * > hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-3.1.1.jar wordcount Readme.txt output
	 *  
	 *
	 *## MAPReduce
	 *
	 * on veut paralleliser de gros volumes des données.
	 * 
	 * Tout c'est pas adapté a une application map reduce.
	 * 
	 * L'idée c'est reduire de façon linear la tâche quand on applique des machine
	 *  job: unité de travail que le clien veut realiser.
	 *  
	 *  deux type de tach
	 *   
	 *   tache map et tache reduce
	 *   
	 *  ce sont de tache planifiés
	 *  
	 *  MR utilise un format de donnée key:value.
	 *  
	 *  Si on peux pas adapter notre valeur, ça c'est pas applicable pour un MR app
	 *  
	 *  C'est a nous de definir quoi faire en Map et en Reduce.
	 *  
	 *  Pour chaque entree on va produir 0,n sorti, le reduce on va avoir une 
	 *  fonction qui prend de couple k,v et sort aussi un k,v. le key c'est un truc simple
	 *  string ou numerique et le valeur un collection.
	 *  
	 *  
	 *  Class qui s'appel job. on la cree pas (fourni pour MR)
	 *  Deux method SetMapper et SetReduce
	 *  Autre deux class: Mapper et Reduce
	 *  Object Context (donné par Hadoop) pour creer les instance dans le map.
	 *  
	 * Il faut creer deux class static : un pou set mapper et autre pour set reduce.
	 *
	 */
public static void main(String[] args) {
	
}
}
