# Lifeplan - Todo

## Overview

**Lifeplan**, the personalized life tracker built for *you*.

### Why do we need this?
Coz I think so, that's why! Also,

* Keep track of the everyday activities that you spend time on a daily basis.
* Create and manage Todo items. Then mark them as completed. You can also edit exiting ones and delete them if you don't like them. (future)
* Create and manage your vacations and other travel escapades. (future)

### Get Started
* Install the technologies/frameworks listed below
* set the log file location in src/main/resources/log4j.properties _defaults to ./log/lifeplan.log
* set the mongodb instance connection parameters in src/main/resources/properties/lifeplan-prod.properties

### Deploying
Properties files are selected for environment based on maven build profile

##### Local
* deploy and run in local Jetty configured in pom (mvn jetty:run -Plocal)
* build war file and deploy to a server like Tomcat (mvn package -Plocal)

##### Prod
* set production specific properties in /properties/lifeplan-prod.properties
* use maven profile prod (mvn package -Pprod)

#### Technologies
* Java 1.7
* Spring 3.2 MVC
* Spring Data
* Mongo DB
* Maven
* AngularJS + Twitter Bootstrap (Bootswatch Theme)

##### Free+amazing stuff I used
* Markdown file created and edited with Mou.[^1]

> The cure for loneliness is planning. Without planning, you wake up in the morning and it just gets darker. - Simon Amstel (paraphrased)

#### Footnotes

I will add footnotes here so that people who enjoy reading footnotes would scroll all the way down and have a good time.

[^1]: [Mou](http://mouapp.com/).


