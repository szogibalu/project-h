#!/bin/bash

if !(which mvn > /dev/null;) then
    echo Maven is not installed.
    exit 1
fi

if !(which docker > /dev/null;) then
    echo Docker is not installed.
    exit 1
fi

if (mvn clean package docker:build); then
  echo "Demo Service has been built."
else
  echo "Error at building Demo Service."
  exit 1
fi
