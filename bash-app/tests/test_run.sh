#!/bin/sh

set -eu

output=$(./run.sh)
expected="Hello, Intern! This is a simple Bash app running in Docker."

if [ "$output" != "$expected" ]; then
  echo "TEST FAILED"
  echo "Expected: $expected"
  echo "Got: $output"
  exit 1
fi

echo "TEST PASSED"
