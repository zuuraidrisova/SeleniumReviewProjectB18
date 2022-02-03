package test.day18_day19_CICD_GitGithub;

public class day18_19Notes {
    /*
    Today is July 20, 2020

 Agenda: git conflicts and branches

 	- what is conflict?
 	- how to resolve conflict in git?
 	- stashing
 	- what is branch?
 	- create, delete, rename branch
 	- pull request
 	- git flow in my team

##########################################################################


	git is VCS (Version Control System)

	the main idea of git is to track changes

	snapshot of changes is called commit

	every commit must have a commit message

	commit message must explain what was changed in the code



git vs github

 - git it's a VCS, local repository
 - github - facebook for developers, hosting for git projects, remote repository

 github alternatives: Bitbucket, Gitlab, etc..


how do we work with git repository?

Q: When I will go to work, am I gonna create github repo?

  - no. If project already exists, you would need just need to clone it. If it's a brand new project, there is gonna be some admin, who creates accounts, repositories, etc..

Q: How to clone and what to clone?

  - you are making clone to get a copy of the repo. Everyone works on their own copy of repo.


in terminal: git clone <GIT_REPO_URL>

in intellij: new --> project from version control --> select git and provide repo URL


Q: How to create a repository?


local repository - repository on your computer

remote repository - repository on the server (github)


to create local repository:

 git init

this command should be executed only once, to initialize git repository on ur local computer. Make sure that you run this command in the project folder.


Q: How do I know that I am in the project folder?

execute pwd in the terminal: pwd (print work directory)

Also, use command ls to see list of file in the current directory.

If you want to see all files, including hidden files:

ls -a     | list all files

.git folder - this is a local repo folder.

windows users, use gitbash.

Here is the equivalent of unix commands in windows:


Windows: cd
Mac pwd

Windows: dir
Mac: ls -a


Please create a new project.

Name of the project/artifact ID: spring-2020-git-practice

everything else is default


First thing that you have to do is to create a .gitignore file


Every company has a template for .gitignore

to create it, right click on project name --> new --> file --> .gitignore

NOTE: close the file once you are done with listing.


Put this into the file:


.idea
target
*.iml
*.log


first 3 are must, we haven't met log files yet, I will show you tomorrow what is that.

git init - to create new local repo

git status - to see what's new in this repo



THE FLOW:

Step 1.


new files ---> git add (to stage files, will prepare files for commit)


To remove files/folders from the staging area:


git rm --cached <file_name/folder_path>


red: untracked by git
green: tracked by git
black:  ignored by git (listed in .gitignore file) or committed.


If git status, gives you error, you don't have git repo, local repo.



Step 2. Commit changes

  git commit -m "this is a commit message"

  - commit message, contains short descriptions of changes and/or associated jira issue number.


git commit -m "@VIT-1231 User should be able to edit event's end time"


use git log ==>  to see the history of commits.


commit de7e470942bb52a5d3faa7ff9dfaa47cad43cbcb (HEAD -> master)
Author: Vasyl Fomiuk <vasyl@cybertekschool.com>
Date:   Mon Jul 20 11:40:50 2020 -0400

    first commit



every commit has a commit hash. It's a commit id.


Step 2.5 Create README.md file to provide instructions for your project.


NOTE: by default, you might not have markdown plugin, so please install it whenever intellij is offering.


Step 3. We need to create remote repo for this project.


commit#1	-------> 	commit#2

pom.xml file            README.md
.giitnore

first commit           second commit


fatal: not a git repository (or any of the parent directories): .git ?

 Run git init



STEPS:

git init
git add .
git commit -m "message"

//some changes in the project

git add .
git commit -m "message"

//some changes in the project

git add .
git commit -m "message"

//some changes in the project

git add .
git commit -m "message"


git log


commit 04bcdb208564039e80c68ae2ec1f4758cd98646a (HEAD -> master)
Author: Vasyl Fomiuk <vasyl@cybertekschool.com>
Date:   Mon Jul 20 11:56:54 2020 -0400

    added readme.md file

commit de7e470942bb52a5d3faa7ff9dfaa47cad43cbcb
Author: Vasyl Fomiuk <vasyl@cybertekschool.com>
Date:   Mon Jul 20 11:40:50 2020 -0400

    first commit

Every commit will b e reflected in the log.


If it opened editor, enter

:q! and hit enter

IF YOU NEED TO DELETE.

For mac: rm -rf .git ==> it deletes git repository
For windows: del .git / deltree .git



git status - to check if repo is created

You can also delete this folder via file explorer, but make sure to make hidden files visible:

for mac: command + shift + .

for windows:

Open File Explorer from the taskbar.
Select View > Options > Change folder and search options.
Select the View tab and, in Advanced settings, select Show hidden files, folders, and drives and OK.


https://support.microsoft.com/en-us/help/4028316/windows-view-hidden-files-and-folders-in-windows-10

1. Folder that you see in intellij
2. This is an area where files are getting prepared for commit
3. once you commit, updates are going to local repo
4. once you push, updates are going to github


	1. 					2. 				3. 				4.
work directory --->                   staging area -->                   local repo --->                  remote repo


if you are getting 403 error, it means that you can see repo but you are not allowed to commit there.


Why it happens? because username that is used on your computer is different from remote repo account.


To setup github credentials:

git config --global user.name "Your Name"
git config --global user.email "youremail@yourdomain.com"
git config --global user.password "github password"


Q: How often do we commit?

	- usually, at the end of work day. It's very bad practice to commit once a week or once in 2 weeks.


To get updates

 git pull


To add everything and commit:

git commit -a -m "commit message"  is the same as git add . & git commit


git fetch - pull updates from remote to local repo
git merge - to merge local repo and work directory

git pull (fetch + merge)


Whenever you have a conflict, follow these steps:

Step 1. git pull

Step 2.
     */
}
