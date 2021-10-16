#rev 0.4
# EuporiaAlpha

Euporia is an annotation tool mainly aimed to digital philologists, offering them the 
possibility of uploading and tagging documents, for later use in a search system or the like.  
Moreover, the tool offers a versioning systems for the documents, meaning that you can 
view and go back to all the edits on a project.  
Euporia follows the [Open annotation data model](http://www.openannotation.org/spec/core/) specifications and it is built
with the idea of promoting not only digital philology but _collaborative philology_ as well.  

## About this repository
This repository contains the Euporia backend code, written with Java 8. Euporia's backend and frontend
are separated: the backend will expose several endpoints as HTTP API, which can later be called by any
client application (we will develop an Angular2 frontend).  
Database management is delegated to [Hibernate](http://hibernate.org): we use a [MariaDB](https://mariadb.org) database,
but you're free to connect any supported database to the Hibernate backend without much hassle.  
Finally, Java has been chosen as the programming language for the backend since it is a very popular language and,
most importantly, it is very well known among digital humanists, such as computational linguistics and digital
philologists.


## Build and run the project
We will soon make available a docker image to easily run the project.
However, you still need to place the [Hibernate](http://hibernate.org) 
configuration file in _src/main/resources/hibernate.cfg.xml_.  
You can find an example configuration [here](https://docs.jboss.org/hibernate/orm/5.4/quickstart/html_single/).
The project uses [Maven](https://maven.apache.org/) as a dependency manager. You will need
to install it on your system (most of the times IDE already have it) and download the 
dependencies in the _pom.xml_ file.
