# SNMP Manager and Authentication System Project

## Overview
This project implements an SNMP manager, authentication system, and client-server architecture using a combination of **HTML**, **PHP**, **Java**, **Servlets**, and **JSP**. It showcases how SNMP data can be managed and displayed interactively and how authentication can be integrated using Java-based HTTP communication.

## Features

### Part 1: SNMP Manager in PHP
1. **System Group Display**:
   - Displays all items in the SNMP System Group except "System Services".
   - Allows editing the last three items of the System Group.
   - Ensures Read and Write community access for SNMP updates.

2. **Data Tables**:
   - **Page 2**: Displays the **UDP Table**.
   - **Page 3**: Displays the **ARP Table**.
   - **Page 4**: Displays the **TCP Table**.

3. **Navigation**:
   - Includes navigation links for **Next**, **Previous**, and optional **Main Page**.

### Part 2: Java Client, Servlet, and JSP
1. **Authentication**:
   - **Servlet**:
     - Receives user **ID** and **Password**.
     - Responds with either `Permit` or `Deny` based on stored credentials.
   - **JSP Page**:
     - Receives **Name** and **Password**.
     - Responds with either `Permit` or `Deny` based on stored credentials.

2. **Client Application**:
   - Developed using **Java**.
   - Provides text fields for **Name**, **ID**, and **Password**.
   - Features buttons:
     - **Verify1**: Sends ID and Password to the Servlet.
     - **Verify2**: Sends Name and Password to the JSP Page.
   - If both responses are `Permit`, the client is allowed to fetch SNMP data.

3. **SNMP Data Retrieval**:
   - Buttons to fetch specific data for each page:
     - **Page 1**: Fetches System Group data (editable for last three items).
     - **Page 2**: Fetches UDP Table.
     - **Page 3**: Fetches ARP Table.
     - **Page 4**: Fetches TCP Table.
   - Communicates with PHP pages via HTTP requests.

## Technical Details
1. **Servers**:
   - XAMP/WAMP for hosting PHP pages.
   - Tomcat Apache Server for hosting Servlet and JSP.

2. **Backend**:
   - Pure PHP pages for SNMP data retrieval.
   - Java Servlet for authentication via ID and Password.
   - JSP Page for authentication via Name and Password.

3. **Frontend**:
   - JavaScript (AJAX or Fetch API) for dynamic data fetching from PHP backend.
   - HTML for client-side display.

4. **Client-Server Communication**:
   - The client application sends HTTP requests to the PHP server to fetch SNMP data after successful authentication.

## Setup and Usage
1. **Server Configuration**:
   - Set up XAMP or WAMP server for PHP pages.
   - Configure Tomcat Apache Server for Servlet and JSP.

2. **SNMP Configuration**:
   - Ensure SNMP agent is configured on the target system with read-write access.

3. **Java Client**:
   - Run the Java client application.
   - Enter credentials and verify via Servlet and JSP.
   - Fetch SNMP data upon successful authentication.

4. **Editing SNMP Data**:
   - Use the provided interface on Page 1 to modify the last three items in the System Group.

## Submission
1. Includes:
   - All source files (HTML, PHP, Java, JSP, Servlet).
   - Required configurations.
   - Optional: Video demonstration (if required by the instructor or TA).

2. Collaboration:
   - Project can be done individually or in groups of 2.
