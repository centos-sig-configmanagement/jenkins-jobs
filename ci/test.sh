#!/bin/bash -xe

source venv/bin/activate

jenkins-jobs --version

jenkins-jobs test -r jobs/
