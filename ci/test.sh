#!/bin/bash -xe

jenkins-jobs --version

jenkins-jobs test -r .
