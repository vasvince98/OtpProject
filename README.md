# <span style="color:#73130d">OTP project</span>

### How to use?

* Clone the project
* I put the final version at the main branch
* After cloning just simply run the following command: <ins><strong>make</strong></ins> or <ins><strong>make start</strong></ins>
* To run it in attached mode: <ins><strong>make attach</strong></ins>
* To build the project: <ins><strong>make build</strong></ins>
* After the startup you can reach the swagger UI at [userA](http://localhost:8081/swagger-ui.html) and [userB](http://localhost:8082/swagger-ui.html) (At port: 8081 and 8082)
* To stop the project: <ins><strong>make stop</strong></ins>
* ⬆️ These ⬆️ will use docker. If you want to try it with podman, checkout for branch: try-podman (but it is unfortunately not working properly)
* If we push to production branch Jenkins will clone the repo to my local server (right now it is only cloning, not building or running the project) There is also a branch protection rule, push is allowed only after pull request and review.

### Workflow Documentation

I will write my work steps in the following section:

<span style="color:#73130d"> Local testing: </span>

* I created the basic spring boot project, without any special dependencies, just the basics. I made a dummy endpoint for test purposes, and I tested the swagger UI. There was some kind of version conflict here, but finally I found the correct dependencies. (2023.06.07)
* I created the final endpoints, and I tested them with swagger UI. (2023.06.07)
* Finally, I made the correct business logic for the app. I excluded the /proc and /sys folders from the recursive search! (2023.06.11)


<span style="color:#73130d"> Docker: </span>

* I [dockerized](./Dockerfile) the spring application with one container for the spring app, and one container for the mysql db. Tried it, and it worked, and db data was persistant. (2023.06.08)
* I wrote the [Docker-compose file](./docker-compose.yaml) for the project, and I tested it. This time I used two containers for different users. Tried to pass the db credentials via env.variable to application.properties, but I realized the project should be built inside the container to work. Right now I make the build locally, and copy the target folder to the container. (2023.06.09)
* I had a tiny problem at this point. When I tried to count the .target files for test reasons inside the container, I realized that the base alpine linux image does not use systemd. 
* Changed the base image from alpine linux to default [openjdk image](https://hub.docker.com/layers/library/eclipse-temurin/17-jdk/images/sha256-b0faf02bf7acfc65be1c2d0a291140300bd129620f145bf1013a1da748295d0c?context=explore). (2023.06.10)
* UserA and UserB added to docker-compose file and Dockerfile via args. (2023.06.10)
* Instead of copying the target folder to the container, I added the maven build command to the Dockerfile (target folder added back to gitignore) (idea: multi-stage build for maven). (2023.06.10)
* With the internal build process now I can pass the db credentials via env.variable to application.properties. (2023.06.10)

<span style="color:#73130d"> Podman: </span>

*  I tried running the project with Podman, and it worked partially. The images were built, and MySQL was pulled from Docker Hub. However, it then attempted to pull my own images from docker.io instead of running them locally, and I have yet to figure out why. Although I will try to figure it out, but I will send to you the Docker version. You can find the podman version at branch: try-podman (2023.06.10)

<span style="color:#73130d"> Makefile: </span>

* I added four functionality to the [Makefile](./Makefile). One for building the project, one for running the project, one for running the project attached to the containers, and one for stop the project. (2023.06.10)

### Experience

* It was an interesting experience for me, I did not find it too hard, but sometimes it was challenging. 
* I learned some new things, like what is swagger-ui, and how to use makefile.
* I am a little frustrated by the podman issue, but I am sure I will figure it out.
* I tested the application on MacOS, Windows10 and Ubuntu, I hope it will work on your machine too... :)
* I hope you will be satisfied with my work, and I am looking forward to your feedback.






