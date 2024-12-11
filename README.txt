Understanding and Assumptions

1. IoT devices call an API to register machine configurations with the Augury system.
2. IoT devices connected to physical machines send session details to the Augury system through a REST endpoint, including the machine ID.
3. A dedicated UI allows users to input repair details for a machine, which are then sent to the Augury system via a REST endpoint with the machine ID.
4. The UI for presenting machine feeds assumes prior knowledge of the machine ID. Alternatively, the UI can make an API call to fetch all machine details and, upon selecting a specific machine ID, display its feeds in a table format.
5. Actual data is mocked and assumed any JSON data for POC purpose. 

Objective -

Build a UI and a distributed microservice architecture to present machine feeds (sessions and repairs) on a dedicated screen.

Flow Design implemented 

Machine Configurations -

1. IoT devices send machine configuration data via a REST API.
2. The REST endpoint stores the machine configuration in the database.

Sessions -

1. IoT devices send session data via a REST API.
2. The REST endpoint places the session data into a RabbitMQ queue (session-queue) and responds with a success (204 No Content).
3. A microservice listens to the session-queue, processes the session messages, and saves them to the database.

Repairs -

1. Repair data is processed similarly to sessions, using a separate RabbitMQ queue (repair-queue).

Microservice to Present Feeds on the UI -

1. The UI fetches all machine configurations initially and, upon selecting a specific machine, displays its corresponding feeds.
2. The UI makes an initial API call to fetch machine feeds for a specified timeframe (e.g., the last 1 hour).
3. The UI establishes a WebSocket connection with the server, subscribing to /topic/feeds/{machineId} for real-time updates.
4. When session or repair messages are processed and saved in the database, the same messages are also published to the /topic/feeds/{machineId} WebSocket topic, enabling the UI to receive and display the latest feeds dynamically.

I have also buit the ui to simply display the feeds receied and processed by the message listers. 

http://localhost:8080/index.html

