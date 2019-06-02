#!/bin/bash
git checkout --orphan new_branch
git add -A
git commit -am "init"
git branch -D master
git branch -m master
git push -f origin master
