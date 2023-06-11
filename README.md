# <span style="color:#73130d">OTP project</span>

### How to use?

* Clone the project
* I put the final version at the main branch
* After cloning just simply run the following command: <strong>make</strong> or <strong>make start</strong>
* To run it in attached mode: <strong>make attach</strong>
* To build the project: <strong>make build</strong>
* To stop the project: <strong>make stop</strong>
* ⬆️ These ⬆️ will use docker. If you want to try it with podman, checkout for branch: try-podman
* If we push to production branch Jenkins will clone the repo to my local server ()

### Workflow Documentation

I will write my work steps in the following section:

<span style="color:#73130d"> Local testing: </span>

* I created the basic spring project, without any special dependencies, just the basics. I made a dummy endpoint for test purposes, and I tested the swagger UI. There was some kind of version conflict here, but finally I found the correct dependencies. (2023.06.07)
* I created the finel endpoints, and I tested them with swagger UI. (2023.06.07)
* Finally, I made the correct business logic for the app, although I think I cheated a little, because I do not check all the root folders in the linux system, because it took so much time during tests. (2023.06.11)


<span style="color:#73130d"> Docker: </span>

* I [dockerized](./Dockerfile) the spring application with one container for the spring app, and one container for the mysql db. Tried it, and it worked, and db data was persistant. (2023.06.08)
* I wrote the [Docker-compose file](./docker-compose.yaml) for the project, and I tested it. Tried to pass the db credentials threw env.variable to application.properties, but I realized the project should be built inside the container to work. Right now I made the build locally, and copy the target folder to the container. (2023.06.09)
* I had a tiny problem at this point. When I tried to count the .target files for test reasons inside the container, I realized that the base alpine linux image does not use systemd. 
* Changed the base image from alpine linux to default [openjdk image](https://hub.docker.com/layers/library/eclipse-temurin/17-jdk/images/sha256-b0faf02bf7acfc65be1c2d0a291140300bd129620f145bf1013a1da748295d0c?context=explore). (2023.06.10)
* UserA and UserB added to docker-compose file and Dockerfile via args. (2023.06.10)
* Instead of copying the target folder to the container, I added the maven build command to the Dockerfile (target folder added back to gitignore). (2023.06.10)
* With the internal build process now I can pass the db credentials via env.variable to application.properties. (2023.06.10)

<span style="color:#73130d"> Podman: </span>

*  I tried running the project with Podman, and it worked partially. The images were built, and MySQL was pulled from Docker Hub. However, it then attempted to pull my own images from docker.io instead of running them locally, and I have yet to figure out why. Although I will try to figure it out, but I will send to you the Docker version. You can find the podman version at branch: try-podman (2023.06.10)

<span style="color:#73130d"> Makefile: </span>

* I added three functionality to the [Makefile](./Makefile). One for building the project, one for running the project, and one for stop the project. (2023.06.10)

### Experience

* It was an interesting experience for me, I did not find it too hard, but sometimes it was challenging. 
* I learned some new things, like what is swagger-ui, and how to use makefile.
* I am a little frustrated by the podman issue, but I am sure I will figure it out.
* I hope you will be satisfied with my work, and I am looking forward to your feedback.






