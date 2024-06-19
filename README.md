# Third-Party-API Integration API

## Overview

Welcome to the **Third-Party-API Integration API** repository. This backend service contains two APIs consumed. One provides basic CRUD operations for managing blog posts. It exposes specific endpoints under `/api/` to create, delete, update, and fetch posts as well as endpoints to fetch data on COVID. This code-base was used to practice consuming APIs.

## Endpoints for Covid API

- **GET /api/countries**: Retrieve all countries with COVID.
- **GET /api/statistics**: Retrieve statistics of the COVID Victims for Each Country.

## Endpoints for BlogPost API

- **GET /api/getPost/{id}**: Gets a Post by its ID.
- **POST /api/insertPost**: Creates a new post.
- **PUT /api/updatePost/{id}**: Update a posts by ID.
- **DELETE /api/deletePost/{id}**: Deletes a post by ID.

## Usage

1. **Retrieve all books**:
    - **Request**: `GET /api/getPost/{id}`
    - **Response**: Returns a Post based on the ID

2. **Create a new book**:
    - **Request**: `POST /api/insertPost`
    - **Body**: JSON object containing post details.
    - **Response**: Returns the newly created post with its assigned ID.

3. **Update an existing book**:
    - **Request**: `PUT /api/updatePost/{id}`
    - **Body**: JSON object containing updated post details.
    - **Response**: Returns the updated post details.

4. **Delete a book by ID**:
    - **Request**: `DELETE /api/deletePost/{id}`
    - **Response**: Deletes the book with the specified ID from the database and Returns a Message.


## Contribution

Contributions are welcome! If you have any suggestions, improvements, or bug fixes, please feel free to open an issue or submit a pull request.