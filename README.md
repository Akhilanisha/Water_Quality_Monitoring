# Water Quality Monitoring (WQM)

## Problem Statement
This project aims to develop a Complaint Management System to streamline the process of handling citizen grievances for a city administration. Through a userfriendly web application interface, citizens can submit complaints regarding issues such as water leakage and contamination.

## Objectives
- To develop a platform for reporting water quality complaints.
- To implement a system to manage and visualize submissions.

## SDG 6 Alignment

The WQM platform supports Sustainable Development Goal 6 (SDG 6) by providing tools and resources to improve water quality and promote sustainable water monitoring practices. Through our complaint management system, we address water quality issues promptly, contributing to the goal of ensuring availability and sustainable management of water and sanitation for all.

### SDG Goal 6:

![SDG 6](https://github.com/Cap26803/Water-Quality-Monitoring/assets/106472393/532d36d6-e216-4515-bd12-5fa18fcb29fe)

### Ensure availability and sustainable management of water and sanitation for all.
- **Target 6.1:** By 2030, achieve universal and equitable access to safe and affordable drinking water for all.
- **Indicator 6.1.1:** Proportion of population using safely managed drinking water services.

## System Thinking

We applied systems thinking to analyze the intricate interactions involved in water quality monitoring. Breaking down the problem into smaller components enabled us to pinpoint crucial areas where intervention and enhancement were needed.

### Causal Map
![Causal Map](https://github.com/Cap26803/Water-Quality-Monitoring/assets/105357505/e5f1effa-380c-4cf7-a807-807c8b146a3c)

### Behaviour Over Time (BoT)
![Behaviour Over Time](https://github.com/Cap26803/Water-Quality-Monitoring/assets/105357505/c91e77ab-b31e-4870-943e-bb53ef092753)

### Feedback Loops
![Feedback Loop 1](https://github.com/Cap26803/Water-Quality-Monitoring/assets/105357505/d294e465-0678-4b65-8937-41e76b930d11)
![Feedback Loop 2](https://github.com/Cap26803/Water-Quality-Monitoring/assets/105357505/5f5c27a0-337f-49f3-9b46-0fa20e7765b7)

## Tech stack

| Layer | Technology |
| --- | --- |
| Frontend | React 19, React Router 7, JavaScript and JSX, Vite 8 |
| UI libraries | Chart.js, react-chartjs-2, Font Awesome, React Slick |
| HTTP | Axios and a Spring MVC REST API |
| Backend | Java 21, Spring Boot 4.1, Spring Data JPA, Hibernate |
| Database | MySQL and MySQL Connector/J |
| API documentation | springdoc OpenAPI and Swagger UI |
| Build and tests | npm with a lockfile, Maven Wrapper, JUnit and H2 for integration tests |

## Run locally on Windows

Install **Node.js 24 or 26**, **JDK 21**, and **MySQL**. Check your
installation with `node -v` and `java -version`.

1. In MySQL, create an empty database named `wqm`. Use a local database
   account with permission to read, write, and update the schema in that
   database. Hibernate creates the tables on first launch.
2. Open PowerShell in the repository and start the backend. Substitute your
   database username and password.

   ```powershell
   cd backend
   $env:DB_USERNAME = 'your_mysql_username'
   $env:DB_PASSWORD = 'your_mysql_password'
   .\mvnw.cmd spring-boot:run
   ```

   The API listens on port `8081`. Its Swagger UI is available at
   [localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html).
3. Open a second PowerShell window in the repository root and start the frontend.

   ```powershell
   npm ci
   npm run dev
   ```

   Open [localhost:3000](http://localhost:3000). Vite forwards requests under
   `/api` to the local Spring Boot server.

On macOS or Linux, use `export` to set the environment variables and
`./mvnw spring-boot:run` to start the backend.

## Configuration and verification

| Variable | Purpose | Default |
| --- | --- | --- |
| `DB_URL` | Backend JDBC connection string | `jdbc:mysql://localhost:3306/wqm` |
| `DB_USERNAME` | MySQL username | `wqm` |
| `DB_PASSWORD` | MySQL password | Empty |
| `PORT` | Backend server port | `8081` |
| `WQM_DEV_API_TARGET` | Backend target for Vite development and preview | `http://localhost:8081` |
| `VITE_API_BASE_URL` | API base embedded in the frontend build | `/api` |

Run `npm run build` from the repository root to generate `dist/`.
When hosting the build, configure the host to serve `index.html` for browser
routes and forward `/api` to the backend. For a separately hosted API, set
`VITE_API_BASE_URL` to its full base URL, including `/api`, before building.

Run `.\mvnw.cmd clean verify` on Windows or `./mvnw clean verify` on
macOS/Linux from the `backend/` directory. The integration tests use an
in-memory H2 database and cover complaint submission, retrieval, and OpenAPI.

The login and registration screens are demonstrations. The dashboard updates
accept/reject decisions in browser memory. These flows require server-side
implementation before a public deployment.

## Final Outcomes:
![Home Page](https://github.com/Cap26803/Water-Quality-Monitoring/assets/106472393/6e0dae06-e3c9-4064-a6dd-f67f1a902004)
![Complaint Submission](https://github.com/Cap26803/Water-Quality-Monitoring/assets/106472393/649147a5-e65c-48b6-b8e3-684ffafc8113)
![Admin Dashboard](https://github.com/Cap26803/Water-Quality-Monitoring/assets/106472393/3f036abf-6c88-4eae-8b10-7c5eb5c8c8f6)


## Contribution Guidelines

We welcome contributions from the community. If you have suggestions or bug reports, please create an issue or submit a pull request.

### Steps to Contribute

1\. Fork the repository

2\. Create a new branch (`git checkout -b feature-branch`)

3\. Make your changes

4\. Commit your changes (`git commit -m 'Add some feature'`)

5\. Push to the branch (`git push origin feature-branch`)

6\. Open a pull request

Thank you for supporting the Water Quality Monitoring platform and our mission to promote clean water and sustainable development!

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
