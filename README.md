# <span style="color:#73130d">OTP project</span>

### Workflow Documentation

I will write my work steps in the following section:

<span style="color:#73130d"> Local testing: </span>

* I created the basic spring project, without any special dependencies, just the basics. I made a dummy endpoint for test purposes, and I tested the swagger UI. There was some kind of version conflict here, but finally I found the correct dependencies. (2023.06.07)


<span style="color:#73130d"> Docker: </span>

* I [dockerized](./Dockerfile) the spring application with one container for the spring app, and one container for the mysql db. Tried it, and it worked, and db data was persistant. (2023.06.08)
* I wrote the [Docker-compose file](./docker-compose.yaml) for the project, and I tested it. Tried to pass the db credentials threw env.variable to application.properties, but I realized the project should be built inside the container to work. Right now I made the build locally, and copy the target folder to the container. (2023.06.09)
* I had a tiny problem at this point. When I tried to count the .target files for test reasons inside the container, I realized that the base alpine linux image does not use systemd. 
* Changed the base image from alpine linux to default [openjdk image](https://hub.docker.com/layers/library/eclipse-temurin/17-jdk/images/sha256-b0faf02bf7acfc65be1c2d0a291140300bd129620f145bf1013a1da748295d0c?context=explore). (2023.06.10)
* UserA and UserB added to docker-compose file and Dockerfile via args. (2023.06.10)

<span style="color:#73130d"> Makefile: </span>

* I added three functionality to the [Makefile](./Makefile). One for building the project, one for running the project, and one for stop the project. (2023.06.110

### Experience






