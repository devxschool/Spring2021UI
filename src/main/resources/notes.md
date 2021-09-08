###What is HTML?

HTML stands for Hypertext Markup Language.  Which is used to create webpage skeletons. IT has it's own format just like
XML. 

```html
 <textarea> Hello World </textarea>
```

HTML consists of tags -> <(less than sign) is an opening tag and > (more than sign) is a closing tag. 
Tags represent different kind of web elements. 
Pictures, links, texts, input boxes, check boxes, buttons, tables, media. 

 
Does it have to be HTML/CSS/JavaScript to build websites? 
No. HTML/CSS/Python
    HTML/CSS/Java
    HTML/CSS/PHP
    HTML/CSS/Ruby
    HTML/CSS/ASP.NET -> C#.
   
   
   
   Metadata -> info about info. 
   
   
 Every Tag in html has attributes.
 attributes are parameters of a tag. a characteristics of a tag. 
 
 
Every tag can have ID and names. This is super important attributes bc we will be using them to locate right web elements. 


 <option value="" selected disabled>Select a Course</option>
 
 <select>
  <option value="usa"> United States of America </option>
  
  if(selectEdValue.equals("usa")). 
  
 a -> anchortext -> link
 

###Different type of Apps.
Web Apps -> You can access(use) this app only on a browser. 
Desktop UI Apps -> Run on the personal computer directly. Microsoft Office, Zoom, Slack, Teams.
Server Apps -> Runs on servers and has no UI. 
Mobile Apps ->  Run on mobile phones.

Web Apps vs Desktop App
Web Apps are more flexible accessible from phones, any OS.
Web App versions can be updated without the users' actions. 
Web Apps dont have to be downloaded.

Desktop Apps
Can work offline. 
More features. 
More secure.
Has access to Ram, Memory. 
They can run with other programs.
They can be programmed to run other kernel level commands.
 

Selenium is good for Web Browser Functional Testing. 
UI has a design. And Selenium is not a good tool to perform design testing. 

Design - look and positioning of web elements.

Can not handle captcha -> how do we test apps that have captcha. 
We perform testing in QA enviroment. and we disable captcha in QA. 





Java is enterprise level programming language.



CRM -> Customer Relations Managment tool.


######Selenium Grid
Selenium Grid is one of the components of selenium. it's used for cross platform and cross browser testing.
it could also be used for parallel testing to bring down the UI autmations slow test exectution time. 

Selenium Grid is a java process that needs to be installed on multiple servers. There hub which distributest the commands to nodes. 
each node can be different platform. In order to use Selenium Grid we need do pretty complex setup of VMs and configuring hub with nodes. 
Also we would need to make sure each hub and node servers have all browsers installed. 

###Sauce Labs
Sauce labs is a paid tool that uses Selenium Grid and removes the need to buying configuring and managing our own servers(vms). 
It supports all kids of platforms and browsers, offers video recorings of browser sesssions. There is absolutely no difference between running locally vs
on saucelabs from test perfromance and test results. We still get the nice pie-chart report with screenshots. 

SauceLabs has been a great option for us as we saved more money by avoiding managing our own vms. 


###Docker
Docker is concept of creating multiple pseudo severs within a single server. Each pseudo server is called a container in Docker. 
Containers are created and configured by writting docker images. This process extremely simplifies the process of recreating same kind of environment in 
different servers. 

###AWS 
Amazon web services offers many services like Virtual servers, media storages, AI libraries, etc. 

