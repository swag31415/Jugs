## Search Utils

type
  Log = object
    nums*: seq[uint]
    src_inds*: seq[int]

proc search*(sizes: seq[uint], target: uint): Log =
  var log: Log
  log.nums.add(0)
  var i = 0
  while i < log.nums.len():
    for size in sizes:
      if not log.nums.contains(log.nums[i] + size):
        log.nums.add(log.nums[i] + size)
        log.src_inds.add(i)
        if log.nums[i] + size == target: return log
      if size < log.nums[i] and not log.nums.contains(log.nums[i] - size):
        log.nums.add(log.nums[i] - size)
        log.src_inds.add(i)
        if log.nums[i] - size == target: return log
    inc(i)