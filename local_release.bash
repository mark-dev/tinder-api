#!/usr/bin/env bash

(mvn package) && (cp ./target/*jar-with-dependencies.jar /home/mark/code/opensource/gotinder/libs)