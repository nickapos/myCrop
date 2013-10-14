#!/bin/bash
INSTALLDIR="/home/nickapos/keimena/mycrop"
CLASSPATH="$INSTALLDIR/lib"
cd $INSTALLDIR
/opt/jdk6//bin/java -cp $CLASSPATH -jar myCrop.jar&
