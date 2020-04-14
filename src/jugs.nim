## Jugs

import strutils
import searchutils

# Prompt the user and get positive non-zero integer input
proc get_num(prompt: string): uint =
  var input: uint
  echo prompt
  try:
    input = readLine(stdin).parseUInt()
  except ValueError:
    input = get_num("Please enter a positive integer")
  return input

# Get all the jug sizes as well as the target amount
let jug_count = get_num("How many jugs are there?")
var jug_sizes: seq[uint]
for i in 1..jug_count:
  jug_sizes.add(get_num("How big is jug " & $i & "?"))
let target = get_num("What is the target amount?")

let search_log = search(jug_sizes, target)

var i = search_log.src_inds.len
while i > 0:
  echo search_log.nums[i]
  i = search_log.src_inds[i - 1]