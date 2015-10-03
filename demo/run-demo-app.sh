#!/bin/bash

if !(which mvn > /dev/null;) then
    echo Maven is not installed.
    exit 1
fi

if (mvn spring-boot:run); then
  echo "Demo App is started.."
else
  echo "Error at starting Demo App..."
  exit 1
fi