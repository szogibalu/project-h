#!/bin/bash

if !(which docker > /dev/null;) then
    echo Docker is not installed.
    exit 1
fi

if !(which docker > /dev/null;) then
    echo Docker is not installed.
    exit 1
fi

if !(which docker-compose > /dev/null;) then
    echo Docker Compose is not installed.
    exit 1
fi

if (./build-demo-service-image.sh) then
    echo Continue with publishing.
fi

if (cd ./target/docker;docker-compose up) then
    echo Demo Service published and started.
    exit 1
fi
