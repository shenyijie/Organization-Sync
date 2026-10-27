#!/usr/bin/env sh
docker build -t organization-sync-service .
docker stop organization-sync-service || true
docker rm organization-sync-service || true
docker run -v /xpros/organization-sync-service:/app/logs -e TZ=Asia/Shanghai -d --name organization-sync-service -p 5006:5006 --network xpros-back organization-sync-service
docker save -o organization-sync-service.tar organization-sync-service
docker logs -f organization-sync-service --tail=100