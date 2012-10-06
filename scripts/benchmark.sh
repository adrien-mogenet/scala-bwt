#!/bin/bash

# Configuration
SCALA=`which scala`
MAIN_CLASS="me.algos.bwt.Benchmark"
CLASSES_FOLDER="./bin"
ITERATIONS=10
OUTPUT="/tmp/scala-bwt.log"

test -n "${SCALA}" || (echo "Unable to locate scala binary"; exit 2)
test -d "${CLASSES_FOLDER}" || (echo "Unable to locale CLASSES_FOLDER"; exit 2)

# Launch a benchmark and save result
launch() {
  local length=$1
  echo -n "-- Runnning with input of ${length} chars... "
  local duration="$( TIMEFORMAT='%lU';time (\
      ${SCALA} -cp $CLASSES_FOLDER ${MAIN_CLASS} ${ITERATIONS} ${length}) 2>&1 1>/dev/null )"
  echo ${duration}
  echo "${length} ${duration}" >> ${OUTPUT}
}

rm -f ${OUTPUT}
for length in 0005 0010 0050 0100 1000; do
  launch ${length}
done
