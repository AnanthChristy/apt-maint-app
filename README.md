# Apartment Maintenance App

This is a Spring Boot app that exposes web services to add Users comprising of one of the following categories:
1. Resident
2. Owner
3. Technician

It also contains a Housing Group where you can add an Apartment or any kind of housing. This forms as an umberalla for adding users under it.
The software has been designed to allow adding types of users to Housing Group. There cannot exist a user without a Housing Group.

There is also provision to create a Category and sub categorize it with Issues.

Finally, you can create a Work Order with the Users' information. The status of which can be changed from OPEN to RESOLVED, etc.

The rest api for this app is available and hosted on heroku on a free dyno(The first API call will take a few seconds to load).

https://apt-maint.herokuapp.com/


