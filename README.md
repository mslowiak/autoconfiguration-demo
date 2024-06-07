This repository demonstrates how to write and auto configuration and how to trouble shoot.
Going from steps 1-7 will show common issues and suggest solutions.

- **Step 1**

Application without starter and autoconfiguration

- **Step 2**

Adding the starter code with autoconfiguration.
Autoconfiguration is not working properly.

- **Step 3**

Enable the debug to see what was autoconfigured in application logs.

_(*) There is a second option to check what is the current state of loaded autoconfigurations. The actuator can be exposed and on path `actuator/conditions` there will be a list of autoconfigurations state similar to the logs based._

- **Step 4**

Fix commented autoconfiguration path in `AutoConfiguration.imports` file.

- **Step 5**

Fix missing bean to enable autoconfiguration. 

- **Step 6**

Proposal of customization of autoconfiguration.

- **Step 7**

Present way to opt out.
