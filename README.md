# SoCal SurfTracker

Welcome to the SoCal SurfTracker Repository
- SoCal SurfTracker synthesizes the surf and weather forecasts from several different providers to arm you with
  the knowledge to confidently grab your board and go! 

- Underneath the hood this Spring Boot Application pulls information from external APIs and web-scraped pages to
  deliver dashboard-like pages that equips you with the information that you need before getting into the water.
- This web application includes Current Conditions, Hourly Conditions and Future Conditions for 12 different
  locations:  
    1. Ponto (Carlsbad)
    2. Tamarack
    3. Oceanside
    4. San Onofre 
    5. Lower Trestles
    6. Upper Trestles
    7. T-Street
    8. Doheny
    9. Salt Creek
    10. Newport Beach
    11. Huntington Beach
    12. Seal Beach Pier



## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Pages](#pages)
- [Technologies Used](#technologies-used)
- [Future Improvements](#future-improvements)
- [Contributing](#contributing)
- [License](#license)

## Installation

To run this website locally, follow these steps:

- Clone the repository:
    ```sh
    git clone https://github.com/tmooney84/SoCalSurfTracker
    ```
2. Navigate to the project directory:
    ```sh
    cd SoCalSurfTracker/
    ```
3. Open pom.xml and make sure that your configuration works appropriately using Java 21 :
    ```sh   
   open SoCalSurfTracker/pom.xml
    ```

3. Navigate to the application properties configuration file and make sure that you have 
   created a database named surftracker:
    ```sh
    cd SoCalSurfTracker/src/main/java/com.surf.surftracker/resources/application.properties
    ```
2. Navigate to SurftrackerApplication.java and run the application:
    ```sh
    cd SoCalSurfTracker\src\main\java\com\surf\surftracker\
    ```
3. Open `localhost8080/lowerTrestlesCurrent` in your preferred web browser:
    ```sh
    open localhost8080/lowerTrestlesCurrent
    ```
4. Enjoy!

## Usage

This website is designed for easy usage and access to information for making decisions of where to go surfing. 

## Features

- **Login Page:** Allows the user to login by OAuth or password.
  ![alt text for screen readers](/readme_imgs/st_login.png "Login Page")

- **Home Page:** Gives a Base Dashboard of information of current waves heights from different locations
  ![alt text for screen readers](/readme_imgs/st_dashboard.png "Current Conditions Dashboard Page")

- **Current Forecast Pages:** Gives current weather and surf conditions  
  ![alt text for screen readers](/readme_imgs/current_sc.png "Surf Spot Current Conditions Page")

- **Hourly Forecast Pages:** Gives hourly weather and surf forecasts

- **5 Day Forecast Pages:** Gives daily weather and surf forecasts

## Pages

### Home Page

Contains information related to all 12 surf locations in one place.

### Current Forecast Pages

In addition to current weather and surf conditions there are photos and video for each of the relevent surf locations.

### Hourly Forecast Pages

In addition to hourly weather and surf forecasts there are photos and videos for each of the relevent surf locations.

### 5 Day Forecast Pages

In addition to 5-day weather and surf forecasts there are photos and videos for each of the relevent surf locations.

## Technologies Used
- **CSS:** For styling the website, including inline, internal, and external CSS. Utilizes Flexbox and optionally SASS/SCSS.
- **HTML:** For structuring the web pages.
- **Jackson:** For mapping incoming JSON data from external API calls to manageable data objects.
- **Java:** For implementing the program within Spring Boot.
- **JavaScript:** For adding interactivity to the website, including external scripts, event handling, and more.
- **JSoup:** For scraping necessary webdata from several websites.
- **JUnit:** For unit testing
- **Mockito:** For mocking external interfaces so that dummy functionalities can be added to a mock interface used in unit testing
- **Spring Boot:** For running the underlying web infrastructure and Tomcat Server.
- **Spring Data JPA:** For storing user data to backend database using MySQL.
- **Spring Security:** For implementing a login and persistence of users.
- **WebClient:** For making external API calls that returned JSON data.

## Future Improvements
- Surf update alert by text/email
- Async calls for updating data for five day and hourly updates
- Add and delete favorites and home breaks
- Use metroweather api for weather API needs 
- Create robust integration, unit and spec testing
- Migrate to AWS
- Add map to homepage using google maps api or arcgis api 
- Oath2 google, microsoft
- Picture adding with featured picture of the day; if user does a review gets a free picture or secret endpoint
- Further surf break descriptions
- Integrating map api endpoints
- Fully integrate into timezones surfspot records classes
- Message Board

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License

Copyright <YEAR> <COPYRIGHT HOLDER>

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


---

Thank you for visiting the SoCal SurfTracker! Enjoy the waves!
