# Spring Boot drone_api_rest
> Drone webservice project demo.
# CLASS DIAGRAM
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/SsD7fMbz/Drone-Class-Diagramme-drawio.png' border='0' alt='Drone-Class-Diagramme-drawio'/></a>
## HOW TO BUILD AND RUN
* Java 8
* IntelliJ IDEA
* H2 In-Memory Database
* Clone the repo
* Open with IntelliJ
* Use Maven to download all dependencies
* Build and run the project
* Postman for api testing

## POSTMAN API TESTING
* # DRONE
>Register a drone: Make a POST request on url : http://localhost:9191/api/drone/v1/register 
* {
  "serialNumber": "BAB56766784A6",
  "model": "Middleweight",
  "weightLimit": 495.1,
  "battery": 50
  }
* {
"serialNumber": "ETDFD667",
"model": "Lightweight",
"weightLimit": 500,
"battery": 80
}

* {
"serialNumber": "XCDU9D0",
"model": "Cruiserweight",
"weightLimit": 395.45,
"battery": 17
}
  <a href='https://postimg.cc/4mJKmW27' target='_blank'><img src='https://i.postimg.cc/7YzStcgV/Register-Drone.png' border='0' alt='Register-Drone'/></a>
>Checking available drones for loading: Make a GET request on url : http://localhost:9191/api/drone/v1/available

<a href='https://postimg.cc/5jtjwsWZ' target='_blank'><img src='https://i.postimg.cc/1RG61dC5/get-Avalaible-Drones.png' border='0' alt='get-Avalaible-Drones'/></a>

>Checking battery level for a given drone: Make a GET request this url with the drone serialNumber as param : http://localhost:9191/api/drone/v1/checkBatteryLevel/BAB56766784A6

<a href='https://postimg.cc/WDLc41s2' target='_blank'><img src='https://i.postimg.cc/hGhDpXw7/Drone-Check-Battery.png' border='0' alt='Drone-Check-Battery'/></a>

* # MEDIACTION

>Register a medication: Make a POST request on url : http://localhost:9191/api/medication/v1/register
* {
  "code": "CO6766784",
  "name": "Covax",
  "weight": 200,
  "image": "image1.png"
  }
* {
  "code": "DI-908-CG",
  "name": "Diprolene",
  "weight": 100,
  "image": "image2.png"
  }

* {
  "code": "EF_5678C8",
  "name": "Efferalgan",
  "weight": 500,
  "image": "image3.png"
  }
  <a href='https://postimg.cc/XBfcbxNK' target='_blank'><img src='https://i.postimg.cc/cCjDf5Vz/Register-Medication.png' border='0' alt='Register-Medication'/></a>
>Show all medications : Make a GET request on url : http://localhost:9191/api/medication/v1/medications
> 
<a href='https://postimg.cc/vgHcBzvL' target='_blank'><img src='https://i.postimg.cc/wvDJw4yP/Capture-d-cran-26.png' border='0' alt='Capture-d-cran-26'/></a>

* # DRONE SHIPPING

>Loading a drone for shipping with medication items: Make a POST request on url : http://localhost:9191/api/drone_shipping/v1/register

The payload will have the following fields

* shippingAddress is where the medications items are delivered
* droneSerialNum is the drone serial to identify it
* medications_code is a string list with all the medication code


* {
"shippingAddress": "Liberte VI",
"droneSerialNum": "ETDFD667",
"medications_code": ["CO6766784","DI-908-CG"]
}
<a href='https://postimg.cc/G9GZtCHK' target='_blank'><img src='https://i.postimg.cc/qB50mBrP/Register-Drone-Shipping-Loaded.png' border='0' alt='Register-Drone-Shipping-Loaded'/></a>
* If Drone SerialNumber does not exit
<a href='https://postimg.cc/8jHkFWjZ' target='_blank'><img src='https://i.postimg.cc/sgFMN4yC/Register-Drone-Shipping-Serial-Not-Exist.png' border='0' alt='Register-Drone-Shipping-Serial-Not-Exist'/></a>
* If Drone not available for shipping
<a href='https://postimg.cc/hQKWgybc' target='_blank'><img src='https://i.postimg.cc/nrDH4NXj/Register-Drone-Shipping-State-Loaded.png' border='0' alt='Register-Drone-Shipping-State-Loaded'/></a>
* If medication code does not exist
<a href='https://postimg.cc/yDnNGG9h' target='_blank'><img src='https://i.postimg.cc/W4cJdL1y/Capture-d-cran-27.png' border='0' alt='Capture-d-cran-27'/></a>
* If you exceed the weight limit of the drone
  <a href='https://postimg.cc/p9zPH151' target='_blank'><img src='https://i.postimg.cc/8CncL2pD/Capture-d-cran-28.png' border='0' alt='Capture-d-cran-28'/></a>