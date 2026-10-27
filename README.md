# organization-sync-service
Spring Boot service for organization and permission synchronization

## Overview
This service implements organization and permission data synchronization.
When the user clicks the sync button on the frontend page, frontend sends user information to the backend.
The backend queries the complete associated data including user profile, departments/groups, roles, menus and permissions, assembles relational data, and persists them into the target business database.

## Core Workflow
1. Frontend triggers synchronization and passes user information
2. Backend loads related resources: user, department, group, role, menu, permission
3. Build relationships: user-group, user-role, role-menu, role-permission
4. Insert or update records in the target database
5. Generate audit logs for every sync operation

## Tech Stack
- Java + Spring Boot
- JDBC
- MySQL
- Permission model assembly
- Audit logging

## Function Description
- handleUserInfo: Load basic user information
- handleUserGroup: Process user’s organization / department
- handleRole: Bind user roles
- handleDepartment: Maintain department hierarchy
- handleMenu: Load menus associated with roles
- handlePermission: Load permission sets for roles
- syncGroupBind: Maintain binding relations between users and groups

## Design Note
This service acts as a synchronization layer between the identity source and the target business system.
It synchronizes the full permission model to keep organization, role, menu and permission data consistent across systems.
