start:
	podman-compose up -d

attach:
	podman-compose up

build:
	podman-compose up --build

stop:
	podman-compose down
