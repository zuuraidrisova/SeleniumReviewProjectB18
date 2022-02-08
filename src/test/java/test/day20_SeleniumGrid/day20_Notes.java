package test.day20_SeleniumGrid;

public class day20_Notes {
    /*
    Today is July 21, 2020

 Agenda: Selenium Grid

 Region: N. Virginia
 AMI name: cybertek_docker_grid

 Windows users please use git bash

Open terminal/powershell

Navigate to the folder with previously downloaded pem file

 1. ONLY For MAC, WINDOWS UESRS PLEASE DON'T RUN THIS COMMAND:

  	chmod 400 b18_key.pem

 This command makes file read only

 If you are getting error, for example: Operation is not permitted, execute command with sudo.

 	sudo chmod 400 b18_key.pem

 	Then, enter password. Password id invisible.

 2. For everyone:

Change root to ec2-user

 ssh -i "b18_key.pem" ec2-user@ec2-54-80-133-27.compute-1.amazonaws.com

after @, is your server address

cd folder name

cd .. go back to the parent folder

If it's asking you "Are you sure you want to continue?" - Enter yes, and hit Return/Enter

Navigate to downloads folder from everywhere
cd ~/Downloads

#To start selenium grid

	docker-compose up -d

#To stop

	docker-compose down

# To see list of running containers

docker container ps

http://ip_address_of_your_ec:4444/grid/console

*NOTE: make sure that port 4444 is opened. You can check on AWS console --> inbound rules

PLEASE DON'T SCALE SELENIUM GRID ON EC2 micro instance!


############################

Selenium Grid - tool for remote test execution. It allows to run tests on multiple servers
 at the same time. Also, it provides cross platform and cross browser testing capabilities.

Selenium Grid has 2 components: hub and node.

In the grid, there should only one hub and one or more nodes.

Hub and nodes can be located on the different servers.

Since Selenium Grid it's a java program, it requires to install JDK, browsers and web drivers.

Why do we need a docker here?

Docker is used to run containers. Container it's a lightweight VM that is running your program.
 Container has all required dependencies to run that program. For example: container for hub
  is based on linux OS and has JDK and selenium standalone jar file (for Selenium Grid file).
   Container for node has linux OS, JDK, chrome/firefox browser and selenium standalone jar
   file (for Selenium Grid file).

Docker allows quickly scale selenium grid infrastructure.

docker-compose scale chrome=10

This command will create 10 containers with chrome based selenium grid nodes.

To run tests, we need to use RemoteWebdriver class and provide URL of selenium grid hub and
desired capabilities(chrome or firefox options).

Selenium Grid allows us to reduce test execution time. Regression suite must be executed asap
 and our laptop performance is not enough for this. That's why, we need to use a server,
  that we rent on AWS.

     */
}
