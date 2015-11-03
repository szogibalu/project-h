#!/bin/bash

if !(which mvn > /dev/null;) then
    echo Maven is not installed.
    exit 1
fi

if [ ! -f target/bin/run-demo.sh ]; then
    echo "Run file not found!"
    if !(mvn clean install) then
    	echo "Demo Service has been needed to installed."    
	fi
fi

if !(chmod +x target/bin/run-demo.sh) then
    echo "Cannot set run-demo.sh to executable"
    exit 1
fi

if (./target/bin/run-demo.sh); then
  echo "Demo Service is started.."
else
  echo "Error at starting Demo Service..."
  exit 1
fi
