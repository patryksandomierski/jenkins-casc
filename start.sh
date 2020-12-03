#!/bin/bash
docker-compose down
docker-compose pull
docker-compose build
docker-compose up -d
docker logs -f jenkins-casc
