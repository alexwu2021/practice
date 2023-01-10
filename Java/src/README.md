# README #

This is a POC project aimed at exploring for an object way to answer aggregated KPI queries

### What is this repository for? ###
* Quick summary
  * Serving aggregated stat queries by using refined bucket arrays for each subject stored in memory (rather than directly querying db)

* Version
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### How do I get set up? ###

* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions

## where to set the connection string for db access
/poc-mp/poc-mp/src/main/resources/application.yml
/poc-mp/poc-mp/META-INF/${profile}/persistence.xml
/poc-mp/poc-mp/src/main/resources/${profile}/hibernate.cfg.xml


spring:
datasource:
username: dw-feed
password: dw_D0c_2022
driver-class-name: com.mysql.cj.jdbc.Driver
url: jdbc:mysql://10.2.1.11:3306/dw


# occasionally you run into port hogged by some process, then please do the following


sudo kill -9 $(lsof -ti:2181)
sudo kill -9 $(lsof -ti:9002)
sudo kill -9 $(lsof -ti:8080)

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###
* Please contact awu@docmatter.com for your comments


## design ideas
1) using hash map to store sparse data
2) store only coded data, that is, just integers
3) form intermediate data structure to answer aggregated queries, and cache them whenever possible

## postman testing 

localhost:9002/ims/stat/factFileCount
localhost:9002/ims/stat/openEmail/all with dates specified like 20211101,20211115


## works remaining

1. hook up with the local kafka: under the way
2. improve the event processing and ensure it save back to dw tables
3. have a way of generating streaming inputs for the event
4. improve the health checking mechanism
5. add nonlocal deployment profile
6. deploy it to 10.2.1.12
7. docs
8. improve the unit test coverage
