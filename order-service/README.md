# Order Service

## Overview
The Order Service is a crucial component of our microservices architecture, responsible for managing and processing customer orders in a seamless and efficient manner.

## Features
- Create, read, update, and delete orders
- Integration with payment services
- Notification system for order status updates
- Scalability to handle varying loads

## API Endpoints
### Create Order
- **POST** `/orders`
- **Request Body:**
  ```json
  {
    "customerId": "string",
    "items": [
      {
        "productId": "string",
        "quantity": "integer"
      }
    ]
  }
  ```
- **Response:** Order details with a unique order ID.

### Get Order
- **GET** `/orders/{orderId}`
- **Response:** Order details including status and items.

### Update Order
- **PUT** `/orders/{orderId}`
- **Request Body:**
  ```json
  {
    "status": "string"
  }
  ```
- **Response:** Updated order details.

### Delete Order
- **DELETE** `/orders/{orderId}`
- **Response:** Confirmation of deletion.

## Setup Instructions
1. **Clone the repository**:
   ```sh
   git clone https://github.com/shrikant110/microservices.git
   cd microservices/order-service
   ```
2. **Install dependencies**:
   ```sh
   npm install
   ```
3. **Run the service**:
   ```sh
   npm start
   ```

## Testing
- Unit tests can be run using:
  ```sh
  npm test
  ```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Authors
- Shrikant
- [Add other contributors if applicable] 

## Acknowledgments
- Inspired by various open-source projects.