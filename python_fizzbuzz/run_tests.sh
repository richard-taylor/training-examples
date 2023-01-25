#!/bin/bash

TOP=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)
export PYTHONPATH=$TOP

cd $TOP/test
python3 -m unittest -v
