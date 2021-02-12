# Exercise 1: Setting Up


The goal of the first exercise is to verify that everyone has a working setup and that submitting and testing the exercises works properly.

## Step 1
Please register on GitHub and send an e-mail with your username to `nils.reiter@uni-koeln.de`. I will then add your account to the GitHub organization "idh-cologne-machine-learning-mit-java", which is the umbrella for all future exercises.

## Step 2
Once your GitHub account has been added to the group, please `clone` the repository `https://github.com/idh-cologne-machine-learning-mit-java/exercise-01` (if you're reading this text online, it's the repository you're looking at right now).

On the command line: `git clone https://github.com/idh-cologne-machine-learning-mit-java/exercise-01.git`

## Step 3
Create a new branch, named after your UzK-account (because they should be unique in our group ...). In my case, I'd choose "nreiter2".

On the command line: `git checkout -b BRANCHNAME`

## Step 4
Open the file `main.java` and fix all the errors that a poor programming beginner has made. Don't forget to save the file. Verify that it compiles properly and does what it's supposed to do.

The beginner's intent was to write a program that prints a variable cumulatively multiplied with increasing integers. I.e., the intended output was:
```
1 15
2 30
3 90
4 360
...
```

## Step 5
Add the file to the staging area.

On the command line: `git add main.java`

## Step 6
Commit the file to your branch in your local repository, and provide a commit message.

Command line: `git commit -m "Done with the exercise"`

## Step 7 
Push your branch to the server. Because this is the first time you're pushing, the server doesn't know about your branch, which is why have to state that the upstream branch (= the one on the server) should have the same name.

Command line: `git push --set-upstream origin BRANCHNAME`

