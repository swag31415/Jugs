## Jugs

import strutils

# Prompt the user and get positive non-zero integer input
proc get_num(prompt: string): uint =
  var input: uint
  echo prompt
  try:
    input = readLine(stdin).parseUInt()
  except ValueError:
    input = get_num("Please enter a positive integer")
  return input