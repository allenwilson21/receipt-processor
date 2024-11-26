# Receipt Processor
This project is a simple REST API that processes receipts. It is built using Spring Boot and Java 21.

## Prerequisites
* Docker
* Port 8080

## Build and Run Instructions
1. Clone the Repository
```bash
git clone <repository-url>
cd <repository-name> 
```

2. Build the Project
```bash
  ./gradlew build
```

3. Build the Docker Image
```bash
 docker build -t receipt-processor .
```

4. Run the Container
```bash
docker run -p 8080:8080 receipt-processor
```

5. Test the API

    a. Using your preferred REST client
    
   b. Using curl
    ```bash
   curl -X POST --location "http://localhost:8080/receipts/process" \
    -H "Content-Type: application/json" \
    -d '{
          "retailer": "Target",
          "purchaseDate": "2022-01-01",
          "purchaseTime": "13:01",
          "items": [
            {
              "shortDescription": "Mountain Dew 12PK",
              "price": "6.49"
            },{
              "shortDescription": "Emils Cheese Pizza",
              "price": "12.25"
            },{
              "shortDescription": "Knorr Creamy Chicken",
              "price": "1.26"
            },{
              "shortDescription": "Doritos Nacho Cheese",
              "price": "3.35"
            },{
              "shortDescription": "   Klarbrunn 12-PK 12 FL OZ  ",
              "price": "12.00"
            }
          ],
          "total": "35.35"
        }'
    ```
   
## Disclaimer
Just a limited example of tests are included in this project. In a real-world scenario, a more complete & comprehensive set of unit and integration tests would be included.