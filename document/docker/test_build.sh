#!/usr/bin/env sh
# 首先在dev构建好新的镜像
scp root@192.168.1.246:/app/organization-sync-service/organization-sync-service.tar organization-sync-service.tar
docker load -i organization-sync-service.tar
docker stop organization-sync-service || true
docker rm organization-sync-service || true
docker run -v /xpros/organization-sync-service:/app/logs -e TZ=Asia/Shanghai -d --name organization-sync-service -p 5006:5006 --network xpros-back organization-sync-service
docker logs -f organization-sync-service --tail=100