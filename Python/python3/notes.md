# let dq be a deque, q be a list, each contains the same element, be warned that the following operation will not have the same result:

dq.popleft()    vs.     q.pop()

however, we can simulate dq.popleft() with the following lines:
```
q.pop()
q = q[1:]
```


# bit mask should be in this way

0b1010101010101010101010101010101
