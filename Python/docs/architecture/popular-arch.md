# modern web architecture

client either gets response from CDNs or from Services

# basic view

        browser  <-----> CDNs
        load balancers
        web servers
        services

# break-down of services

special services                task oriented services                          job-queues               
caching | searching             a.service | b.service | ... | z.service         job servers


# data layer

database
data warehouse


# trends
## progressive web app (PWA): SPA + Service Workers running in the user's browser
only on Windows, Android and iOS (not in offline mode)

## isomorphic
only in js

## micro front end or micro-apps


## node.js and the new web front-end
next.js, nuxt.js


# aws serverless webapp architecture

### source: https://mobidev.biz/blog/web-application-architecture-types



