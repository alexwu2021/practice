#Table point holds the x coordinate of some points on x-axis in a plane, which are all integers.
#Write a query to find the shortest distance between two points in these points.



#both works, oj passed

select min(abs(p1.x - p2.x)) as shortest
from point p1  join point p2
where p1.x <> p2.x ;


select min(abs(p1.x - p2.x)) as shortest
from point p1  join point p2
on p1.x <> p2.x ;