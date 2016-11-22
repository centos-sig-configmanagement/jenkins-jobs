#!/bin/bash -xe

jenkins-jobs --version

rm output/* || true

jenkins-jobs test -r . -o output

diff <(ls output/|sort) test/jobslist
