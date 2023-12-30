# VirtuLibrarian - Library Management System

## Overview

VirtuLibrarian is a Library Management System designed to manage books, user accounts, and book issuance records. It provides a set of RESTful APIs for various operations, such as searching for books, managing user accounts, and handling book borrowings.

## Table of Contents

- [Entities](#entities)
- [Controllers](#controllers)
- [Security Configuration](#security-configuration)
- [User Details Service](#user-details-service)
- [Getting Started](#getting-started)
- [Additional Notes](#additional-notes)

## Entities

### 1. Book

Represents information about a book.

- `BookId`: Unique identifier for the book.
- `Title`: Title of the book.
- `Genre`: Genre of the book.
- `Author`: Author of the book.
- `ISBN`: International Standard Book Number.

### 2. BookIssuedRecord

Records information about book issuances.

- `IssueId`: Unique identifier for the issuance record.
- `User`: User to whom the book is issued.
- `Book`: Book that is issued.
- `IssueDate`: Date when the book is issued.
- `ReturnDate`: Date when the book is returned.

### 3. User

Represents information about a user.

- `UserId`: Unique identifier for the user.
- `FirstName`: First name of the user.
- `LastName`: Last name of the user.
- `EmailId`: Email address of the user.
- `Password`: Password (hashed) for user authentication.
- `Role`: Role of the user in the system.

## Controllers

### 1. BookController

Handles operations related to books.

- **Endpoints**:
    - `/api/books/search`: Search for books based on title, author, or genre.
    - `/api/books/add-group`: Add multiple books.
    - `/api/books/add-single`: Add a single book.

### 2. BookIssuedRecordController

Handles operations related to book issuance records.

- **Endpoints**:
    - `/api/my-library`: Retrieve all books borrowed by the current user.
    - `/api/borrow-book`: Borrow a book (requires a bookId parameter).

### 3. UserController

Handles operations related to user accounts.

- **Endpoints**:
    - `/api/register`: Register a new user.
    - `/api/profile`: Retrieve the profile details of the current user.

## Security Configuration

### VirtuLibrarianSecurityConfig

Configures security settings for the application.

- **Security Filter Chain**: Configures authorization rules for various endpoints.
- **Password Encoder**: Uses BCryptPasswordEncoder for password hashing.

## User Details Service

### VirtuLibrarianUserDetailServiceImpl

Implements the UserDetailsService interface for loading user details during authentication.

- Retrieves user details from the UserService based on the provided email.
- Constructs UserDetails objects for Spring Security.

## Getting Started

To run VirtuLibrarian locally, follow these steps:

1. Clone the repository.
2. Configure the database settings in `application.properties` or `application.yml`.
3. Build and run the application.

